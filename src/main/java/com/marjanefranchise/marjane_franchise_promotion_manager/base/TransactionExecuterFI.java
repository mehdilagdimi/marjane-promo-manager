package com.marjanefranchise.marjane_franchise_promotion_manager.base;


@FunctionalInterface
public interface TransactionExecuterFI<T> {
    void accept(T t);
}
