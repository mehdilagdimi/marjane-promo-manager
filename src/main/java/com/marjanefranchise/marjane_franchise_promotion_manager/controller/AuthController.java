package com.marjanefranchise.marjane_franchise_promotion_manager.controller;

import java.util.List;

public class AuthController {

    public static<T> boolean checkEmailExist(String email, Class<T> beanImpl){
        boolean isExist = false;
        List<T> beans = BeanController.customSelectQuerySingleParam(beanImpl, String.class, "email", email);
        return !beans.isEmpty();
    }
    public static<T> boolean checkAccountExist(String email, String password, Class<T> beanImpl){
        boolean isExist = false;
        String[] params = {"email", "passw"};
        List<T> beans = BeanController.customSelectQueryMultipleParams(beanImpl, String.class, params, email, password);
        return !beans.isEmpty();
    }
}
