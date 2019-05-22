package com.eloan.base.domain;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Alias("SystemDictionary")
public class SystemDictionary {
	// 编码
	private String sn;
	// 名称
	private String title;
	// 简介
	private String intro;
	
}
