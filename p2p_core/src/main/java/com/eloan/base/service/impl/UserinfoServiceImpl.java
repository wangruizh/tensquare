package com.eloan.base.service.impl;

import com.eloan.base.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eloan.base.domain.Userinfo;
import com.eloan.base.mapper.UserinfoMapper;
import com.eloan.base.service.UserinfoService;


@Service
public class UserinfoServiceImpl implements UserinfoService {

	@Autowired
	private UserinfoMapper userinfoMapper;

	@Override
	public Userinfo get(Long id) {
		// TODO Auto-generated method stub
		return userinfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateUserInfo(String realname, String idNumber) {
		// TODO Auto-generated method stub
		
		Long id = UserContext.getCurrent().getId();
		userinfoMapper.updateByPrimaryKey(id,realname,idNumber);
	}

	@Override
	public void save(Userinfo userinfo) {
		userinfoMapper.updateByPrimaryKey(userinfo);
	}


}
