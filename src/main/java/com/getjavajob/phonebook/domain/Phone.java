package com.getjavajob.phonebook.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String number;
    private Date created;

    public Phone() {
    }

    public Phone(String number) {
        this.number = number;
        this.created = new Date();
    }

    public Phone(String number, Date date) {
        this.number = number;
        this.created = date;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date processingdate) {
        this.created = processingdate;
    }
}
