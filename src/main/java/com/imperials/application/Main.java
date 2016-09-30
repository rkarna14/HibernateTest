/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imperials.application;

import com.imperials.entities.Address;
import com.imperials.entities.Applicant;
import com.imperials.entities.UserDetail;
import com.imperials.entities.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Administrator
 */
public class Main {

    public static void main(String[] args) {
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
        session.close();

        Address address1 = new Address();
        address1.setDistrict("Narayani");
        address1.setStreet("New Road");

        Address address2 = new Address();
        address2.setDistrict("Koshi");
        address2.setStreet("Roadcess");

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setName("Ferrari");
        vehicle1.setCategory("Car");

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setName("Ducati");
        vehicle2.setCategory("Motorbike");

        UserDetail user = new UserDetail();
        user.setUserName("Rajiv");
        user.getAddresses().add(address1);
        user.getAddresses().add(address2);
        user.getVehicles().add(vehicle1);
        user.getVehicles().add(vehicle2);
//        

        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();

        user = null;

        session = sessionFactory.openSession();
        session.beginTransaction();
        user = (UserDetail) session.get(UserDetail.class, 52);
        session.getTransaction().commit();
        session.close();

        if (user != null) {
            System.out.println("" + user.getUserName());
            System.out.println("" + user.getAddresses().toArray(new Address[user.getAddresses().size()])[0].getDistrict());
        }

//        
    }
}
