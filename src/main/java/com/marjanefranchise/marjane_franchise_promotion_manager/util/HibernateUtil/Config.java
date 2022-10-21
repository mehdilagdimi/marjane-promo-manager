package com.marjanefranchise.marjane_franchise_promotion_manager.util.HibernateUtil;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public final class Config {
    private  static String DRIVER;
    private  static String DIALECT;
    private  static String URL;
    private  static String USER;
    private  static String PASSWORD;


    static {
        try{
            Context env = (Context)new InitialContext().lookup("java:comp/env");
            DIALECT = (String) env.lookup("DIALECT");
            DRIVER = (String) env.lookup("DRIVER");
            URL = (String) env.lookup("URL");
            USER = (String) env.lookup("USER");
            PASSWORD = (String) env.lookup("PASSW");
        } catch (NamingException e){
            e.printStackTrace();
        }
    }


    public static String getDIALECT() {
        return DIALECT;
    }

    public static void setDIALECT(String DIALECT) {
        Config.DIALECT = DIALECT;
    }

    public static String getDriver() {
        return DRIVER;
    }

    public static void setDriver(String DRIVER) {
        Config.DRIVER = DRIVER;
    }
    public static String getUrl() {
        return URL;
    }

    public static String getUser() {
        return USER;
    }

    public static String getPassword() {
        return PASSWORD;
    }


}
