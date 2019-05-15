package com.eloan.uiweb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eloan.base.domain.Logininfo;
import com.eloan.base.service.LogininfoService;
import com.eloan.base.util.MD5;
import com.eloan.base.util.ResultJSON;
import com.eloan.base.util.UserContext;


@Controller
public class LoginController {

	@Autowired
	private LogininfoService logininfoService;
	
	@RequestMapping("/login")
	@ResponseBody
	public ResultJSON login(String username, String password,HttpServletRequest request) {
		ResultJSON json = new ResultJSON();
		Logininfo login = this.logininfoService.login(username, MD5.encode(password),
				Logininfo.USERTYPE_NORMAL,request.getRemoteAddr());
		if (login != null) {
			json.setSuccess(true);
			UserContext.putLogininfo(login);
		} else {
			json.setMsg("用户名或者密码错误!");
		}
		return json;
	}
}
