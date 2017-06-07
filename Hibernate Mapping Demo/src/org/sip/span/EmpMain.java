package org.sip.span;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class EmpMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.configure("hibernate.cfg.xml");
		config.addAnnotatedClass(Employee.class);
		
		new SchemaExport(config).create(false, true);
		
		/*SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Employee emp = new Employee();
		emp.setEmployeeName("SomeName");
		emp.setEmpPassword("Pass");
		emp.setEmpEmail("somename@abc.com");
		emp.setEmpJoinDate(Calendar.getInstance());
		emp.setEmpLoginTime(new Date());
		
		Employee emp1 = new Employee();
		emp1.setEmployeeName("SomeName");
		emp1.setEmpPassword("Pass");
		emp1.setEmpEmail("somename@abc.com");
		emp1.setEmpJoinDate(Calendar.getInstance());
		emp1.setEmpLoginTime(new Date());
		
		Employee emp2 = new Employee();
		emp2.setEmployeeName("SomeName");
		emp2.setEmpPassword("Pass");
		emp2.setEmpEmail("somename@abc.com");
		emp2.setEmpJoinDate(Calendar.getInstance());
		emp2.setEmpLoginTime(new Date());
		
		session.save(emp);
		session.save(emp1);
		session.save(emp2);
		session.getTransaction().commit();
*/
	}

}

