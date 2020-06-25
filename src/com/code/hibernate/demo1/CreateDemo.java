package com.code.hibernate.demo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateDemo {

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
			
			// create student object
			System.out.println("Creating a new Instructor and InstructorDetail object....");
			Instructor tempInstructor = new Instructor("Jimmy", "Karl", "jimy_p25@gmail.com");
			InstructorDetail tempDetail = new InstructorDetail("singing video", "cooking ");
			
			//associate the objects
			tempInstructor.setInstructorDetailId(tempDetail);  // make an insertion in FKey
			
			//start the transaction
				session.beginTransaction();
			
			//save the instructor and this will automatically save instructor detail object too due to CascadeType.ALL
			System.out.println("saving the Instructor object.....");
			session.save(tempInstructor);
			
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		
		finally {
		factory.close();
		
	}
	}
}

	
	
	