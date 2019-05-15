package com.eloan.base.service;

import com.eloan.base.domain.Logininfo;

public interface LogininfoService {
	
	/**
	 * 注册方法
	 * @param username 用户名
	 * @param password 密码
	 */
	public void register(String username,String password);

	/**
	 * 判断用户名是否被占用
	 * @param username
	 * @return int
	 */
	public int getCountByUserName(String username);
	
	/**
	 * 用户登录接口
	 * @param username 用户名
	 * @param password 密码
	 * @param usertype 用户类型
	 * @param ip 
	 * @return
	 */
	Logininfo login(String username, String password, int usertype,String ip);

}
