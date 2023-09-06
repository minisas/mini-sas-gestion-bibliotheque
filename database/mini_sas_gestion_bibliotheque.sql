DROP DATABASE IF EXISTS mini_sas_gestion_bibliotheque;

CREATE DATABASE mini_sas_gestion_bibliotheque;

USE mini_sas_gestion_bibliotheque;


CREATE TABLE Livres (
                        Titre varchar(30),
                        Nom_auteur varchar(30),
                        Status int(4),
                        ISBN varchar(255) UNIQUE KEY
);

CREATE TABLE Utilisateur (
                             Id_utilisateur int(15) PRIMARY KEY AUTO_INCREMENT,
                             NomEtPrenom varchar(30)
);

CREATE TABLE Emprunter_livre (
                                 date_emprunte date,
                                 date_retour date,
                                 ISBN varchar(255),
                                 Id_utilisateur int(15),
                                 FOREIGN KEY (ISBN) REFERENCES Livres(ISBN),
                                 FOREIGN KEY (Id_utilisateur) REFERENCES Utilisateur(Id_utilisateur)
);