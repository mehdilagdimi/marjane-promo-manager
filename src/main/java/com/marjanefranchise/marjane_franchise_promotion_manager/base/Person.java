package com.marjanefranchise.marjane_franchise_promotion_manager.base;

import jakarta.persistence.*;
import org.hibernate.annotations.Table;

import java.io.Serializable;

@MappedSuperclass
public abstract class Person implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (nullable = false)
    private String fullname;
    @Column (nullable = false)
    private String email;
    @Column (nullable = false)
    private String passw;


    public Person () {

    }

    public Person(int id, String fullname, String email, String passw) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.passw = passw;
    }

    public Person(String fullname, String email, String passw) {
        this.fullname = fullname;
        this.email = email;
        this.passw = passw;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }
}
