package com.miniSas;

import com.miniSas.dao.*;
import com.miniSas.model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    static String jauneColor = "\u001B[93m";
    static String purpleColor = "\u001B[35m";
    static String defautColor = "\u001B[0m";
    static String vertClairColor = "\u001B[92m";
    static String rougeClairColor = "\u001B[91m";
    static int td_lenght;
    static int td_lenght_empty;
    public static String createTable(String td,String color){
        String tr = jauneColor + "|";
        if (td == ""){
            tr = jauneColor + "+";
            for (int i=0; i<90; i++){
                tr += "-";
            }
            tr += "+";
            tr += defautColor;
        } else if (td == "style2") {
            tr = jauneColor + "+";
            for (int i=0; i<59; i++){
                tr += "-";
            }
            tr += "+";
            for (int i=0; i<30; i++){
                tr += "-";
            }
            tr += "+";
            tr += defautColor;
        } else {
            td_lenght = td.length();
            td_lenght_empty = (90 - td_lenght)/2;
            tr += color;
            for (int i=0; i<td_lenght_empty; i++){
                tr += " ";
            }
            tr += td;
            if (((90 - td_lenght) % 2) == 1){
                for (int i=0; i<td_lenght_empty+1; i++){
                    tr += " ";
                }
            }else {
                for (int i=0; i<td_lenght_empty; i++){
                    tr += " ";
                }
            }
            tr += jauneColor + "|";
            tr += defautColor;
        }
        return tr;
    }
    public static String createTableBook(String td){
        String tr = jauneColor + "+";
        if (td == "empty1"){
            for (int i=0; i<151; i++){
                tr += "-";
            }
            tr += "+";
            tr += defautColor;
        }
        else if (td == "empty2"){
            for (int i=0; i<37; i++){
                tr += "-";
            }
            tr += "+";
            for (int i=0; i<37; i++){
                tr += "-";
            }
            tr += "+";
            for (int i=0; i<37; i++){
                tr += "-";
            }
            tr += "+";
            for (int i=0; i<37; i++){
                tr += "-";
            }
            tr += "+";
            tr += defautColor;
        }
        else {
            tr = jauneColor + "|";
            td_lenght = td.length();
            td_lenght_empty = (151 - td_lenght)/2;
            tr += rougeClairColor;
            for (int i=0; i<td_lenght_empty; i++){
                tr += " ";
            }
            tr += td;
            if (((153 - td_lenght) % 2) == 1){
                for (int i=0; i<td_lenght_empty+1; i++){
                    tr += " ";
                }
            }else {
                for (int i=0; i<td_lenght_empty; i++){
                    tr += " ";
                }
            }
            tr += jauneColor;
            tr += "|";
            tr += defautColor;
        }
        return tr;
    }
    public static String createTableBook2(String td){
        String tr = jauneColor + "+";
        if (td == "empty1"){
            for (int i=0; i<75; i++){
                tr += "-";
            }
            tr += "+";
            tr += defautColor;
        }
        else if (td == "empty2"){
            for (int i=0; i<37; i++){
                tr += "-";
            }
            tr += "+";
            for (int i=0; i<37; i++){
                tr += "-";
            }
            tr += "+";
            tr += defautColor;
        }
        else {
            tr = jauneColor + "|";
            td_lenght = td.length();
            td_lenght_empty = (75 - td_lenght)/2;
            tr += rougeClairColor;
            for (int i=0; i<td_lenght_empty; i++){
                tr += " ";
            }
            tr += td;
            if (((75 - td_lenght) % 2) == 1){
                for (int i=0; i<td_lenght_empty+1; i++){
                    tr += " ";
                }
            }else {
                for (int i=0; i<td_lenght_empty; i++){
                    tr += " ";
                }
            }
            tr += jauneColor;
            tr += "|";
            tr += defautColor;
        }
        return tr;
    }
    public static String createTr(){
        String td1 = "Titre";
        String td2 = "Nom de l'auteur";
        String td3 = "Status";
        String td4 = "ISBN";
        int td1_lenght = td1.length();
        int td1_lenght_empty = 37 - td1_lenght;
        int demi_td1_lenght_empty = td1_lenght_empty / 2;

        int td2_lenght = td2.length();
        int td2_lenght_empty = 37 - td2_lenght;
        int demi_td2_lenght_empty = td2_lenght_empty / 2;

        int td3_lenght = td3.length();
        int td3_lenght_empty = 37 - td3_lenght;
        int demi_td3_lenght_empty = td3_lenght_empty / 2;

        int td4_lenght = td4.length();
        int td4_lenght_empty = 37 - td4_lenght;
        int demi_td4_lenght_empty = td4_lenght_empty / 2;

        String tr = jauneColor + "|" +purpleColor;
        for (int i=0; i<demi_td1_lenght_empty; i++){
            tr += " ";
        }
        tr += td1;
        for (int i=0; i<demi_td1_lenght_empty; i++){
            tr += " ";
        }
        tr += jauneColor + "|" +purpleColor;
        for (int i=0; i<demi_td2_lenght_empty; i++){
            tr += " ";
        }
        tr += td2;
        for (int i=0; i<demi_td2_lenght_empty; i++){
            tr += " ";
        }
        tr += jauneColor + "|" +purpleColor;
        for (int i=0; i<demi_td3_lenght_empty; i++){
            tr += " ";
        }
        tr += td3;
        for (int i=0; i<demi_td3_lenght_empty+1; i++){
            tr += " ";
        }
        tr += jauneColor + "|" +purpleColor;
        for (int i=0; i<demi_td4_lenght_empty; i++){
            tr += " ";
        }
        tr += td4;
        for (int i=0; i<demi_td4_lenght_empty+1; i++){
            tr += " ";
        }
        tr += jauneColor + "|" + defautColor;
        return tr;
    }
    public static String createTr2(){
        String td1 = "ID";
        String td2 = "Nom Et Prenom";

        int td1_lenght = td1.length();
        int td1_lenght_empty = 37 - td1_lenght;
        int demi_td1_lenght_empty = td1_lenght_empty / 2;

        int td2_lenght = td2.length();
        int td2_lenght_empty = 37 - td2_lenght;
        int demi_td2_lenght_empty = td2_lenght_empty / 2;

        String tr = jauneColor + "|" +purpleColor;
        for (int i=0; i<demi_td1_lenght_empty; i++){
            tr += " ";
        }
        tr += td1;
        for (int i=0; i<demi_td1_lenght_empty+1; i++){
            tr += " ";
        }
        tr += jauneColor + "|" +purpleColor;
        for (int i=0; i<demi_td2_lenght_empty; i++){
            tr += " ";
        }
        tr += td2;
        for (int i=0; i<demi_td2_lenght_empty; i++){
            tr += " ";
        }
        tr += jauneColor + "|";
        return tr;
    }
    public static String createTrStatistique(String statistique, int value){
        String tr = jauneColor + "|";
        td_lenght = statistique.length();
        td_lenght_empty = (59 - td_lenght)/2;
        tr += purpleColor;
        for (int i=0; i<td_lenght_empty; i++){
            tr += " ";
        }
        tr += statistique;
        if (((59 - td_lenght) % 2) == 1){
            for (int i=0; i<td_lenght_empty+1; i++){
                tr += " ";
            }
        }else {
            for (int i=0; i<td_lenght_empty; i++){
                tr += " ";
            }
        }
        tr += jauneColor + "|";
        tr += vertClairColor;
        String livre = value + " Livres";
        td_lenght = livre.length();
        td_lenght_empty = (30 - td_lenght)/2;
        for (int i=0; i<td_lenght_empty; i++){
            tr += " ";
        }
        tr += livre;
        if (((30 - td_lenght) % 2) == 1){
            for (int i=0; i<td_lenght_empty+1; i++){
                tr += " ";
            }
        }else {
            for (int i=0; i<td_lenght_empty; i++){
                tr += " ";
            }
        }
        tr += jauneColor + "|";
        tr += defautColor;
        return tr;
    }
    public static void clearConsole(int taille) {
        for (int i = 0; i < taille; i++) {
            System.out.println();
        }
    }
    static String ISBN;
    static String Titre;
    static String Nom_auteur;
    static String Nom_auteurTitre;
    static int Id_utilisateur;
    static String NomEtPrenom;
    static String date_retour;
    public static void main(String[] args) {
        // Declaration
        BookDao BookDao = new BookDaoImpl();
        Empruner_livreDoa Emprunter_livreDao = new Empruner_livreDoaImpl();
        UtilisateurDao UtilisateurDao = new UtilisateurDaoImpl();
        Scanner scanner = new Scanner(System.in);
        int choix;

        // Application
        do {
            Emprunter_livreDao.checkStatusBook();
            System.out.println(createTable("",""));
            System.out.println(createTable("Menu",rougeClairColor));
            System.out.println(createTable("",""));
            System.out.println(createTable("1.Ajouter un livre",vertClairColor));
            System.out.println(createTable("2.Afficher les livres disponible",vertClairColor));
            System.out.println(createTable("3.Rechercher les livres",vertClairColor));
            System.out.println(createTable("4.Emprunter un livre",vertClairColor));
            System.out.println(createTable("5.Retourner livre",vertClairColor));
            System.out.println(createTable("6.Afficher les livres empruntés",vertClairColor));
            System.out.println(createTable("7.Modifier les livres",vertClairColor));
            System.out.println(createTable("8.Voir les statistiques",vertClairColor));
            System.out.println(createTable("9.Autres fonctions",vertClairColor));
            System.out.println(createTable("0.Quit",vertClairColor));
            System.out.println(createTable("",""));

            System.out.print("Enterez votre choix (0-9): ");
            choix = scanner.nextInt();
            scanner.nextLine();
            clearConsole(23);
            switch (choix) {
                case 1:
                    System.out.println(createTable("",""));
                    System.out.println(createTable("Ajouter un livre",rougeClairColor));
                    System.out.println(createTable("",""));
                    System.out.println("Enterez ISBN du livre: ");
                    ISBN = scanner.nextLine();
                    System.out.println("Enterez le titre du livre: ");
                    Titre = scanner.nextLine();
                    System.out.println("Enterez nom de l'auteur du livre: ");
                    Nom_auteur = scanner.nextLine();
                    Book book = Book.builder()
                            .ISBN(ISBN)
                            .Titre(Titre)
                            .Nom_auteur(Nom_auteur)
                            .build();
                    BookDao.save(book);
                    clearConsole(24);
                    break;
                case 2:
                    System.out.println(createTableBook("empty1"));
                    System.out.println(createTableBook("Afficher les livres disponibles"));
                    System.out.println(createTableBook("empty2"));
                    System.out.println(createTr());
                    System.out.println(createTableBook("empty2"));
                    BookDao.findAllBookDisponible().forEach(System.out::println);
                    System.out.println(createTableBook("empty2"));
                    break;
                case 3:
                    System.out.println("Enterez nom de l'auteur du livre ou le titre de livre: ");
                    Nom_auteurTitre = scanner.nextLine();
                    clearConsole(24);
                    System.out.println(createTableBook("empty1"));
                    System.out.println(createTableBook("Nom de l'auteur du livre ou le titre de livre: "+Nom_auteurTitre));
                    System.out.println(createTableBook("empty2"));
                    System.out.println(createTr());
                    System.out.println(createTableBook("empty2"));
                    BookDao.findAllByNom_auteurOrTitle(Nom_auteurTitre).forEach(System.out::println);
                    System.out.println(createTableBook("empty2"));
                    break;
                case 4:
                    System.out.println("Enterez id de l'utilisateur: ");
                    Id_utilisateur = scanner.nextInt();
                    scanner.nextLine();
                    if (Id_utilisateur == 0){
                        System.out.println(createTable("",""));
                        System.out.println(createTable("Ajoutez emprunteur",rougeClairColor));
                        System.out.println(createTable("",""));
                        System.out.println("Enterez le nom et prenom de l'utilisateur: ");
                        NomEtPrenom = scanner.nextLine();
                        Utilisateur utilisateur = Utilisateur.builder()
                                .Id_utilisateur(0)
                                .NomEtPrenom(NomEtPrenom)
                                .build();
                        Id_utilisateur = UtilisateurDao.save(utilisateur);
                    }
                    System.out.println("Enterez ISBN de livre: ");
                    ISBN = scanner.nextLine();
                    System.out.println("Enterez la date de retour de livre sou la forme de " + rougeClairColor + "yyyy-MM-dd" + defautColor +": ");
                    date_retour = scanner.nextLine();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = null;
                    try {
                        date = dateFormat.parse(date_retour);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }

                    Emprunter_livre emprunter_livre = Emprunter_livre.builder()
                            .date_emprunte(new Date())
                            .date_retour(date)
                            .Id_utilisateur(Id_utilisateur)
                            .ISBN(ISBN)
                            .build();
                    Emprunter_livreDao.emprunterBook(emprunter_livre);
                    break;
                case 5:
                    System.out.println(createTable("",""));
                    System.out.println(createTable("Retourner livre",rougeClairColor));
                    System.out.println(createTable("",""));
                    System.out.println("Enterez ISBN de livre: ");
                    ISBN = scanner.nextLine();
                    Emprunter_livreDao.retourBook(ISBN);
                    break;
                case 6:
                    System.out.println(createTableBook("empty1"));
                    System.out.println(createTableBook("Afficher les livres empruntés"));
                    System.out.println(createTableBook("empty2"));
                    System.out.println(createTr());
                    System.out.println(createTableBook("empty2"));
                    BookDao.findAllBookEmprunter().forEach(System.out::println);
                    System.out.println(createTableBook("empty2"));
                    break;
                case 7:
                    System.out.println(createTable("",""));
                    System.out.println(createTable("Modifier un livre",rougeClairColor));
                    System.out.println(createTable("",""));
                    System.out.println("Enterez ISBN du livre: ");
                    ISBN = scanner.nextLine();
                    System.out.println("Enterez le titre du livre: ");
                    Titre = scanner.nextLine();
                    System.out.println("Enterez nom de l'auteur du livre: ");
                    Nom_auteur = scanner.nextLine();
                    Book bookEdite = Book.builder()
                            .ISBN(ISBN)
                            .Titre(Titre)
                            .Nom_auteur(Nom_auteur)
                            .build();
                    BookDao.save(bookEdite);
                    break;
                case 8:
                    int totalBookDisponible = BookDao.statistique(0);
                    int totalBookEmprunte = BookDao.statistique(1);
                    int totalBookPerdue = BookDao.statistique(-1);
                    System.out.println(createTable("",""));
                    System.out.println(createTable("Voir les statistiques",rougeClairColor));
                    System.out.println(createTable("style2",""));
                    System.out.println(createTrStatistique("Totale Des Livres Disponibles", totalBookDisponible));
                    System.out.println(createTable("style2",""));
                    System.out.println(createTrStatistique("Totale Des Livres Empruntes", totalBookEmprunte));
                    System.out.println(createTable("style2",""));
                    System.out.println(createTrStatistique("Totale Des Livres Perdues", totalBookPerdue));
                    System.out.println(createTable("style2",""));
                    break;
                case 9:
                    System.out.println(createTable("",""));
                    System.out.println(createTable("Autres fonctions",rougeClairColor));
                    System.out.println(createTable("",""));
                    System.out.println(createTable("1.Afficher les emprunteurs",vertClairColor));
                    System.out.println(createTable("2.Ajouter un emprunteur",vertClairColor));
                    System.out.println(createTable("3.Modifier un emprunteur",vertClairColor));
                    System.out.println(createTable("4.Supprimer un emprunteur",vertClairColor));
                    System.out.println(createTable("5.Supprimer les livres perdus",vertClairColor));
                    System.out.println(createTable("0.Quit",vertClairColor));
                    System.out.println(createTable("",""));
                    System.out.print("Enterez votre choix (0-5): ");
                    choix = scanner.nextInt();
                    clearConsole(24);
                    switch (choix){
                        case 2:
                            System.out.println(createTable("",""));
                            System.out.println(createTable("Ajoutez emprunteur",rougeClairColor));
                            System.out.println(createTable("",""));
                            System.out.println("Enterez le nom et prenom de l'utilisateur: ");
                            NomEtPrenom = scanner.nextLine();
                            Utilisateur utilisateur = Utilisateur.builder()
                                    .Id_utilisateur(0)
                                    .NomEtPrenom(NomEtPrenom)
                                    .build();
                            UtilisateurDao.save(utilisateur);
                            break;
                        case 3:
                            System.out.println(createTable("",""));
                            System.out.println(createTable("Modifier emprunteur",rougeClairColor));
                            System.out.println(createTable("",""));
                            System.out.println("Enterez ID de l'utilisateur: ");
                            Id_utilisateur = scanner.nextInt();
                            System.out.println("Enterez le nouvelle nom et prenom de l'utilisateur: ");
                            NomEtPrenom = scanner.nextLine();
                            Utilisateur utilisateurEdit = Utilisateur.builder()
                                    .Id_utilisateur(Id_utilisateur)
                                    .NomEtPrenom(NomEtPrenom)
                                    .build();
                            UtilisateurDao.save(utilisateurEdit);
                            break;
                        case 4:
                            System.out.println(createTable("",""));
                            System.out.println(createTable("Supprimer emprunteur",rougeClairColor));
                            System.out.println(createTable("",""));
                            System.out.println("Enterez ID de l'utilisateur: ");
                            Id_utilisateur = scanner.nextInt();
                            UtilisateurDao.deleteById_utilisateur(Id_utilisateur);
                            break;
                        case 1:
                            System.out.println(createTableBook2("empty1"));
                            System.out.println(createTableBook2("Afficher les emprunteurs"));
                            System.out.println(createTableBook2("empty2"));
                            System.out.println(createTr2());
                            System.out.println(createTableBook2("empty2"));
                            UtilisateurDao.findAll().forEach(System.out::println);
                            System.out.println(createTableBook2("empty2"));
                            break;
                        case 5:
                            BookDao.deleteByISBN("ALL");
                            System.out.println("Les Livres Perdues Sont Supprimer.");
                            break;
                        case 0:
                            System.out.println("Fermeture du programme.");
                            break;
                        default:
                            System.out.println("Choix invalide. Selectionnez un choix valide.");
                    }
                    break;
                case 0:
                    System.out.println("Fermeture du programme.");
                    break;
                default:
                    System.out.println("Choix invalide. Selectionnez un choix valide.");
            }

            System.out.print("Voulez-vous continuer? (1 = Oui, 0 = Non): ");
            choix = scanner.nextInt();
            clearConsole(23);
        } while (choix != 0);
        System.out.println("Soyez les bienvenus !");
    }

}