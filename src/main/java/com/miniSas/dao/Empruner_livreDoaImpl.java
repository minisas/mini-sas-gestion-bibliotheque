package com.miniSas.dao;

import com.miniSas.model.Emprunter_livre;
import com.miniSas.utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Calendar;

public class Empruner_livreDoaImpl implements Empruner_livreDoa{

    @Override
    public int checkStatusBook(String ISBN) {
        // la valeur retourner : -1 = le livre est perdu | 0 = le livre fait son retour | 1 = en cour emprunter
        Connection con = DBConnection.getConnection();
        if (con == null){
            return 2;
        }
        String date_retour = "";

        int anneeRetour=0;
        int moisRetour=0;
        int jourRetour=0;

        int casDeBook;

        Date date_aujourdHui = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date_aujourdHui);
        int anneeAujourdHui = calendar.get(Calendar.YEAR);
        int moisAujourdHui = calendar.get(Calendar.MONTH) + 1;
        int jourAujourdHui = calendar.get(Calendar.DAY_OF_MONTH);

        String query = "SELECT * FROM `emprunter_livre` el, `livres` l WHERE el.`ISBN` = ? AND l.Status = 1 ORDER BY el.`date_retour` DESC LIMIT 1";
        try (PreparedStatement preparedStatement = con.prepareStatement((query))){
            preparedStatement.setString(1,ISBN);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                date_retour = String.valueOf(resultSet.getDate("date_retour"));
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = dateFormat.parse(date_retour);
                java.util.Calendar calendar2 = java.util.Calendar.getInstance();
                calendar2.setTime(date);
                anneeRetour = calendar2.get(java.util.Calendar.YEAR);
                moisRetour = calendar2.get(java.util.Calendar.MONTH) + 1;
                jourRetour = calendar2.get(java.util.Calendar.DAY_OF_MONTH);
                if (anneeRetour>anneeAujourdHui){
                    return 1;
                }
                if (anneeAujourdHui>anneeRetour){
                    perduBook(ISBN);
                    return -1;
                }
                if (anneeAujourdHui==anneeRetour){
                    if (moisRetour>moisAujourdHui){
                        return 1;
                    }
                    if (moisRetour<moisAujourdHui){
                        perduBook(ISBN);
                        return -1;
                    }
                    if (moisRetour==moisAujourdHui){
                        if (jourRetour>jourAujourdHui){
                            return 1;
                        }
                        if (jourRetour<jourAujourdHui){
                            perduBook(ISBN);
                            return -1;
                        }
                    }
                }
            }

        } catch (SQLException se){
            se.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                con.close();
            } catch (SQLException se){
                se.printStackTrace();
            }
        }

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
            preparedStatement.setDate(2, Utils.getSqlDate(Emprunter_livre.getDate_retour()));
            preparedStatement.setString(3,Emprunter_livre.getISBN());
            preparedStatement.setInt(4,Emprunter_livre.getId_utilisateur());

            preparedStatement.executeUpdate();
        } catch (SQLException se){
            se.printStackTrace();
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
        String query = "UPDATE `Livres` SET `Status`=0 WHERE `ISBN`=?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query);){
            preparedStatement.setString(1,ISBN);

            preparedStatement.executeUpdate();
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

    @Override
    public void perduBook(String ISBN) {
        Connection con = DBConnection.getConnection();
        if (con == null){
            return;
        }
        String query = "UPDATE `Livres` SET `Status`=-1 WHERE `ISBN`=?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query);){
            preparedStatement.setString(1,ISBN);

            preparedStatement.executeUpdate();
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
}
