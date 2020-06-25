package com.code.hibernate.demo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteeDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
														.configure("hibernate.cfg.xml")
														.addAnnotatedClass(Instructor.class)
														.addAnnotatedClass(InstructorDetail.class)
														.buildSessionFactory();
		
		//create session
		Session session= factory.getCurrentSession();
		
		try {

			
			//start the transaction
				session.beginTransaction();

				//get instructor by primary key
				int theId = 3;
				Instructor tempInstructor= session.get(Instructor.class, theId);
				System.out.println("session. get (Instructor.class, theId)==> "+ tempInstructor);
				
				Instructor tempInstructor2= session.find(Instructor.class, theId);
				System.out.println("session. find(Instructor.class, theId)=> " +tempInstructor2);
				//delete instructor
			    
				if(tempInstructor!=null) {
					
					System.out.println("deleting==> "+"|"+tempInstructor+"|");
					session.delete(tempInstructor);  // will also delete detail obj bcoz cascade all applies to saving and deleting
				}
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		
		finally {
		factory.close();
		
	}
	}
}

	
	
	