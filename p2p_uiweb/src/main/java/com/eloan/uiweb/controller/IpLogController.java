package com.eloan.uiweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eloan.base.domain.Logininfo;
import com.eloan.base.query.IpLogQueryObject;
import com.eloan.base.service.IpLogService;
import com.eloan.base.util.UserContext;

@Controller
public class IpLogController {

	@Autowired
	private IpLogService ipLogService;
	
	@RequestMapping("/iplog")
	public String ipLog(IpLogQueryObject qo,Model model){
		qo.setUsername(UserContext.getCurrent().getUsername());
		qo.setLike(false);
		qo.setUserType(Logininfo.USERTYPE_NORMAL);
		model.addAttribute("pageResult",this.ipLogService.query(qo));
		System.out.println(this.ipLogService.query(qo));
		return "iplog_list";
	}
}
