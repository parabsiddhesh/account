package com.example.account.dto;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document (collection = "account_data")
public class Account implements Serializable {

	@Transient
	public static final String SEQUENCE_NAME = "account_sequence";

	@Id
	private long accountId;
	private String name;
	private double balance;

}
