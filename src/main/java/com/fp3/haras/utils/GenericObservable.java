package com.fp3.haras.utils;

public interface GenericObservable {
    public void addObserver(GenericObserver o);
    public void removeObserver(GenericObserver o);
    public void updateObservables(Object o);
}
