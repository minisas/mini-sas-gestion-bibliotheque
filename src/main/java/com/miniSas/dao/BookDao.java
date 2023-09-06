package com.miniSas.dao;

import com.miniSas.model.Book;

import java.util.List;

public interface BookDao {
    List<Book> findAll();

    void save(Book Book);

    void deleteByISBN(String id);

    List<Book> findAllByNom_auteurOrTitle(String Nom_auteurTitre);
}