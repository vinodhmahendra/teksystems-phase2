package org.simplilearn.workshop;

import java.util.Date;

import org.hibernate.Session;
import org.simplilearn.workshop.model.User;
import org.simplilearn.workshop.model.UserHistory;
import org.simplilearn.workshop.utils.HibernateUtil;

public class Program {

	public static void main(String[] args) {
		System.out.println("hibernate configuration setup initaited -->");

		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("session was created successfully");

		session.beginTransaction();
		System.out.println("Begin Hibernate Transaction");

		User user = new User();
		user.setName("vinodh mahendra");
		user.addHistory(new UserHistory(new Date(),"set name to vinodh"));
		user.setGoal(250);
		user.addHistory(new UserHistory(new Date(),"set the goal to 250"));

		session.save(user);
		System.out.println("user is in persistent context");

		session.getTransaction().commit(); 
		System.out.println("user is inserted in database..");
		
		//getting data back
		
		session.beginTransaction(); 
		
		User loadedUser = (User) session.get(User.class, 1);
		
		System.out.println(" Name : " + loadedUser.getName());
		System.out.println(" Goal : " + loadedUser.getGoal());
		
		for(UserHistory history : loadedUser.getHistory()) {
			System.out.println(history.getEntryTime().toString() + "  " + history.getEntry());
		}
		
		//manipulate the loaded user
		loadedUser.setTotal(50);
		loadedUser.addHistory(new UserHistory(new Date(),"Added 50 protein"));
		
		// auto updating
		session.getTransaction().commit();
		
		session.close();
		System.out.println("session is closed.");
		System.out.println("configuration was successfully completed");

	}

}
