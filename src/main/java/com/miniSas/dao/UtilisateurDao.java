package com.miniSas.dao;

import com.miniSas.model.Utilisateur;

import java.util.List;

public interface UtilisateurDao {
    List<Utilisateur> findAll();

    int save(Utilisateur Utilisateur);

    void deleteById_utilisateur(int id);
}
