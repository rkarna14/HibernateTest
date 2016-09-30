/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imperials.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 *
 * @author YCO
 */
@MappedSuperclass
public class BaseEntity implements Serializable {
    
    private static final long serialVersionUID = 2014051612257L;
    
    @Id
//    @SequenceGenerator(name="idgen", sequenceName="id_seq")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    protected Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
}
