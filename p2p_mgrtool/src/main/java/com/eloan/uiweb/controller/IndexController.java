package com.eloan.uiweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eloan.base.domain.Logininfo;
import com.eloan.base.service.UserinfoService;
import com.eloan.base.util.UserContext;


@Controller
public class IndexController extends BaseController {
	
	@Autowired
	private UserinfoService userinfoService;
	
	@RequestMapping("/index")
	public String index(Model model){
		Logininfo current = UserContext.getCurrent();
		model.addAttribute("userinfo", userinfoService.get(current.getId()));
		return "main";
	}
}
