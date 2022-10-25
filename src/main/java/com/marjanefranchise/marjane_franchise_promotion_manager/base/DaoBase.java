package com.marjanefranchise.marjane_franchise_promotion_manager.base;

import java.util.List;

public interface DaoBase <T>{

    T find(int id);
    T get(int id);

    List<T> getAll();

    void save(T t);

    void update(T t, String[] params);

    void delete(T t);
}
