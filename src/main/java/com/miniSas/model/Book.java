package com.miniSas.model;

public class Book {
    private  String Titre;
    private String Nom_auteur;
    private int Status;
    private String ISBN;

    public Book() {
    }

    public Book(String titre, String nom_auteur, int status, String ISBN) {
        this.Titre = titre;
        this.Nom_auteur = nom_auteur;
        this.Status = status;
        this.ISBN = ISBN;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }

    public String getNom_auteur() {
        return Nom_auteur;
    }

    public void setNom_auteur(String nom_auteur) {
        Nom_auteur = nom_auteur;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public static BookBuilder builder(){
        return new BookBuilder();
    }

    static String jauneColor = "\u001B[93m";
    static String vertClairColor = "\u001B[92m";
    static String defautColor = "\u001B[0m";
    public String createTr(String td){
        int td_lenght = td.length();
        int td_lenght_empty = 37 - td_lenght;
        int demi_td_lenght_empty = td_lenght_empty / 2;
        int modulo_td_lenght_2 = td_lenght_empty % 2;
        String tr = vertClairColor;
        for (int i=0; i<demi_td_lenght_empty; i++){
            tr += " ";
        }
        tr += td;
        if (modulo_td_lenght_2 == 1){
            for (int i=0; i<demi_td_lenght_empty+1; i++){
                tr += " ";
            }
        }else {
            for (int i=0; i<demi_td_lenght_empty; i++){
                tr += " ";
            }
        }
        tr += jauneColor + "|" + defautColor;
        return tr;
    }
    @Override
    public String toString() {
        String tr = jauneColor + "|";
        String Status_string="";

        if (Status == 0){
            Status_string = "Disponible";
        } else if (Status == 1) {
            Status_string = "Empruntee";
        }else {
            Status_string = "Perdue";
        }

        tr += createTr(Titre);
        tr += createTr(Nom_auteur);
        tr += createTr(Status_string);
        tr += createTr(ISBN);

        return tr;
    }
}
