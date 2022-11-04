package com.marjanefranchise.marjane_franchise_promotion_manager.controller;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.servlet.http.HttpServletRequest;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthController {

    public static<T> boolean checkIfSuperAdmin(String email, String password) {
        boolean isSuperAdmin = false;
        Dotenv dotenv;
        dotenv = Dotenv.configure().ignoreIfMissing().load();

        if(dotenv.get("SUPERADMINEMAIL") != null && dotenv.get("SUPERADMINEMAIL").equals(email)){
            isSuperAdmin = (dotenv.get("SUPERADMINPASSW") != null && dotenv.get("SUPERADMINPASSW").equals(password)) ? true : false;
        }
        return isSuperAdmin;
    }

    public static<T> boolean checkEmailExist(String email, Class<T> beanImpl){
//        boolean isExist = false;
        List<T> beans = BeanController.customSelectQuerySingleParam(beanImpl, String.class, "email", email);
        if(beans != null){
            return !beans.isEmpty();
        }
        return false;
    }
    public static<T> T checkAccountExist(String email, String password, Class<T> beanImpl){
//        boolean isExist = false;
        String[] params = {"email", "passw"};
        List<T> beans = BeanController.customSelectQueryMultipleParams(beanImpl, String.class, params, email, password);
        if(beans != null) {
            if(beans.isEmpty()) return null;
            return beans.get(0);
        }
        return null;
    }


}
