package com.miniSas.model;

public class BookBuilder {
    private  String Titre;
    private String Nom_auteur;
    private int Status;
    private String ISBN;

    public BookBuilder Titre(String  Titre){
        this.Titre = Titre;
        return this;
    }
    public BookBuilder Nom_auteur(String Nom_auteur){
        this.Nom_auteur = Nom_auteur;
        return this;
    }
    public BookBuilder ISBN(String ISBN){
        this.ISBN = ISBN;
        return this;
    }
    public BookBuilder Status(int Status){
        this.Status = Status;
        return this;
    }
    public Book build(){
        return new Book(Titre, Nom_auteur, Status, ISBN);
    }
}
