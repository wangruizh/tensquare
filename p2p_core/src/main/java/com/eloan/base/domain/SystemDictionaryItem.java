package com.eloan.base.domain;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Alias("SystemDictionaryItem")
public class SystemDictionaryItem {
	
	// 系统名称
	private Long parentId;
	
	// 名称
	private String title;
	
	// 值
	private String tvalue;
	
	// 说明
	private String intro;
	
	// 序列
	private Integer sequence;
}
