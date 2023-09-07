package com.miniSas;

import com.miniSas.dao.*;
import com.miniSas.model.*;

import java.util.Date;


public class Main {
    public static void main(String[] args) {

        BookDao BookDao = new BookDaoImpl();
        Empruner_livreDoa Emprunter_livreDao = new Empruner_livreDoaImpl();

            Emprunter_livre emprunter_livre = Emprunter_livre.builder()
                    .date_emprunte(new Date())
                    .date_retour(new Date())
                    .Id_utilisateur(1)
                    .ISBN("AntJeaAno")
                    .build();
            Emprunter_livreDao.emprunterBook(emprunter_livre);
            BookDao.findAllBookEmprunter().forEach(System.out::println);
            //System.out.println(Emprunter_livreDao.checkStatusBook(""));
    }
}