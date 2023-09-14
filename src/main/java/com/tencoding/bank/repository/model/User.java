package com.tencoding.bank.repository.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class User {
	private Integer id; // int 의 wrapper 클래스 -> 객체로 사용하기 위함
	private String username;
	private String password;
	private String fullname;
	private Timestamp createdAt;
}
