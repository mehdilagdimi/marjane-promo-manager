package com.marjanefranchise.marjane_franchise_promotion_manager.entity;




public final class SuperAdmin extends Manager {

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
