package com.code.hibernate.demo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteInstructorDetailDemo {

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

				//get instructor detail object
				int theId=3;
				InstructorDetail tempDetail =session.find(InstructorDetail.class, theId);
				
				//print instructor detail object
				System.out.println("Instructor detail object is ==>"+tempDetail);
				
				
				//print associated instructor
				System.out.println("Associated Instructor of the given details is ==>"+tempDetail.getInstructor());
				
				//now lets delete instructor detail
				System.out.println("Delete TempDetail..."+tempDetail );
				
				//remove the associated object reference
				//break bi directional link
				tempDetail.getInstructor().setInstructorDetailId(null); // breaking two way link, otherwise wont get deleted
				
				
				session.delete(tempDetail);
				
				
				
				
				
				
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		catch(Exception e){
			e.printStackTrace();
			
			
		}
		finally {
		session.close();
		factory.close();
		
	}
	}
}

	
	
	