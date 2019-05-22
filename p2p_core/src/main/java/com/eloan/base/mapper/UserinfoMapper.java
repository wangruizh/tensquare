package com.eloan.base.mapper;

import com.eloan.base.domain.Userinfo;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserinfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Userinfo record);

    Userinfo selectByPrimaryKey(Long id);

    List<Userinfo> selectAll();

    int updateByPrimaryKey(Userinfo record);

	void updateByPrimaryKey(@Param("id") Long id, @Param("realname") String realname, @Param("idNumber") String idNumber);
}