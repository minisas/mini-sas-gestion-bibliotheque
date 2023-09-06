package com.miniSas.dao;

import com.miniSas.model.Emprunter_livre;
import com.miniSas.utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Empruner_livreDoaImpl implements Empruner_livreDoa{

    @Override
    public int checkStatusBook(String ISBN) {
        return 0;
    }

    @Override
    public void emprunterBook(Emprunter_livre Emprunter_livre) {
        Connection con = DBConnection.getConnection();
        if (con == null){
            return;
        }
        String query = "INSERT INTO emprunter_livre (date_emprunte,date_retour,ISBN,Id_utilisateur) VALUES (?,?,?,?)";
        try (PreparedStatement preparedStatement = con.prepareStatement(query);){
            preparedStatement.setDate(1, Utils.getSqlDate(Emprunter_livre.getDate_emprunte()));
            preparedStatement.setDate(2,Utils.getSqlDate(Emprunter_livre.getDate_retour()));
            preparedStatement.setString(3,Emprunter_livre.getISBN());
            preparedStatement.setInt(4,Emprunter_livre.getId_utilisateur());

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
        String query2 = "UPDATE `Livres` SET `Status`=1 WHERE `ISBN`=?";
        try (PreparedStatement preparedStatement2 = con.prepareStatement(query2);){
            preparedStatement2.setString(1,Emprunter_livre.getISBN());

            preparedStatement2.executeUpdate();
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

    @Override
    public void retourBook(String ISBN) {
        Connection con = DBConnection.getConnection();
        if (con == null){
            return;
        }
        String query = "DELETE FROM `Livres` WHERE `ISBN` = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query);) {

            preparedStatement.setString(1, ISBN);

            preparedStatement.executeUpdate();

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        String query2 = "UPDATE `Livres` SET `Status`=0 WHERE `ISBN`=?";
        try (PreparedStatement preparedStatement2 = con.prepareStatement(query2);){
            preparedStatement2.setString(1,ISBN);

            preparedStatement2.executeUpdate();
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

    @Override
    public void perduBook(String ISBN) {

    }
}
