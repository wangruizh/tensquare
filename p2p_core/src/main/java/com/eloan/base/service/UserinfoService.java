package com.eloan.base.service;

import com.eloan.base.domain.Userinfo;

public interface UserinfoService {

	Userinfo get(Long id);

	void updateUserInfo(String realname, String idNumber);


	void save(Userinfo userinfo);
}
