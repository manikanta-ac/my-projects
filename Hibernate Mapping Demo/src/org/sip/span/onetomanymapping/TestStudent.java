package org.sip.span.onetomanymapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestStudent {
	public static void main(String[] args) {

		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(College.class);
		config.addAnnotatedClass(Student.class);
		config.configure("hibernate.cfg.xml");

		new SchemaExport(config).create(true, true);

		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		College college1 = new College();
		college1.setCollegeName("College One");

		Student s1 = new Student();
		s1.setStudentName("Student One");

		Student s2 = new Student();
		s2.setStudentName("Student Two");

		s1.setCollege(college1);
		s2.setCollege(college1);

		session.save(college1);
		session.save(s1);
		session.save(s2);

		session.getTransaction().commit();
	}
}
