package com.eloan.uiweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eloan.base.domain.Logininfo;
import com.eloan.base.service.AccountService;
import com.eloan.base.service.UserinfoService;
import com.eloan.base.util.UserContext;

@Controller
public class PersonalController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private UserinfoService userinfoService;
	
	@RequestMapping("/personal")
	public String personal(Model model) {
		Logininfo current = UserContext.getCurrent();
		model.addAttribute("userinfo", userinfoService.get(current.getId()));
		model.addAttribute("account", accountService.get(current.getId()));
		// 调试时间： 16.42
		// 用途： 测试是否经过此处，是否查询到数据
		System.out.println(model);
		return "personal";
	}
	
}
