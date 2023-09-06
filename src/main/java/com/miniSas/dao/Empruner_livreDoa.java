package com.miniSas.dao;

import com.miniSas.model.Emprunter_livre;

public interface Empruner_livreDoa {
    int checkStatusBook(String ISBN);
    void emprunterBook(Emprunter_livre Emprunter_livre);
    void retourBook(String ISBN);
    void perduBook(String ISBN);
}