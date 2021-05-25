package ru.job4j.jdbc;

import java.sql.*;

public class StatementDemo {

    public Connection getConnection() {
        return connection;
    }

    private Connection connection;

    private void initConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/idea_bd";
        String login = "postgres";
        String password = "password";
        connection = DriverManager.getConnection(url, login, password);
    }

    public static void main(String[] args) throws Exception {
        StatementDemo st = new StatementDemo();
        st.initConnection();
        try (Connection connection = st.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "create table if not exists demo_table(%s, %s);",
                        "id serial primary key",
                        "name varchar(255)"
                );
                statement.execute(sql);
                statement.execute(String.format("alter table demo_table add column names varchar(256)"));
                System.out.println(st.getTableScheme(connection, "demo_table"));
            }
        }
    }

    public String getTableScheme(Connection connection, String tableName) throws Exception {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet columns = metaData.getColumns(null, null, tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while (columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        }
        return scheme.toString();
    }

}