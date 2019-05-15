package com.eloan.uiweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eloan.base.service.LogininfoService;
import com.eloan.base.util.ResultJSON;

@Controller
public class RegisterController {
	
	@Autowired
	private LogininfoService logininfoService;

	@RequestMapping("/checkUsername")
	@ResponseBody
	public ResultJSON checkUsername(String username,String usertype){
		ResultJSON json = new ResultJSON();
		int count = this.logininfoService.getCountByUserName(username);
		if (count > 0 ){
			json.setSuccess(false);
		} else {
			json.setSuccess(true);
		}
		return json;
	}
	
	@RequestMapping("/register")
	@ResponseBody
	public ResultJSON register(String username,String password){
		ResultJSON json = new ResultJSON();
		try {
			this.logininfoService.register(username,password);
			json.setSuccess(true);
			json.setMsg("注册成功");
		} catch(Exception e){
			e.printStackTrace();
			json.setMsg("注册失败");
		}
		return json;
		
	}
	
}
