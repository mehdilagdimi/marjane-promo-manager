package com.marjanefranchise.marjane_franchise_promotion_manager.entity;

import com.marjanefranchise.marjane_franchise_promotion_manager.base.BeanSetterFI;
import com.marjanefranchise.marjane_franchise_promotion_manager.base.Person;
import com.marjanefranchise.marjane_franchise_promotion_manager.base.getBeanSettersFI;
import jakarta.persistence.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.*;
import java.util.function.Function;

@Entity @Table(name ="manager")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Manager extends Person implements Serializable, getBeanSettersFI {
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

    @Override
    public Map<String, BeanSetterFI> getSetters(){
        Map<String, BeanSetterFI> beanSettersAsLambdasMap;

        BeanSetterFI<String> beanSetFullName = this::setFullname;
        BeanSetterFI<String> beanSetEmail = this::setEmail;
        BeanSetterFI<String> beanSetPassword = this::setPassw;
        BeanSetterFI<Center> beanSetCenter = this::setCenter;


        beanSettersAsLambdasMap = new HashMap<>(Map.ofEntries(
                Map.entry("fullname", beanSetFullName),
                Map.entry("email", beanSetEmail),
                Map.entry("passw", beanSetPassword),
                Map.entry("center", beanSetCenter)

        ));
        return beanSettersAsLambdasMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Manager manager = (Manager) o;

        return new EqualsBuilder().append(id, manager.id).append(fullname, manager.fullname).append(email, manager.email).append(passw, manager.passw).append(center, manager.center).isEquals();
    }


    @Override
    public String toString() {
        return "Manager{" +
//                "center=" + center +
                ", id=" + id +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
