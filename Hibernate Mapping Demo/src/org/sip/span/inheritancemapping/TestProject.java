package org.sip.span.inheritancemapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestProject {
	
public static void main(String[] args) {
		
		AnnotationConfiguration config = new AnnotationConfiguration();
		
		config.addAnnotatedClass(Project.class);
		config.addAnnotatedClass(Module.class);
		config.addAnnotatedClass(Task.class);
		config.configure("hibernate.cfg.xml");
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Project proj = new Project();
		proj.setProjName("projName");
		
		Module mod = new Module();
		mod.setProjName("modProjName");
		mod.setModName("modName");
		
		Task task = new Task();
		task.setProjName("taskProjectName");
		task.setModName("taskmodName");
		task.setTaskName("taskName");
		
		session.save(proj);
		session.save(mod);
		session.save(task);
		
		session.getTransaction().commit();
}

}
