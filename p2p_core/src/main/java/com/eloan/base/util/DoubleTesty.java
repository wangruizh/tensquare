package com.eloan.base.util;

import java.math.BigDecimal;

public class DoubleTesty {

	public static void main(String [] args){
		BigDecimal a = new BigDecimal("24532.23");
		BigDecimal b = new BigDecimal("24532.23");
		System.out.println(a.add(b));
	}
}
