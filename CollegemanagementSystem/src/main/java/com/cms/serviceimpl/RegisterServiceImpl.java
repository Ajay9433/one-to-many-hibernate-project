package com.cms.serviceimpl;

import com.cms.dao.RegisterDAO;
import com.cms.daoimpl.RegisterDAOImpl;
import com.cms.entity.Admin;
import com.cms.service.RegisterService;

public class RegisterServiceImpl implements RegisterService {

	@Override
	public void registerService(Admin client) {
		RegisterDAO dao = new RegisterDAOImpl();
		dao.register(client);

	}

	@Override
	public Admin loginService(String email) {
		RegisterDAO dao = new RegisterDAOImpl();
		return dao.login(email);
	}

}
