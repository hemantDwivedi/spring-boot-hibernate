package com.learning.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentModuleApplication.class, args);

//		Configuration configuration = new Configuration().configure().addAnnotatedClass(Student.class);
//		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
//		Session session = sessionFactory.openSession();
	}

}
