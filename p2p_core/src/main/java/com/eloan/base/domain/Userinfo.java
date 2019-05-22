package com.eloan.base.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("Userinfo")
public class Userinfo  extends BaseDomain{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1282935529123653459L;
	
	private Long id;	
	   // 版本号
	   private int version;
	   // 位状态
	   private Long bitState;
	   // 对应实名认证中的真实姓名
	   private String realName;
	   // 对应实名认证中的身份证号
	   private String idNumber;
	   // 手机号
	   private String phoneNumber;
	   // =========会员基本资料============
	   // 月收入
	   private SystemDictionaryItem incomeGrade;
	   // 婚姻情况
	   private SystemDictionaryItem marriage;
	   // 子女情况
	   private SystemDictionaryItem kidCount;
	   // 学历
	   private SystemDictionaryItem educationBackground;
	   // 住房条件
	   private SystemDictionaryItem houseCondiion;
	   
	   private Long authScore;
	   
	   private Long realauthId;
	   
	   private String email;
	   
	   private boolean bindPhone;
	   
	   private boolean bindEmail;
	   
	   private boolean realAuth;

	   private Long incomegradeId;

	   private Long marriageId;

	   private Long kidcountId;

	   private Long educationbackgroundId;

	   private Long houseconditionId;


	   

	   public static Userinfo empty(Long id){
		   Userinfo empty = new Userinfo();
		   empty.setId(id);
		   return empty;
	   }
   
}