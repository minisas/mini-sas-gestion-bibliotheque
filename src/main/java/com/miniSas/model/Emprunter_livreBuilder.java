package com.miniSas.model;

import java.util.Date;

public class Emprunter_livreBuilder {
    private Date date_emprunte;
    private Date date_retour;
    private String ISBN;
    private int Id_utilisateur;

    public Emprunter_livreBuilder date_emprunte(Date NomEtPrenom){
        this.date_emprunte = date_emprunte;
        return this;
    }
    public Emprunter_livreBuilder date_retour(Date date_retour){
        this.date_retour = date_retour;
        return this;
    }
    public Emprunter_livreBuilder ISBN(String ISBN){
        this.ISBN = ISBN;
        return this;
    }
    public Emprunter_livreBuilder Id_utilisateur(int Id_utilisateur){
        this.Id_utilisateur = Id_utilisateur;
        return this;
    }
    public Emprunter_livre build(){
        return new Emprunter_livre(date_emprunte, date_retour, ISBN, Id_utilisateur);
    }
}
