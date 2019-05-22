package com.eloan.base.service;

import com.eloan.base.query.IpLogQueryObject;
import com.eloan.base.query.PageResult;

public interface IpLogService {
	
	
	
	/**
	 * 
	 * @param ipLogQueryObject
	 * @return
	 */
	public PageResult query(IpLogQueryObject ipLogQueryObject);
}
