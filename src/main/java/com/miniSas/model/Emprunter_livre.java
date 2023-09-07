package com.miniSas.model;

import java.time.LocalDate;
import java.util.Date;

public class Emprunter_livre {
    private Date date_emprunte;
    private Date date_retour;
    private String ISBN;
    private int Id_utilisateur;

    public Emprunter_livre() {
    }

    public Emprunter_livre(Date date_emprunte, Date date_retour, String ISBN, int id_utilisateur) {
        this.date_emprunte = date_emprunte;
        this.date_retour = date_retour;
        this.ISBN = ISBN;
        Id_utilisateur = id_utilisateur;
    }

    public Date getDate_emprunte() {
        return date_emprunte;
    }

    public void setDate_emprunte(Date date_emprunte) {
        this.date_emprunte = date_emprunte;
    }

    public Date getDate_retour() {
        return date_retour;
    }

    public void setDate_retour(Date date_retour) {
        this.date_retour = date_retour;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getId_utilisateur() {
        return Id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        Id_utilisateur = id_utilisateur;
    }

    public static Emprunter_livreBuilder builder(){
        return new Emprunter_livreBuilder();
    }

    @Override
    public String toString() {
        return "Emprunter_livre{" +
                "date_emprunte=" + date_emprunte +
                ", date_retour=" + date_retour +
                ", ISBN='" + ISBN + '\'' +
                ", Id_utilisateur=" + Id_utilisateur +
                '}';
    }
}
