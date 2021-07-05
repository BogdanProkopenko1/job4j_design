package ru.job4j.srp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.*;

public class Parser {

    private Connection connection;

    public Parser() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/idea_bd", "postgres", "password");
    }

    private static class Post {
        String msg;
        LocalDateTime created;

        public Post(String msg, LocalDateTime created) {
            this.msg = msg;
            this.created = created;
        }
    }

    private java.util.List<Post> parseSite(String link) throws IOException {
        Document doc = Jsoup.connect(link).get();
        Elements names = doc.select("tbody > tr > td.postslisttopic");
        Elements dates = doc.select("tbody > tr > td:nth-child(6)");
        DateTimeParser dateTimeParser = new DateTimeParser();
        java.util.List<Post> list = new ArrayList<>();
        for (int i = 3; i < names.size(); i++) {
            list.add(new Post(names.get(i).text(), dateTimeParser.parse(dates.get(i).text())));
        }
        return list;
    }

    private void saveDB(List<Post> list) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into vacancies(message, created) values(?, ?)", Statement.RETURN_GENERATED_KEYS
        )) {
            for (Post p : list) {
                preparedStatement.setString(1, p.msg);
                preparedStatement.setTimestamp(2, Timestamp.valueOf(p.created));
                preparedStatement.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        Parser parser = new Parser();
        List<Post> list = parser.parseSite("https://www.sql.ru/forum/job-offers/");
        parser.saveDB(list);
        System.out.println("complete");
    }
}