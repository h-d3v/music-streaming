package com.tpappweb.app.dao;

import java.util.List;

public interface dao <T>{
    T lire(long id);
    T modifier(Object T);
    T supprimmer(Object T);
    List<T> lireTous();
    boolean creer(Object T);

}
