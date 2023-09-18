package com.tencoding.bank.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tencoding.bank.dto.SignInFormDto;
import com.tencoding.bank.dto.SignUpFormDto;
import com.tencoding.bank.repository.model.User;

@Mapper // Mapper 반드시 기술해주어야 동작 , ibatis -> v2.4 이후부터 -> MyBatis
public interface UserRepository {
	// 뱅크 앱 -> 유저와 관련된 기술
	// -> ex) 회원가입 등
	
	public int insert(SignUpFormDto dto);	// int : 생성 성공하면 1 반환
	public int updateById(User user); // 결과에 상관없이 무조건 성공값(1) 반환
	public int deleteById(Integer id);
	public User findById(Integer id); // 리턴타입 -> User
	
	// 관리자 -> 회원정보 리스트 조회 ?
	// 전체 조회 : 리턴 타입 -> 다중 행 자료 구조
	public List<User> findAll(); // Generic = User
	public User findByUsernameAndPassword(SignInFormDto signInFormDto);
}
