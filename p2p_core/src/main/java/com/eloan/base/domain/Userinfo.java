package com.eloan.base.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("Userinfo")
public class Userinfo {
    private Long id;

    private Integer version;

    private Long bitstate;

    private String realname;

    private String idnumber;

    private String phonenumber;

    private Long incomegradeId;

    private Long marriageId;

    private Long kidcountId;

    private Long educationbackgroundId;

    private Long houseconditionId;

    private Integer authscore;

    private Long realauthid;

    private String email;

    private boolean realauth;


}