package com.miniSas.model;

public class UtilisateurBuilder {
    private  int Id_utilisateur;
    private String NomEtPrenom;

    public UtilisateurBuilder Id_utilisateur(int Id_utilisateur){
        this.Id_utilisateur = Id_utilisateur;
        return this;
    }
    public UtilisateurBuilder NomEtPrenom(String NomEtPrenom){
        this.NomEtPrenom = NomEtPrenom;
        return this;
    }
    public Utilisateur build(){
        return new Utilisateur(Id_utilisateur, NomEtPrenom);
    }
}
