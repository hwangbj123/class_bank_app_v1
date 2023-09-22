package com.tencoding.bank.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tencoding.bank.dto.HistoryDto;
import com.tencoding.bank.repository.model.History;

@Mapper
public interface HistoryRepository {
	
	public int insert(History history);
	public int updateById(History history);
	public int deleteById(Integer id);

	// 입출금 내역 wAccountId = id || dAccountId = id 
	public List<History> findById(Integer id);
	public List<History> findAll();
	
	// 입금 내역 -> wAccountId = id
	public List<History> findByWAccountId(Integer id);
	// 출금 내역 -> dAccountId = id
	public List<History> findByDAccountId(Integer id);

	public List<HistoryDto> findByHistoryType(Integer id, String type);
}
