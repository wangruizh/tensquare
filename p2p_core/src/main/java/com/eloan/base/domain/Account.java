package com.eloan.base.domain;

import java.math.BigDecimal;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("Account")
public class Account extends BaseDomain{
 
	private Long id;
	// 版本号
	private int version;
	
	// 交易密码
	private String tradepassword;
	
	// 可用余额
	private BigDecimal usableAmount = BidConst.ZERO;
	
	// 冻结金额
	private BigDecimal freezedAmount = BidConst.ZERO;
	
	// 账户代收利息
	private BigDecimal unReceiveInterest = BidConst.ZERO;
	
	// 账户代收本金                   
	private BigDecimal unReceivePrincipal = BidConst.ZERO; 
	
	// 账户代还金额
	private BigDecimal unReturnAmount = BidConst.ZERO;
	
	// 账户剩余授信额度
	private BigDecimal remainBorrowLimit = BidConst.ZERO;
	
	// 授信额度
	private BigDecimal borrowLimitAmount;
	
	
	private BigDecimal totalAmount;
	
	
	public static Account empty(Long id){
	 Account empty = new Account();
	 empty.setId(id);
	 empty.setRemainBorrowLimit(BidConst.BORROW_LIMIT);
	 empty.setBorrowLimitAmount(BidConst.BORROW_LIMIT);
	 return empty;
   }
}