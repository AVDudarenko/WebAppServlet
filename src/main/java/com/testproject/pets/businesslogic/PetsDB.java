package com.testproject.pets.businesslogic;

import java.sql.*;
import java.util.ArrayList;

import static com.testproject.pets.businesslogic.DataBaseConnection.getDBConnection;

/**
 * In this class, we are create realisation of base methods, for working with the table pets.info.
 */
public class PetsDB {
    private static Pet pet = null;

    /**
     * Select all records from table.
     *
     * @return list of pets info
     */
    public static ArrayList<Pet> select() {

        ArrayList<Pet> pets = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = getDBConnection()) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM pets.info");
                while (resultSet.next()) {
                    pets.add(getPetObjectInfo(resultSet));
                }
            }

        } catch (Exception exception) {
            System.out.println(exception);
        }

        return pets;
    }

    /**
     * Select one record from table
     *
     * @param id contains id as primary key ,of pet
     * @return one pet.info record
     */
    public static Pet selectOne(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = getDBConnection()) {
                String sql = "SELECT * FROM pets.info WHERE id=?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        getPetObjectInfo(resultSet);
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return pet;
    }

    /**
     * Insert int pets.info new information about pet
     *
     * @param pet contains pet info
     * @return returns the number of added rows
     */
    public static int insert(Pet pet) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = getDBConnection()) {

                String sql = "INSERT INTO pets.info (name, age, color, owner) Values (?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, pet.getName());
                    preparedStatement.setInt(2, pet.getAge());
                    preparedStatement.setString(3, pet.getColor());
                    preparedStatement.setString(4, pet.getOwner());

                    return preparedStatement.executeUpdate();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }

    /**
     * Update information about pet
     *
     * @param pet contains pet info
     * @return returns the number of updated rows
     */
    public static int update(Pet pet) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = getDBConnection()) {
                String sql = "UPDATE pets.info SET name = ?, age = ?, color = ?, owner = ? WHERE id = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, pet.getName());
                    preparedStatement.setInt(2, pet.getAge());
                    preparedStatement.setString(3, pet.getColor());
                    preparedStatement.setString(4, pet.getOwner());
                    preparedStatement.setInt(5, pet.getId());

                    return preparedStatement.executeUpdate();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }

    /**
     * Delete information about pet in DB
     *
     * @param id contains id of element to delete
     * @return returns the number of removed rows
     */
    public static int delete(int id) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = getDBConnection()) {

                String sql = "DELETE FROM pets.info WHERE id = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setInt(1, id);

                    return preparedStatement.executeUpdate();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }

    /**
     * Create new pet object.
     *
     * @param resultSet contains SQL code of request to DB
     * @return new pet object
     * @throws SQLException
     */
    private static Pet getPetObjectInfo(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        String name = resultSet.getString(2);
        int age = resultSet.getInt(3);
        String color = resultSet.getString(4);
        String owner = resultSet.getString(5);
        pet = new Pet(id, name, age, color, owner);

        return pet;
    }
}
