package com.tencoding.bank.handler;

import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tencoding.bank.handler.exception.CustomRestfulException;

/**
 *  예외 발생 시 
 *  Json, Xml 데이터를 가공해서 내려줄 수 있다
 */
@RestControllerAdvice
@Order(1)
// IoC 대상 ( 메모리에 자동으로 올라감 ) + AoP 대상 ( 조금 다르긴 함 )
public class MyRestfulExceptionHandler {

//	@ExceptionHandler(Exception.class)
//	public void exception(Exception e) {
//		System.out.println("===== 예외 발생 확인 =====");
//		System.out.println(e.getMessage());
//		System.out.println("------------------------");
//	}
	
	// 사용자 정의 예외 클래스 활용
	@ExceptionHandler(CustomRestfulException.class)
	public String basicException(CustomRestfulException e) {
		// String <-- 메모리 계속 점유 : 효율 감소
		// StringBuffer <-- 메모리 한 공간만 차지
		StringBuffer sb = new StringBuffer();
		sb.append("<script>");
		sb.append("alert( ' "+e.getMessage()+" ' );"); // 문자열 안에 반드시 ; 붙이기
		sb.append("history.back();"); // 예외 발생 시 alert 창 + 뒤로가기
		sb.append("</script>");
		return sb.toString(); // StringBuffer -> String
	}
	
}
