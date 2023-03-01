package com.example.account.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

import com.example.account.dto.Account;
import com.example.account.exception.ResourceNotFoundException;
import com.example.account.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	private AccountService accountService;

	@PostMapping("/create")
	public Account createAccount(@RequestBody Account Account) {
		LOG.info("Request received to the controller");
		List<Account> accountList = accountService.addNewAccount(Account);
		return accountList.get(accountList.size() - 1);
	}

	@GetMapping("/getAllaccounts")
	public List<Account> getAllAcoounts() {
		LOG.info("Request received to the controller");
		return accountService.getAllAcoounts();
	}

	@GetMapping(path = "/{id}")
	public Account getAccount(@PathVariable int id) {
		LOG.info("Request received to the controller");
		return accountService.searchAccount(id);
	}

	@DeleteMapping(path = "/{id}")
	public String removeAccount(@PathVariable int id) {
		String resMsg = "";
		LOG.info("Request received to the controller");
		Boolean isdeleted = accountService.removeAccount(id);
		if(isdeleted) {
			resMsg = "Account deleted successfully";
		}else {
			resMsg = "Account not found with given id : "+id;
		}
		return resMsg;
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Account> updateAccount(@PathVariable(value = "id") int id,
			@RequestBody Account accountDetails) throws ResourceNotFoundException {
		LOG.info("Request received to the controller");
		List<Account> updatedAccountList = accountService.updateAccount(id, accountDetails);
		Optional<Account> oacc = updatedAccountList.stream().filter(a -> a.getAccountId()==id).findFirst();
		return ResponseEntity.ok(oacc.get());
	}

}
