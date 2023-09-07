package com.miniSas;

import com.miniSas.dao.*;
import com.miniSas.model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Main {
    public static void main(String[] args) {

        BookDao BookDao = new BookDaoImpl();
        Empruner_livreDoa Emprunter_livreDao = new Empruner_livreDoaImpl();

        /*String dateString = "2023-09-14";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Emprunter_livre emprunter_livre = Emprunter_livre.builder()
                .date_emprunte(new Date())
                .date_retour(date)
                .Id_utilisateur(1)
                .ISBN("AntJeaAno")
                .build();
            Emprunter_livreDao.emprunterBook(emprunter_livre);*/
            //Emprunter_livreDao.retourBook("AntJeaAno");
           // BookDao.findAllBookEmprunter().forEach(System.out::println);
            System.out.println(Emprunter_livreDao.checkStatusBook("AntJeaAno"));
    }
}