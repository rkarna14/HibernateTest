/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imperials.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Administrator
 */
@Entity
//@SequenceGenerator(initialValue = 1, allocationSize = 1,
//        name = "idgen", sequenceName = "account_user_id_seq")
@Table(name = "user_detail")
public class UserDetail extends BaseEntity{
    
    private static final long serialVersionUID = 2016060112249L;
    
    @Column(name = "UserName", nullable = false)
    private String userName;
    
    /*
    * Creates the columns mapping the properties of the Address object
      within the UserDetail table itself
    * Can be used where one to one mapping is there or to specify main field
      e.g. Address 1 is the primary address stored within the UserDetail itself
      and other addtional addresses if available are stored 
      in a seperate table so as to reduce the hibernate overhead during eager
      load
    */
    @Embedded
    private Address address;
    
    
    /*
    * Creates a new table with name user_address such that the addresses 
      associated to a user is identified by the user_id
    * @JoinTable is an optional annotation to override the default names 
      assigned to the this table created and the primary key
    */ 
//    @ElementCollection(fetch = FetchType.LAZY)
    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name="user_address",
            joinColumns = @JoinColumn(name="user_id")
    )
    private Set<Address> addresses =  new HashSet();
    
//    @OneToOne(cascade = CascadeType.ALL)
//    private Vehicle vehicle;
    
    
    
    /*
    * cascade is used to make sure that transient object i.e. any child entities
      are saved before attempting to save parent entity
    * JoinColumn annotation is used in order to avoid creation of an 
      intermediate table by default
    */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Set<Vehicle> vehicles = new HashSet();
    
    public UserDetail(){
        super();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }   

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    
    
}
