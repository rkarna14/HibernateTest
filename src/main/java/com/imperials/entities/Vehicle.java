/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imperials.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Administrator
 */
@Entity
//@SequenceGenerator(initialValue = 1, allocationSize = 1,
//        name = "idgen", sequenceName = "account_vehicle_id_seq")
@Table(name = "vehicle")
public class Vehicle extends BaseEntity{
    
    @Column(name="name")
    private String name;
    @Column(name="category")
    private String category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    
}
