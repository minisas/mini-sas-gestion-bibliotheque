package com.miniSas.model;

public class Utilisateur {
    private  int Id_utilisateur;
    private String NomEtPrenom;

    public Utilisateur() {
    }

    public Utilisateur(int id_utilisateur, String nomEtPrenom) {
        this.Id_utilisateur = id_utilisateur;
        this.NomEtPrenom = nomEtPrenom;
    }

    public int getId_utilisateur() {
        return Id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.Id_utilisateur = id_utilisateur;
    }

    public String getNomEtPrenom() {
        return NomEtPrenom;
    }

    public void setNomEtPrenom(String nomEtPrenom) {
        this.NomEtPrenom = nomEtPrenom;
    }

    public static UtilisateurBuilder builder(){
        return new UtilisateurBuilder();
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "Id_utilisateur=" + Id_utilisateur +
                ", NomEtPrenom='" + NomEtPrenom + '\'' +
                '}';
    }
}
