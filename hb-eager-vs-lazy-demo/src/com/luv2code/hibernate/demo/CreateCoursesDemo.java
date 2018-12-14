package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCoursesDemo {

	public static void main(String[] args) {
		
			SessionFactory factory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Instructor.class)
											.addAnnotatedClass(InstructorDetail.class)
											.addAnnotatedClass(Course.class)
											.buildSessionFactory();
			
			
			Session session = factory.getCurrentSession();
		
			try {
				Instructor tempInstructor = new Instructor("Susan", "Public", "susan.pulic@luv2code.com");
				
				InstructorDetail tempInstructorDetail = 
						new InstructorDetail(
								"http://www.luv2code.com/youtube",
								"Gamer");
				
				tempInstructor.setInstructorDetail(tempInstructorDetail);				
				
				session.beginTransaction();
				session.save(tempInstructor);

			 
				session.getTransaction().commit();
				
				
				System.out.println("Done");
			}
			finally {
				session.close();
				factory.close();
			}
	}

}
