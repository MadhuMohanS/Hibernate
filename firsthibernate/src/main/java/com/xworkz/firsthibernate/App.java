package com.xworkz.firsthibernate;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "project started" );
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//        System.out.println(factory);
//        System.out.println(factory.isClosed());
        Student student=new Student();
        student.setId(102);
        student.setName("Mohan");
        student.setCity("davangere");
       
        Certificate certificate=new Certificate();
        certificate.setCourse("java hibernate");
        certificate.setDuration("3months");
        
        student.setCerti(certificate);
        
        System.out.println(student);
        
        Address address=new Address();
        address.setStreet("M B kere");
        address.setCity("davangere");
        address.setOpen(true);
        address.setX(123.23);
        address.setAddedDate(new Date());
        
        FileInputStream fis=new FileInputStream("src/main/java/boy.jpg");
        byte[] data=new byte[fis.available()];
        fis.read(data);
        address.setImage(data);
        
        
        Session session=factory.openSession();
        Transaction tx= session.beginTransaction();
        session.save(student);
        session.save(address);
        tx.commit();
        System.out.println("data successfully inserted");
        session.close();
        
    }
}
