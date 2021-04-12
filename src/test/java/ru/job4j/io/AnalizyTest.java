package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalizyTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenNormal() throws IOException {
        File source = folder.newFile("source.log");
        File target = folder.newFile("target.txt");
        try (PrintWriter writer = new PrintWriter(source)) {
            writer.write(
                    "200 10:56:01\n" +
                    "200 10:57:01\n" +
                    "400 10:58:01\n" +
                    "200 10:59:01\n" +
                    "500 11:01:02\n" +
                    "200 11:02:02"
            );
        }
        new Analizy().unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(el -> {
                String string = el + System.lineSeparator();
                rsl.append(string);
            });
        }
        String ex = "<10:58:01;10:59:01\n" +
                "11:01:02;11:02:02\n" +
                ">";
        assertThat(rsl, is(ex));
    }

}