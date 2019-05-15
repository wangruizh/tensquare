package com.eloan.base.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Account {
    private Long id;

    private String tradepassword;

    private BigDecimal usableamount;

    private BigDecimal freezedamount;

    private BigDecimal borrowlimitamount;

    private Integer version;

    private BigDecimal unreceiveinterest;

    private BigDecimal unreceiveprincipal;

    private BigDecimal unreturnamount;

    private BigDecimal remainborrowlimit;


}