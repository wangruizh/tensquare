package com.eloan.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eloan.base.domain.Account;
import com.eloan.base.mapper.AccountMapper;
import com.eloan.base.service.AccountService;


@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountMapper accountMapper;

	@Override
	public Account get(Long id) {
		// TODO Auto-generated method stub
		return accountMapper.selectByPrimaryKey(id);
	}
	
	

}
