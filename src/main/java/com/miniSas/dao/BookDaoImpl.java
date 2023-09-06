package com.miniSas.dao;

import com.miniSas.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class BookDaoImpl implements BookDao {

    @Override
    public List<Book> findAll() {
        Connection con =DBConnection.getConnection();
        if (con == null) {
            return null;
        }

        List<Book> Books = new LinkedList<>();

        String query = "SELECT * FROM Livres";
        try (PreparedStatement preparedStatement = con.prepareStatement((query))){

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Book book = new Book (resultSet.getString("Titre"),
                        resultSet.getString("Nom_auteur"),
                        resultSet.getInt("Status"),
                        resultSet.getString("ISBN"));
                Books.add(book);
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

        return Books;
    }

    @Override
    public void save(Book Book) {
        Connection con = DBConnection.getConnection();
        if (con == null){
            return;
        }
        String query = "SELECT * FROM `Livres` WHERE `ISBN`=?";
        String bookISBN = null;
        try (PreparedStatement preparedStatement = con.prepareStatement(query);){
            preparedStatement.setString(1,Book.getISBN());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                bookISBN = resultSet.getString("ISBN");
            }
            if (bookISBN == null) {
                String query2 = "INSERT INTO Livres (Titre, Nom_auteur, Status, ISBN) VALUES (?,?,?,?)";
                try (PreparedStatement preparedStatement2 = con.prepareStatement(query2);){
                    preparedStatement2.setString(1,Book.getTitre());
                    preparedStatement2.setString(2,Book.getNom_auteur());
                    preparedStatement2.setInt(3,Book.getStatus());
                    preparedStatement2.setString(4,Book.getISBN());

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
            else {
                String query2 = "UPDATE `Livres` SET `Titre`=?,`Nom_auteur`=?, `Status`=? WHERE `ISBN`=?";
                try (PreparedStatement preparedStatement2 = con.prepareStatement(query2);){
                    preparedStatement2.setString(1,Book.getTitre());
                    preparedStatement2.setString(2,Book.getNom_auteur());
                    preparedStatement2.setInt(3,Book.getStatus());
                    preparedStatement2.setString(4,Book.getISBN());

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
    public void deleteByISBN(int ISBN) {
        Connection con = DBConnection.getConnection();
        if (con == null) {
            return;
        }
        String query = "DELETE FROM `Livres` WHERE `ISBN` = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query);) {

            preparedStatement.setInt(1, ISBN);

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
    }

    @Override
    public List<Book> findAllByNom_auteurOrTitle(String Nom_auteurTitre) {
        Connection con =DBConnection.getConnection();
        if (con == null) {
            return null;
        }

        List<Book> Books = new LinkedList<>();

        String query = "SELECT * FROM Livres WHERE Nom_auteur LIKE '%"+Nom_auteurTitre+"%' OR Titre LIKE '%"+Nom_auteurTitre+"%'";
        try (PreparedStatement preparedStatement = con.prepareStatement((query))){

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Book book = new Book (resultSet.getString("Titre"),
                        resultSet.getString("Nom_auteur"),
                        resultSet.getInt("Status"),
                        resultSet.getString("ISBN"));
                Books.add(book);
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

        return Books;
    }

}
