package com.marjanefranchise.marjane_franchise_promotion_manager.entity;


import com.marjanefranchise.marjane_franchise_promotion_manager.base.Person;

public final class SuperAdmin extends Person {

    private static SuperAdmin superAdmin = null;

    private SuperAdmin(){
    }
    private SuperAdmin(String fullname, String email, String passw) {
        super(fullname, email, passw);
    }

    public static SuperAdmin getInstance(){
        if(superAdmin == null) superAdmin = new SuperAdmin();

        return superAdmin;
    }

}
