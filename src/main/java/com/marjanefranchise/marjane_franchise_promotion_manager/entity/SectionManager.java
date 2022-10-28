package com.marjanefranchise.marjane_franchise_promotion_manager.entity;

import com.marjanefranchise.marjane_franchise_promotion_manager.base.BeanSetterFI;
import com.marjanefranchise.marjane_franchise_promotion_manager.base.Person;
import com.marjanefranchise.marjane_franchise_promotion_manager.base.getBeanSettersFI;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class SectionManager extends Person implements getBeanSettersFI {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "center_id", referencedColumnName = "id")
    Center center;

    @OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "category_id")
    Category category;


    public SectionManager() {
    }

    public SectionManager(int id, String fullname, String email, String passw) {
        super(id, fullname, email, passw);
    }

    public SectionManager(String fullname, String email, String passw) {
        super(fullname, email, passw);
    }
    public Center getCenter() {
        return center;
    }

    public void setCenter(Center center) {
        this.center = center;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "SectionManager{" +
//                "center=" + center +
//                ", category=" + category +
                ", id=" + id +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public List<BeanSetterFI> getSetters() {
        List<BeanSetterFI> beanSettersAsLambdas;
        BeanSetterFI<String> beanSetFullName = this::setFullname;
        BeanSetterFI<String> beanSetEmail = this::setEmail;
        BeanSetterFI<String> beanSetPassword = this::setPassw;
        BeanSetterFI<Center> beanSetCenter = this::setCenter;
        BeanSetterFI<Category> beanSetCategory = this::setCategory;
        beanSettersAsLambdas = new ArrayList<>(Arrays.asList(
                beanSetFullName,
                beanSetEmail,
                beanSetPassword,
                beanSetCenter,
                beanSetCategory
        ));
        return beanSettersAsLambdas;
    }
}
