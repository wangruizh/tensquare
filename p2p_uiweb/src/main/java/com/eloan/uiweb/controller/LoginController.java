package com.eloan.uiweb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eloan.base.domain.IpLog;
import com.eloan.base.domain.Logininfo;
import com.eloan.base.mapper.IplogMapper;
import com.eloan.base.service.LogininfoService;
import com.eloan.base.util.MD5;
import com.eloan.base.util.ResultJSON;
import com.eloan.base.util.UserContext;


@Controller
public class LoginController {

	@Autowired
	private LogininfoService logininfoService;
	
	
	
	@Autowired
	private IplogMapper iplogMapper;
	
	@RequestMapping("/login")
	@ResponseBody
	public ResultJSON login(String username, String password,HttpServletRequest request) {
		ResultJSON json = new ResultJSON();
		String ip = request.getRemoteAddr();
		IpLog ipLog = new IpLog(ip,IpLog.LOGIN_FAIL,username,null,Logininfo.USERTYPE_NORMAL);
		Logininfo login = this.logininfoService.login(username, MD5.encode(password),
				Logininfo.USERTYPE_NORMAL,ip);
		if (login != null) {
			json.setSuccess(true);
			ipLog.setLoginstate(IpLog.LOGIN_SUCCESS);
			ipLog.setLogininfoid(login.getId());
			UserContext.putLogininfo(login);
		} else {
			json.setMsg("用户名或者密码错误!");
		}
		this.iplogMapper.insert(ipLog);
		return json;
	}
}
