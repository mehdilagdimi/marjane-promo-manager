package com.marjanefranchise.marjane_franchise_promotion_manager.util.HibernateUtil;

import com.marjanefranchise.marjane_franchise_promotion_manager.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public final class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static final Configuration configuration ;
    private static final Properties properties;

    static {
        configuration = new Configuration();
        properties = new Properties();
        properties.setProperty("hibernate.dialect", Config.getDIALECT());
        properties.setProperty("hibernate.connection.driver_class", Config.getDRIVER());
        properties.setProperty("hibernate.connection.url", Config.getURL());
        properties.setProperty("hibernate.connection.username", Config.getUSER());
        properties.setProperty("hibernate.connection.password", Config.getPASSWORD());
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
//        properties.setProperty(" hibernate.connection.pool_size", "10");
        configuration.setProperties(properties);
        configuration
//                .addPackage("com.marjanefranchise.marjane_franchise_promotion_manager.entity")
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(Center.class)
                .addAnnotatedClass(Manager.class)
                .addAnnotatedClass(SectionManager.class)
                .addAnnotatedClass(Promotion.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

//        Call .configure if properties will be read from hibernate-cfg xml file
//        sessionFactory = new Configuration().setProperties(properties).configure().
//                buildSessionFactory();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session openSession() {
        return sessionFactory.openSession();
    }

    public static boolean isConnected(){
        return openSession().isConnected();
    }
}
