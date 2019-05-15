package com.eloan.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eloan.base.domain.Logininfo;
import com.eloan.base.mapper.LogininfoMapper;
import com.eloan.base.service.LogininfoService;
import com.eloan.base.util.MD5;


@Service
public class LogininfoServiceImpl implements LogininfoService {

	@Autowired
	private LogininfoMapper logininfoMapper;
	
	@Override
	public void register(String username, String password) {
		// 判断用户名是否被占用
		int count = this.logininfoMapper.getCountByUserName(username);
		if (count<= 0) {
			// 新增用户
			Logininfo info = new Logininfo();
			info.setUsername(username);
			info.setPassword(MD5.encode(password));
			info.setState(Logininfo.STATE_DELETE);
			info.setUsertype(Logininfo.USERTYPE_NORMAL);
			this.logininfoMapper.insert(info);
			// V2.0需求：注册时需要新增对应用户的资金记录和认证记录
			// 修改时间：2019-5-14
			// 修改人：仵志松
			// V2.0 begin
//			Account account = new Account();
//			Userinfo userinfo = new Userinfo();
			// V2.0 end
		} else {
			throw new RuntimeException("用户名已存在");
		}
	}

	@Override
	public int getCountByUserName(String username) {
		return logininfoMapper.getCountByUserName(username);
	}
	
	
	@Override
	public Logininfo login(String username, String password, int usertype, String ip) {
		Logininfo info = this.logininfoMapper.selectByUserNameAndPwd(username,password,usertype);
		return info;
	}

}
