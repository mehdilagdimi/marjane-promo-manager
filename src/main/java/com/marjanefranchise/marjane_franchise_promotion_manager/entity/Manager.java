package com.marjanefranchise.marjane_franchise_promotion_manager.entity;

import com.marjanefranchise.marjane_franchise_promotion_manager.base.BeanSetterFI;
import com.marjanefranchise.marjane_franchise_promotion_manager.base.Person;
import com.marjanefranchise.marjane_franchise_promotion_manager.base.getBeanSettersFI;
import jakarta.persistence.*;

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
    public List<BeanSetterFI> getSetters(){
        List<BeanSetterFI> beanSettersAsLambdas;
        BeanSetterFI<String> beanSetFullName = this::setFullname;
        BeanSetterFI<String> beanSetEmail = this::setEmail;
        BeanSetterFI<String> beanSetPassword = this::setPassw;
        BeanSetterFI<Center> beanSetCenter = this::setCenter;
        beanSettersAsLambdas = new ArrayList<>(Arrays.asList(
                beanSetFullName,
                beanSetEmail,
                beanSetPassword,
                beanSetCenter
        ));
        return beanSettersAsLambdas;
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
