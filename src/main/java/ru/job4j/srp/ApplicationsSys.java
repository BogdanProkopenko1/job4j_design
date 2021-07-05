package ru.job4j.srp;

import java.sql.*;
import java.util.Scanner;

public class ApplicationsSys implements RequestSystem {

    private Connection cnn = DriverManager.getConnection(
            "jdbc:postgresql://127.0.0.1:5432/idea_bd",
            "postgres",
            "password"
    );

    public ApplicationsSys() throws SQLException {
    }

    @Override
    public void add() {
        System.out.println("enter request message");
        addDB(new Scanner(System.in).nextLine());
    }

    @Override
    public void delete() {
        System.out.println("enter id for delete");
        deleteDB(Integer.parseInt(new Scanner(System.in).nextLine()));
    }

    @Override
    public void get() {
        System.out.println("enter id for getting");
        getDB(Integer.parseInt(new Scanner(System.in).nextLine()));
    }

    @Override
    public void addDB(String request) {
        java.util.Date date = new java.util.Date();
        try (PreparedStatement statement = cnn.prepareStatement(
                "insert into applications(text, date) values(?, ?)", Statement.RETURN_GENERATED_KEYS
        )) {
            statement.setString(1, request);
            statement.setDate(2, new Date(date.getYear(), date.getMonth(), date.getDay()));
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDB(int id) {
        try (PreparedStatement statement = cnn.prepareStatement("delete from applications where id = ?")) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getDB(int id) {
        try (PreparedStatement statement = cnn.prepareStatement("select * from applications where id = ?")) {
            statement.setInt(1, id);
            statement.execute();
            ResultSet result = statement.getResultSet();
            result.next();
            System.out.println(
                    "request id= " + result.getInt("id")
                            + " ; message= " + result.getString("text")
                            + " ; date= " + result.getDate("date")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        ApplicationsSys application = new ApplicationsSys();
        application.add();
        application.add();
        application.delete();
        application.get();

    }
}