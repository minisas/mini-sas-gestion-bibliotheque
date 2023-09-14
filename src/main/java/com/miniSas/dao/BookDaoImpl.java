package com.miniSas.dao;

import com.miniSas.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

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
    public List<Book> findAllBookDisponible() {
        Connection con =DBConnection.getConnection();
        if (con == null) {
            return null;
        }

        List<Book> Books = new LinkedList<>();

        String query = "SELECT * FROM Livres WHERE Status = 0";
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
    public List<Book> findAllBookEmprunter() {
        Connection con =DBConnection.getConnection();
        if (con == null) {
            return null;
        }

        List<Book> Books = new LinkedList<>();

        String query = "SELECT * FROM Livres WHERE Status = 1";
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
                    preparedStatement2.setInt(3,0);
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
    public void deleteByISBN(String ISBN) {
        Connection con = DBConnection.getConnection();
        if (con == null) {
            return;
        }
        if (ISBN == "ALL"){
            String query = "UPDATE `Livres` SET `Status`= -2 WHERE `Status`= -1";
            try (PreparedStatement preparedStatement = con.prepareStatement(query);) {

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
        }else {
            String query = "SELECT * FROM Livres WHERE `ISBN`=?";
            try (PreparedStatement preparedStatement = con.prepareStatement((query))){

                ResultSet resultSet = preparedStatement.executeQuery();
                int Status = 0;
                while (resultSet.next()){
                    Status = resultSet.getInt("Status");
                }
                if (Status != 1){
                    String query2 = "UPDATE `Livres` SET `Status` = -2 WHERE `ISBN`=?";
                    try (PreparedStatement preparedStatement2 = con.prepareStatement(query2);) {

                        preparedStatement2.setString(1, ISBN);

                        preparedStatement2.executeUpdate();

                    } catch (SQLException se) {
                        se.printStackTrace();
                    }
                }else {
                    System.out.println("On ne peut pas supprimer ce livre qui contient ISBN = "+ISBN);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
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

        String query = "SELECT * FROM Livres WHERE (Nom_auteur LIKE '%"+Nom_auteurTitre+"%' OR Titre LIKE '%"+Nom_auteurTitre+"%') AND `Status` != -2";
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
    public int statistique(int Status) {
        int Statistique = 0;
        Connection con =DBConnection.getConnection();
        if (con == null) {
            return 0;
        }
        if (Status == 2){
            String query = "SELECT COUNT(*) AS Statistique FROM `Livres` WHERE `Status` = -1 OR `Status` = 0 OR `Status` = 1";
            try (PreparedStatement preparedStatement = con.prepareStatement(query);) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Statistique = resultSet.getInt("Statistique");
                }
            } catch (SQLException se) {
                se.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } else{
            String query = "SELECT COUNT(*) AS Statistique FROM `Livres` WHERE `Status` = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement(query);) {
                preparedStatement.setInt(1, Status);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Statistique = resultSet.getInt("Statistique");
                }
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
        return Statistique;
    }

}
