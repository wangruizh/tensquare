package com.eloan.base.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("IpLog")
public class IpLog extends BaseDomain {
	

	

	private static final long serialVersionUID = -6034493371522178202L;
	
	// 登陆成功
	public static final int LOGIN_SUCCESS = 1;
	
	// 登陆失败
	public static final int LOGIN_FAIL = 0;
	
	
	private Long id;

	// IP地址
    private String ip;

    // 登陆状态
    private int loginstate = LOGIN_SUCCESS;

    // 用户名
    private String username;

    // 登陆用户id
    private Long logininfoid;

    // 登陆用户类型
    private int logintype;

    private Date logintime;
    
    
	public IpLog (){
		super();
	}
	
    public IpLog(String ip, int loginstate, String username, Long logininfoid, int logintype) {
		// TODO Auto-generated constructor stub
    	this.ip = ip;
    	this.loginstate = loginstate;
    	this.username = username;
    	this.logininfoid = logininfoid;
    	this.logintype = logintype;
	}
	
}
