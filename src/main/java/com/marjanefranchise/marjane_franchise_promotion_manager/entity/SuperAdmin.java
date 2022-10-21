package com.marjanefranchise.marjane_franchise_promotion_manager.entity;




public class SuperAdmin extends Manager {

    public SuperAdmin(){
        super();
    }

    public SuperAdmin(int id, String fullname, String email, String passw) {
        super(id, fullname, email, passw);
    }

    public SuperAdmin(String fullname, String email, String passw) {
        super(fullname, email, passw);
    }


}
