package com.marjanefranchise.marjane_franchise_promotion_manager.entity;

import com.marjanefranchise.marjane_franchise_promotion_manager.base.BeanSetterFI;
import com.marjanefranchise.marjane_franchise_promotion_manager.base.Person;
import com.marjanefranchise.marjane_franchise_promotion_manager.base.getBeanSettersFI;
import jakarta.persistence.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.*;

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
    public Map<String, BeanSetterFI> getSetters(){
        Map<String, BeanSetterFI> beanSettersAsLambdasMap;
        BeanSetterFI<String> beanSetFullName = this::setFullname;
        BeanSetterFI<String> beanSetEmail = this::setEmail;
        BeanSetterFI<String> beanSetPassword = this::setPassw;
        BeanSetterFI<Center> beanSetCenter = this::setCenter;
        BeanSetterFI<Category> beanSetCategory = this::setCategory;

        beanSettersAsLambdasMap = new HashMap<>(Map.ofEntries(
                Map.entry("fullname", beanSetFullName),
                Map.entry("email", beanSetEmail),
                Map.entry("passw", beanSetPassword),
                Map.entry("center", beanSetCenter),
                Map.entry("category", beanSetCategory)
        ));
        return beanSettersAsLambdasMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        SectionManager that = (SectionManager) o;

        return new EqualsBuilder().append(center, that.center).append(category, that.category).isEquals();
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
}
