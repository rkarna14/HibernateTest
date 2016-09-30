/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imperials.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author YCO
 */
@Entity
//@SequenceGenerator(initialValue = 1, allocationSize = 1,
//        name = "idgen", sequenceName = "account_user_id_seq")
@Table(name = "applicant")
public class Applicant extends BaseEntity {

    private static final long serialVersionUID = 2016060112249L;
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;
    @Column(name = "LAST_NAME", nullable = true)
    private String lastName;
    @Column(name = "EMAIL", nullable = true)
    private String email;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "CONTACT_NUMBER", nullable = true)
    private String contactNumber;
    @Column(name = "CV_LINK", nullable = true)
    private String cvLink;

    
    public Applicant() {
        super();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getCvLink() {
        return cvLink;
    }

    public void setCvLink(String cvLink) {
        this.cvLink = cvLink;
    }

    public String getApplicantName() {
        return this.firstName + ' ' + this.lastName;
    }

    
    @Override
    public String toString() {
        return Applicant.class + "-" + super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object other) {
        return (id != null && other != null && getClass() == other.getClass())
                ? id.equals(((Applicant) other).getId())
                : (other == this);
    }

    @Override
    public int hashCode() {
        return (id != null)
                ? (getClass().hashCode() + id.hashCode())
                : super.hashCode();
    }

}
