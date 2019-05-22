package com.eloan.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eloan.base.domain.IpLog;
import com.eloan.base.mapper.IplogMapper;
import com.eloan.base.query.IpLogQueryObject;
import com.eloan.base.query.PageResult;
import com.eloan.base.service.IpLogService;

@Service
public class IpLogServiceImpl implements IpLogService {
	
	@Autowired
	private IplogMapper iplogMapper;

	@Override
	public PageResult query(IpLogQueryObject qo) {
		// TODO Auto-generated method stub
		int totalCount = iplogMapper.queryForCount(qo);
		if (totalCount > 0) {
			List<IpLog> list = this.iplogMapper.query(qo);
			return new PageResult(qo.getCurrentPage(),totalCount,qo.getPageSize(),list);
		}
		return PageResult.empty(qo.getPageSize());
	}

}
