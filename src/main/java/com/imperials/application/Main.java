/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imperials.application;

import com.imperials.entities.Address;
import com.imperials.entities.Applicant;
import com.imperials.entities.UserDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Administrator
 */
public class Main {
    public static void main(String[] args){
        System.out.println("Hello world");
        
//        User user = new User();
//        user.setUserName("Shayam Bhandari");
//        

        Applicant applicant = new Applicant();
        applicant.setFirstName("Anish");
        
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(applicant);
        session.getTransaction().commit();
        
        Address address = new Address();
        address.setDistrict("Narayani");
        address.setStreet("New Road");
        
        UserDetail user = new UserDetail();
        user.setUserName("Rajiv");
        user.setAddress(address);
        
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        
        user = null;
//        session = sessionFactory.openSession();
        session.beginTransaction();
        user = (UserDetail) session.get(UserDetail.class, 452);
        session.getTransaction().commit();
        System.out.println(""+user.getUserName());
        
        
        
    }
}
