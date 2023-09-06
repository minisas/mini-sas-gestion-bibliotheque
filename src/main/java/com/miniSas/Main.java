package com.miniSas;

import com.miniSas.dao.BookDao;
import com.miniSas.dao.BookDaoImpl;
import com.miniSas.dao.UtilisateurDao;
import com.miniSas.model.Book;
import com.miniSas.model.Utilisateur;
import com.miniSas.dao.UtilisateurDaoImpl;


public class Main {
    public static void main(String[] args) {


        BookDao BookDao = new BookDaoImpl();
        Book book = Book.builder()
                .Titre("Le Dernier Jour À Condamner5463")
                .Nom_auteur("Victore Higo34355")
                .Status(1)
                .ISBN("LDJACVH")
                .build();
        String bookChercher = "Higo";
        BookDao.findAllByNom_auteurOrTitle(bookChercher).forEach(System.out::println);
        BookDao.save(book);
        BookDao.findAll().forEach(System.out::println);
    }
}