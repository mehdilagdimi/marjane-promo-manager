package com.marjanefranchise.marjane_franchise_promotion_manager.util.HibernateUtil;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HibernateUtilTest {
    @Test
    void testDBConnectionThroughHibernate() {
        assertTrue(HibernateUtil.isConnected());
        System.out.println(" Connected to DB successfully ");
    }
}