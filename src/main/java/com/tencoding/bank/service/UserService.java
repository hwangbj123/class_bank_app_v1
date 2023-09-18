package com.tencoding.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tencoding.bank.dto.SignUpFormDto;
import com.tencoding.bank.handler.exception.CustomRestfulException;
import com.tencoding.bank.repository.interfaces.UserRepository;

@Service // IoC 대상 - 싱글톤 패턴
public class UserService {
	
	// Dao - 데이터베이스 연습
	@Autowired
	private UserRepository userRepository;
	
	// DI - 가지고 오다
//	public UserService(UserRepository userRepository) {
//		this.userRepository = userRepository;
//	} // Autowired 로 대체
	
	@Transactional
	// Transaction 사용하는 이유
	// : 정상처리 될 경우 commit( 반영 ) 한다
	// : 정상처리 안 될 경우 rollback( 취소 ) 한다
	public void signUp(SignUpFormDto signUpFormDto) {
		int result = userRepository.insert(signUpFormDto);
		System.out.println("result : "+result);
		if(result != 1) {
			throw new CustomRestfulException("회원가입실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
