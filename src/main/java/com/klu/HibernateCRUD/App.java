package com.klu.HibernateCRUD;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.build.AllowSysOut;



public class App
{
  
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("Hibernate.cfg.xml").build();
        Metadata md = new MetadataSources().getMetadataBuilder(ssr).build();
        
        SessionFactory sf = md.getSessionFactoryBuilder().build();
        Session s = sf.openSession();
        Transaction t;
        
        Student s1 = new Student();
        s1.setName("Balajee");
        t = s.beginTransaction();
        s.save(s1);
        t.commit();
        System.out.println("Data Inserted");
        
        /*Acceleration ac=new Acceleration();
        ac.setName("ASHOK");
        ac.setCourse("JSFD");
        ac.setResult("PASS");
        t=s.beginTransaction();
        s.save(ac);
        t.commit();
        System.out.println("Data Inserted in Accleration");*/
        
        /*OddSemester od=new OddSemester();
        od.setName("ASHOK");
        od.setCourse("JSFD");
        od.setRegistration("YES");
        t=s.beginTransaction();
        s.save(od);
        t.commit();
        System.out.println("Data Inserted in ODD");*/
        
       /* Student s2= s.find(Student.class, 11);
        s2.setName("SASI");
        t=s.beginTransaction();
        //s.update(s2);
        s.delete(s2);
        t.commit();
        System.out.println("Deleted Successfully");*/
        
        Criteria c = s.createCriteria(Student.class);
        c.add(Restrictions.gt("id", 3));
        List<Student> l=c.list();
        for(Student s3: l) {
        	System.out.println("id = " + s3.getId() + ", name = " + s3.getName());
        	
        }
        
        Query<Student> qry = s.createQuery("select ST from Student ST where ST.id > 3", Student.class);
        List<Student> l1=qry.list();
        for(Student s3: l1) {
        	System.out.println("id = " + s3.getId() + ", name = " + s3.getName());
        	
        }
        
    }
}