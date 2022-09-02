package com.cms.daoimpl;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cms.config.HibernateUtil;
import com.cms.dao.RegisterDAO;
import com.cms.entity.Admin;

//implementing InstructorDAO interface and defining all methods
public class RegisterDAOImpl implements RegisterDAO {

	// implemention of register method from RegisterDAO interface
	@Override
	public void register(Admin client) {
		System.out.println("in dao");

		Session s = HibernateUtil.getSession();
		Transaction t = s.beginTransaction();

		int f = (Integer) s.save(client);

		t.commit();

		s.close();
		System.out.println("dao done for the client Primary Key " + client.getUid());
	}

	// implemention of login method from RegisterDAO interface

	@Override
	public Admin login(String email) {
		Session s = HibernateUtil.getSession();
		System.out.println(s);
		Admin r = (Admin) s.get(Admin.class, Integer.parseInt(JOptionPane.showInputDialog("enter Admin id")));
		return r;
	}

}
