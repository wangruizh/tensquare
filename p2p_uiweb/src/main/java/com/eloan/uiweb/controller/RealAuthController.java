package com.eloan.uiweb.controller;

import com.eloan.base.domain.Userinfo;
import com.eloan.base.util.SendNote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eloan.base.domain.Logininfo;
import com.eloan.base.service.UserinfoService;
import com.eloan.base.util.IdCardUtil;
import com.eloan.base.util.ResultJSON;
import com.eloan.base.util.UserContext;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
public class RealAuthController {
	
	@Autowired
	private UserinfoService userinfoService;
	
	
	
	@RequestMapping("/realAuth")
	private String realAuth(){

		return "realAuth";
	}
	
	
	/**
	 * 进行实名认证
	 * @param realname 真实姓名
	 * @param idNumber 身份证号
	 * @return 是否成功
	 */
	@RequestMapping("/realAuth_save")
	@ResponseBody
	private ResultJSON realAuth_save(String realname,String idNumber,HttpServletRequest request) throws UnsupportedEncodingException {



		ResultJSON json = new ResultJSON();
//		IdCardUtil idCardUtil=new IdCardUtil();
		// 进行实名认证
		// 1.将真实姓名和身份证号传递给实名认证工具类，进行实名认证
//		System.out.println(idCardUtil.realAuth(realname, idNumber));
		// 2.判断是否符合
		// 3.符合：修改用户的认证状态
		// 4.不符合：提示认证失败
		json = SendNote.sendMess(realname,idNumber);
		System.out.println("姓名："+realname+"\n身份证号："+idNumber);

		if (json.getSuccess()){
			Logininfo current = UserContext.getCurrent();
			Userinfo userinfo = userinfoService.get(current.getId());
			userinfo.setRealName(realname);
			userinfo.setIdNumber(idNumber);
			userinfoService.save(userinfo);
		}
		return json;
	}
	
	
}
