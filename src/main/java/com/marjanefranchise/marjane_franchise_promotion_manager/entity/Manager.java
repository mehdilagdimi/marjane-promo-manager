package com.marjanefranchise.marjane_franchise_promotion_manager.entity;

import com.marjanefranchise.marjane_franchise_promotion_manager.base.Person;
import jakarta.persistence.*;

import java.io.Serializable;

@MappedSuperclass
@Entity @Table(name ="manager")
public class Manager extends Person implements Serializable {


//    @Column(nullable = false)
//    private boolean role = false;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId
    Center center;


    public Manager(){
        super();
    }

    public Manager(int id, String fullname, String email, String passw) {
        super(id, fullname, email, passw);
    }

    public Manager(String fullname, String email, String passw) {
        super(fullname, email, passw);
    }

//    public boolean getRole() {
//        return role;
//    }
//
//    public void setRole(boolean role) {
//        this.role = role;
//    }
}
