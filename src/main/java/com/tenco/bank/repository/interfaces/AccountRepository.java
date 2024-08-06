package com.tenco.bank.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tenco.bank.repository.model.Account;

@Mapper
public interface AccountRepository {
	public int insert(Account account);
	public int updateById(Account account);
	public int deleteById(Integer id, String name);
	
	// 고민! - 계좌 조회
	// --> 한사람에 유저는 여러개의 계좌번호를 가질 수 있다
	
	public List<Account> findByUserId(@Param("userId") Integer principalId);
	// --> account id 값으로 계좌 정보 조회
	public Account findByNumber(@Param("number") String id);
}