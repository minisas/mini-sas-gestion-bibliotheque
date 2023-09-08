package com.miniSas;

import com.miniSas.dao.*;
import com.miniSas.model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // Declaration
        BookDao BookDao = new BookDaoImpl();
        Empruner_livreDoa Emprunter_livreDao = new Empruner_livreDoaImpl();
        UtilisateurDao UtilisateurDao = new UtilisateurDaoImpl();
        Scanner scanner = new Scanner(System.in);
        int choix;
        String jauneColor = "\u001B[93m";
        String defautColor = "\u001B[0m";
        String vertColor = "\u001B[32m";
        String vertClairColor = "\u001B[92m";

        // Application
        do {
            System.out.println(jauneColor + "|------------------------------------------------------------------------------------------|"+ defautColor);
            System.out.println(jauneColor + "|            " + vertClairColor + "                             Options:                             " + jauneColor + "            |"+ defautColor);
            System.out.println(jauneColor + "|------------------------------------------------------------------------------------------|" +defautColor);
            System.out.println(jauneColor + "|            " + vertClairColor + "                        1.Ajouter un livre                        " + jauneColor + "            |"+ defautColor);
            System.out.println(jauneColor + "|            " + vertClairColor + "                      2.Afficher les livres                       " + jauneColor + "            |"+ defautColor);
            System.out.println("3. Rechercher les livres");
            System.out.println("4. Emprunter un livre");
            System.out.println("5. Retourner livre");
            System.out.println("6. Afficher les livres empruntés");
            System.out.println("7. Supprimer les livres");
            System.out.println("8. Modifier les livres");
            System.out.println("9. Ajouter un emprunteur");
            System.out.println("10. Modifier un emprunteur");
            System.out.println("11. Supprimer un emprunteur");
            System.out.println("12. Afficher les emprunteurs");
            System.out.println("0. Quit");

            System.out.print("Enter your choice (0-12): ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.println("You selected Option 1.");
                    break;
                case 2:
                    System.out.println("You selected Option 2.");
                    break;
                case 3:
                    System.out.println("You selected Option 3.");
                    break;
                case 4:
                    System.out.println("You selected Option 4.");
                    break;
                case 5:
                    System.out.println("You selected Option 5.");
                    break;
                case 6:
                    System.out.println("You selected Option 6.");
                    break;
                case 7:
                    System.out.println("You selected Option 7.");
                    break;
                case 8:
                    System.out.println("You selected Option 8.");
                    break;
                case 9:
                    System.out.println("You selected Option 9.");
                    break;
                case 10:
                    System.out.println("You selected Option 10.");
                    break;
                case 11:
                    System.out.println("You selected Option 11.");
                    break;
                case 12:
                    System.out.println("You selected Option 12.");
                    break;
                case 0:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option (0-12).");
            }

            // Demandez à l'utilisateur s'il souhaite continuer.
            System.out.print("Do you want to continue? (1 = Yes, 0 = No): ");
            choix = scanner.nextInt();
        } while (choix != 0);
    }

}