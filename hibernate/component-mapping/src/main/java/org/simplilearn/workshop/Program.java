package org.simplilearn.workshop;

import org.hibernate.Session;
import org.simplilearn.workshop.model.User;
import org.simplilearn.workshop.utils.HibernateUtil;

public class Program {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		User user = new User();
		user.setName("Vinodh Mahendra");
		user.getProteinData().setGoal(250);
		
		session.save(user);
		
		session.getTransaction().commit();
		session.close();
		
	}

}
