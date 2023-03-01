package com.example.account.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.account.repository.AccountRepository;
import com.example.account.avro.AccountInfo;
import com.example.account.dto.Account;
import com.example.account.exception.ResourceNotFoundException;

@Service
public class AccountService {
	
    private static final Logger logger = LoggerFactory.getLogger(AccountService.class);

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@Autowired
	private KafkaTemplate<String, AccountInfo> template;

    @Cacheable(key = "'allAcc'", value = "allAccCache")
	public List<Account> getAllAcoounts() {
		logger.info("fetching values from database");
		return accountRepository.findAll();
	}

    @Cacheable(key = "#accountId", value = "oneAccSearchCache")
	public Account searchAccount(int accountId) {
		logger.info("fetching values from database");
		return accountRepository.findById(accountId).orElseThrow(NullPointerException::new);
	}

    @CachePut(key = "'allAcc'", value = "allAccCache")
	public List<Account> addNewAccount(@RequestBody Account account) {
		account.setAccountId(sequenceGeneratorService.generateSequence(Account.SEQUENCE_NAME));
		Optional<Account> accObj = Optional.ofNullable(accountRepository.save(account));
		
		if (accObj.isPresent()) {

			Account accDTO = accObj.get();

			AccountInfo accInfo = new AccountInfo();
			accInfo.setAccountId(accDTO.getAccountId());
			accInfo.setName(accDTO.getName());
			accInfo.setBalance(accDTO.getBalance());

			template.send("accInfo", accInfo);
			
			logger.info("data send to cutomer service");

		} else {
			logger.info("Not able to send data");
		}
		

		return accountRepository.findAll();
	}

    @CacheEvict(value = "allAccCache", allEntries = true)
	public boolean removeAccount(int accountId) {
		if (accountRepository.findById(accountId).isPresent()) {
			accountRepository.deleteById(accountId);
			return true;
		}
		logger.info("Account Not Found!");
		return false;
	}

    @CachePut(key = "'allAcc'", value = "allAccCache")
	public List<Account> updateAccount(int accountId, Account accDetails) throws ResourceNotFoundException {
    	logger.info("Updating the account");
		Account acc = accountRepository.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + accountId));

		acc.setName(accDetails.getName());
		acc.setBalance(accDetails.getBalance());
		accountRepository.save(acc);
		return accountRepository.findAll();
	}

}
