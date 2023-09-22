package com.tencoding.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tencoding.bank.dto.SignInFormDto;
import com.tencoding.bank.dto.SignUpFormDto;
import com.tencoding.bank.handler.exception.CustomRestfulException;
import com.tencoding.bank.repository.interfaces.UserRepository;
import com.tencoding.bank.repository.model.User;

@Service // IoC 대상 - 싱글톤 패턴
public class UserService {
	
	// Dao - 데이터베이스 연습
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	/**
	 * 회원 가입
	 * 비밀번호 암호화 처리
	 * @param signUpFormDto
	 */
	@Transactional
	// Transaction 사용하는 이유
	// : 정상처리 될 경우 commit( 반영 ) 한다
	// : 정상처리 안 될 경우 rollback( 취소 ) 한다
	public void signUp(SignUpFormDto signUpFormDto) {
		
		String rawPwd = signUpFormDto.getPassword();
		String hashPwd = passwordEncoder.encode(rawPwd); // Hashing
		
//		System.out.println("rawPwd : " + rawPwd);
//		System.out.println("hashPwd : " + hashPwd);
		
		signUpFormDto.setPassword(hashPwd);
		
		int result = userRepository.insert(signUpFormDto);
		if(result != 1) {
			throw new CustomRestfulException("회원가입실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// 로그인 서비스 처리
	public User signIn(SignInFormDto signInFormDto) {
		User userEntity = userRepository.findByUsernameAndPassword(signInFormDto);
		if(userEntity == null) {
			throw new CustomRestfulException("아이디 혹은 비밀번호가 틀렸습니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return userEntity;
		
	}
	
}
