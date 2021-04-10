package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalizyTest {

    @Test
    public void whenNormal() {
        new Analizy().unavailable("server.log", "target.txt");
        List<String> rsl = new ArrayList<String>();
        try (BufferedReader out = new BufferedReader(new FileReader("analyzed.txt"))) {
            String curr = out.readLine();
            while (curr != null) {
                rsl.add(curr);
                curr = out.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> exp = List.of("10:58:01;10:59:01", "11:01:02;11:02:02");
        assertThat(rsl, is(exp));
    }

}