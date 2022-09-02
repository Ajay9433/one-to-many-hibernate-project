package com.cms.dao;

import com.cms.entity.Admin;

public interface RegisterDAO {

	// method for Reister admin
	void register(Admin client);

	// method for login as admin
	Admin login(String email);
}
