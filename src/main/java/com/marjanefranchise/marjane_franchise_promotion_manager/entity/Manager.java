package com.marjanefranchise.marjane_franchise_promotion_manager.entity;

import com.marjanefranchise.marjane_franchise_promotion_manager.base.BeanSetterFI;
import com.marjanefranchise.marjane_franchise_promotion_manager.base.Person;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Entity @Table(name ="manager")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Manager extends Person implements Serializable {
//    @Column(nullable = false)
//    private boolean role = false;
    @OneToOne(fetch = FetchType.LAZY)
//    @MapsId
    @JoinColumn(name = "center_id", referencedColumnName = "id")
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
    public void setCenter(Center center) {
        this.center = center;
    }

    public Center getCenter() {
        return center;
    }

}
