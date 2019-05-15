package com.eloan.base.mapper;

import com.eloan.base.domain.Logininfo;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface LogininfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Logininfo record);

    Logininfo selectByPrimaryKey(Long id);

    List<Logininfo> selectAll();

    int updateByPrimaryKey(Logininfo record);

	int getCountByUserName(@Param("username")  String username);

    Logininfo selectByUserNameAndPwd(@Param("username")String username,@Param("password") String password,@Param("usertype")  int usertype);
    
    
    
}