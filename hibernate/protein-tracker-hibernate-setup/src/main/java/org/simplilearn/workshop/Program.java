package org.simplilearn.workshop;

import org.hibernate.Session;
import org.simplilearn.workshop.utils.HibernateUtil;

public class Program {

	public static void main(String[] args) {
		System.out.println("hibernate configuration setup initaited -->");

		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("session was created successfully");
		session.close();
		System.out.println("session is closed.");
		System.out.println("configuration was successfully completed");
		
	}

}
