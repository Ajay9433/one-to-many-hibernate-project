package com.cms;

import javax.swing.JOptionPane;

import com.cms.entity.Admin;
import com.cms.service.RegisterService;
import com.cms.serviceimpl.RegisterServiceImpl;

public class App {

	// this method is responsibke for display main menu
	public static void mainFrame() {
		RegisterService registerService = new RegisterServiceImpl();
		String choice;
		while (true) {
			System.out.println("Press R for registration \n Press L for login\n Press Q for quit ");

			choice = JOptionPane.showInputDialog("Enter choice", "Type here");

			switch (choice) {
			// This menu is responsible for admin registration
			case "R":
				Admin c1 = new Admin();
				c1.setUid(999);
				c1.setName("admindata");
				c1.setEmail("admindata@gmail.com");
				c1.setPassword("12345");

				registerService.registerService(c1);
				System.out.println("---admin data saved------");
				break;

			// this option is for admin login
			case "L":

				Admin loggedClient = registerService.loginService(JOptionPane.showInputDialog("enter email"));
				if (loggedClient != null) {
					System.out.println("u are logged in " + loggedClient.toString());
					CrudOperation.crudOpeartion();
				} else {
					System.out.println("Invalid Credentials!!");
					System.exit(0);
				}
				break;

			case "Q":
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {

		mainFrame();

	}
}
