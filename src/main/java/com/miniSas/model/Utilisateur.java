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
        String id_user = String.valueOf(Id_utilisateur);
        tr += createTr(id_user);
        tr += createTr(NomEtPrenom);

        return tr;
    }
}
