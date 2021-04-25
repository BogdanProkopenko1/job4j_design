package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleChat {

    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader buffReader = new BufferedReader(new FileReader(botAnswers));
        ArrayList<String> answers = buffReader.lines().collect(Collectors.toCollection(ArrayList::new));
        Random random =  new Random();
        Scanner scn = new Scanner(System.in);
        String msg = scn.nextLine();
        stringBuilder.append(msg).append(System.lineSeparator());
        boolean write = true;
        while (!msg.equals(OUT)) {
            if (write && msg.equals(STOP)) {
                write = false;
            } else if (msg.equals(CONTINUE)) {
                write = true;
            }
            if (write) {
                String answer = answers.get(random.nextInt(answers.size()));
                System.out.println(answer);
                stringBuilder.append(answer).append(System.lineSeparator());
            }
            msg = scn.nextLine();
            stringBuilder.append(msg).append(System.lineSeparator());
        }
        writer(stringBuilder);
    }

    private void writer(StringBuilder s) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(path))) {
            out.write(String.valueOf(s));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ConsoleChat cc = new ConsoleChat("C:/Users/pvzar/Desktop/Новая папка/log.txt", "C:/Users/pvzar/Desktop/Новая папка/answers.txt");
        cc.run();
    }
}