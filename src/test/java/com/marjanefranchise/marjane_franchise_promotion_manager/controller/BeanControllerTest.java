package com.marjanefranchise.marjane_franchise_promotion_manager.controller;


import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Manager;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class BeanControllerTest {

    @Test
    void testFindManager(int id) {
        if(id == 0) id = 1;
        Manager manager = BeanController.find(id, Manager.class);

        assertEquals("lagdimi.mehdi@gmail.com", manager.getEmail());
    }
//
//    @Test
//    void testInsertManager(int id) {
//        if(id == 0) id = 1;
//        Manager manager = new Manager();
//        HttpServletRequest request = mock(HttpServletRequest.class);
//
//        BeanController.add(manager, Manager.class, request, ) ;
//
//        assertEquals("lagdimi.mehdi@gmail.com", manager.getEmail());
//    }


}