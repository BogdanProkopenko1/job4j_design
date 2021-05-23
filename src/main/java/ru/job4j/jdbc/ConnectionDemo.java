package ru.job4j.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ConnectionDemo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Map<String, String> map = new HashMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("./app.propeties"))) {
            String st = bufferedReader.readLine();
            while (st != null) {
                String[] els = st.split("=");
                map.put(els[0], els[1]);
                st = bufferedReader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Class.forName("org.postgresql.Driver");
        try (Connection connection = DriverManager.getConnection(map.get("url"), map.get("login"), map.get("password"))) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}