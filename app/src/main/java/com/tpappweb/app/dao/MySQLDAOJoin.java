package com.tpappweb.app.dao;

import java.util.List;

public abstract class  MySQLDAOJoin<T, T1> {

    /**
     *
     * @param t
     * @param t1 l'objet t1 a ajouter
     * @return
     */
    abstract boolean ajouterUn(T t, T1 t1);

    /**
     *
     * @param t
     * @param t1 l'objet t1 a supprimmer
     * @return boolean
     */
    abstract boolean supprimerUn(T t, T1 t1);

    /**
     *
     * @param t
     * @return le nombre d'objets T1 supprimes
     */
    abstract  long supprimerTous(T t);

    abstract List<T1> charger(T t);
}
