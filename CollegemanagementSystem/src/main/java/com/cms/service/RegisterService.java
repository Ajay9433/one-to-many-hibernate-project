package com.cms.service;

import com.cms.entity.Admin;

public interface RegisterService {
	void registerService(Admin client);

	Admin loginService(String email);
}
