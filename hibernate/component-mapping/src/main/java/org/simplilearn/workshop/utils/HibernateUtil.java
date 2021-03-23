package org.simplilearn.workshop.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static StandardServiceRegistry standardServiceRegistry;
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				// create a standard service registry
				standardServiceRegistry = new StandardServiceRegistryBuilder()
						.configure().build();
				
				//create a meta data sources
				MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
				
				//create a meta data
				Metadata metadata = metadataSources.getMetadataBuilder().build();
				
				sessionFactory = metadata.getSessionFactoryBuilder().build();
			}catch(Exception e) {
				e.printStackTrace();
				if (standardServiceRegistry != null) {
					StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
				}
			}
		}
		return sessionFactory;
		
	}
}
