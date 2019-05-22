package com.eloan.base.domain;

import java.math.BigDecimal;

public interface BidConst {
	// 显示精度
	public static final int DISP_SCALE = 2;
	
	// 数据保存精度
	public static final int SCALE = 4;
	
	// 数据计算过程中的精度
	public static final int CAL_SCALE = 8;
	
	public static final BigDecimal ZERO = new BigDecimal("0.0000");
	
	//初始信用额度
	public static final BigDecimal BORROW_LIMIT = new BigDecimal("2000.0000");
}
