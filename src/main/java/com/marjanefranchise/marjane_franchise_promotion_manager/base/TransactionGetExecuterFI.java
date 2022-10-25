package com.marjanefranchise.marjane_franchise_promotion_manager.base;

@FunctionalInterface
public interface TransactionGetExecuterFI<T1, T2> {
    T2 accept(T1 t);
}
