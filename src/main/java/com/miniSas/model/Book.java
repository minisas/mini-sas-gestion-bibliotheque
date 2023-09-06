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

    @Override
    public String toString() {
        return "Book{" +
                "Titre='" + Titre + '\'' +
                ", Nom_auteur='" + Nom_auteur + '\'' +
                ", Status=" + Status +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }
}
