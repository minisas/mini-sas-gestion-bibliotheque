package com.miniSas.dao;

import com.miniSas.model.Emprunter_livre;

public interface Empruner_livreDoa {
    int checkStatusBook(Emprunter_livre Emprunter_livre);

    void emprunterBook(Emprunter_livre Emprunter_livre);
    void retourBook(Emprunter_livre Emprunter_livre);
}