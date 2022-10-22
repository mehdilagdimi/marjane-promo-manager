package com.marjanefranchise.marjane_franchise_promotion_manager.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public final class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static final Properties properties;
    static {

        properties = new Properties();
        properties.setProperty("hibernate.dialect", Config.getDIALECT());
        properties.setProperty("hibernate.connection.driver_class", Config.getDriver());
        properties.setProperty("hibernate.connection.url", Config.getUrl());
        properties.setProperty("hibernate.connection.username", Config.getUser());
        properties.setProperty("hibernate.connection.password", Config.getPassword());
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");

//        properties.setProperty(" hibernate.connection.pool_size", "10");

        sessionFactory = new Configuration().setProperties(properties).configure().
                buildSessionFactory();
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session openSession() {
        return sessionFactory.openSession();
    }
}
