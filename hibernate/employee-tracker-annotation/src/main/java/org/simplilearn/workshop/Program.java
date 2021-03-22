package org.simplilearn.workshop;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.simplilearn.workshop.model.Account;
import org.simplilearn.workshop.model.Employee;
import org.simplilearn.workshop.utils.HibernateUtil;

public class Program {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Account account1 = new Account();
		account1.setAccountNumber("111-1111-111111");
		
		Account account2 = new Account();
		account2.setAccountNumber("222-2222-222222");

		Employee employee = new Employee();
		employee.setEmail("vinodh.mahendra@gmail.com");
		employee.setFirstName("vinodh");
		employee.setLastName("mahendra");
		
		Set<Account> accounts = new HashSet<Account>();
		accounts.add(account1);
		accounts.add(account2);
		
		employee.setAccounts(accounts);
		
		session.save(employee);
		
		session.getTransaction().commit();
		
	}

}
