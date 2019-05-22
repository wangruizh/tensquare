package com.eloan.base.mapper;

import java.util.List;

import com.eloan.base.domain.SystemDictionaryItem;

public interface SystemdictionaryitemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SystemDictionaryItem record);

    SystemDictionaryItem selectByPrimaryKey(Long id);

    List<SystemDictionaryItem> selectAll();

    int updateByPrimaryKey(SystemDictionaryItem record);
}