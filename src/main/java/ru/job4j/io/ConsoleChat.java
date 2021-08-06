package ru.job4j.io;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class ConsoleChat {

    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private Scanner scn;
    private List<String> log = new ArrayList<>();
    private boolean write = true;

    public ConsoleChat(String path, String botAnswers, Scanner scanner) {
        this.path = path;
        this.botAnswers = botAnswers;
        this.scn = scanner;
    }

    public void run() {
        List<String> answers = new ArrayList<>();
        try (BufferedReader buffReader = new BufferedReader(new FileReader(botAnswers))) {
            answers = buffReader.lines().collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        Random random = new Random();
        boolean stop = writeMsg();
        while (!stop) {
            if (write) {
                String answer = answers.get(random.nextInt(answers.size()));
                System.out.println(answer);
                log.add(answer);
            }
            stop = writeMsg();
        }
        write();
    }

    private boolean writeMsg() {
        String msg = scn.nextLine();
        boolean stop = false;
        if (!msg.equals(OUT)) {
            if (this.write && msg.equals(STOP)) {
                this.write = false;
            } else if (msg.equals(CONTINUE)) {
                this.write = true;
            }
        } else {
            stop = true;
        }
        log.add(msg);
        return stop;
    }

    private void write() {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(path))) {
            for (String s : log) {
                out.write(s);
                out.write(System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat(
                "C:/Users/pvzar/Desktop/log.csv/Новая папка (2)/Новая папка/log.txt",
                "C:/Users/pvzar/Desktop/log.csv/Новая папка (2)/Новая папка/answers.txt",
                new Scanner(System.in)
        );
        cc.run();
    }
}