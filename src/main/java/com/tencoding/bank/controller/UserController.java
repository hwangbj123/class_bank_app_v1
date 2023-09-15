package com.tencoding.bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tencoding.bank.dto.SignUpFormDto;

@Controller
@RequestMapping("/user")
public class UserController {

	// 회원 가입 페이지 요청
	// 주소 설계 : http://localhost:80/user/sign-up
	@GetMapping("/sign-up")
	public String signUp() {
		
		// prefix : /WEB-INF/view/
		// return : user/signUp
		// suffix : .jsp
		return "user/signUp";
	}
	
	// 로그인 페이지 요청
	// 주소 설계 : http://localhost:80/user/sign-in
	@GetMapping("/sign-in")
	public String signIn() {
		
		return "user/signIn";
	}
	
	// 회원 가입 처리
	// http://localhost:80/user/sign-up
	// POST -> HTTP body 에 데이터 담아 전송
	// name 속성과 매핑되어
	// key=value 형식으로 데이터 파싱
	@PostMapping("/sign-up")
	public String signUpProc(SignUpFormDto signUpFormDto) { // <- 메시지 컨버터, 오브젝트 매퍼 개념
		System.out.println("signUpFormDto : "+ signUpFormDto.toString());
		// 1. 유효성 검사
		// 2. 사용자 이미지 처리
		// 3. 서비스 호출
		// 4. 정상 처리 -> 웹 브라우저( 로그인 페이지 )에 리턴
		return "redirect:/user/sign-in";
	}
}
