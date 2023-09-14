package com.tencoding.bank.repository.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Account {
	
	private Integer id;
	private String number;
	private String password;
	private Long balance; // Long : long wrapper 클래스
	private Integer userId;
	private Timestamp createdAt;
	
	// 출금 기능
	public void withdraw(Long amount) {
		this.balance -= amount;
	}
	
	// 입금 기능
	public void deposit(Long amount) {
		this.balance += amount;
	}
	
	// TODO : 추후 개발 예정 ( 나중에 확인 가능 )
	// 그 외 추가 기능 : 패스워드 체크 / 잔액 조회 / 계좌 소유자 확인 / ...
}
