package com.miniSas.dao;

import com.miniSas.model.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UtilisateurDaoImpl implements UtilisateurDao
{

    @Override
    public List<Utilisateur> findAll() {
        Connection con =DBConnection.getConnection();
        if (con == null) {
            return null;
        }

        List<Utilisateur> Utilisateurs = new LinkedList<>();

        String query = "SELECT * FROM Utilisateur";
        try (PreparedStatement preparedStatement = con.prepareStatement((query))){

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Utilisateur Utilisateur = new Utilisateur (resultSet.getInt("Id_utilisateur"),
                        resultSet.getString("NomEtPrenom"));
                Utilisateurs.add(Utilisateur);
            }

        } catch (SQLException se){
            se.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se){
                se.printStackTrace();
            }
        }

        return Utilisateurs;
    }

    @Override
    public int save(Utilisateur Utilisateur) {
        Connection con = DBConnection.getConnection();
        if (con == null){
            return 0;
        }

        if(Utilisateur.getId_utilisateur() > 0){ // update
            String query = "UPDATE `Utilisateur` SET `NomEtPrenom`=? WHERE `Id_utilisateur`=?";
            try (PreparedStatement preparedStatement = con.prepareStatement(query);){
                preparedStatement.setString(1,Utilisateur.getNomEtPrenom());
                preparedStatement.setInt(2,Utilisateur.getId_utilisateur());

                preparedStatement.executeUpdate();
            } catch (SQLException se){
                se.printStackTrace();
            }finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }else { //create
            String query = "INSERT INTO Utilisateur (NomEtPrenom) VALUES (?)";
            try (PreparedStatement preparedStatement = con.prepareStatement(query);){
                preparedStatement.setString(1,Utilisateur.getNomEtPrenom());

                preparedStatement.executeUpdate();
            } catch (SQLException se){
                se.printStackTrace();
            }
            String query2 = "SELECT * FROM Utilisateur WHERE NomEtPrenom = ?";
            try (PreparedStatement preparedStatement2 = con.prepareStatement(query2);){
                preparedStatement2.setString(1,Utilisateur.getNomEtPrenom());

                ResultSet resultSet = preparedStatement2.executeQuery();
                if (resultSet.next()) {
                    return resultSet.getInt("Id_utilisateur");
                } else {
                    return 0;
                }
            } catch (SQLException se){
                se.printStackTrace();
            }
            finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return 0;
    }

    @Override
    public void deleteById_utilisateur(int id) {
        Connection con = DBConnection.getConnection();
        if (con == null){
            return;
        }
        String query = "DELETE FROM `Utilisateur` WHERE `Id_utilisateur` = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query);){

            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();

        } catch (SQLException se){
            se.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
