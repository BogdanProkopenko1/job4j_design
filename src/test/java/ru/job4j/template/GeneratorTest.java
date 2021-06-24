package ru.job4j.template;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class GeneratorTest {

    @Test
    public void parseFirst() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Messi");
        map.put("subject", "Ronaldo");
        assertThat(
                new Parser().produce("I am a ${name}, Who are ${subject}?", map),
                is("I am a Messi, Who are Ronaldo?"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void parseThrowsIAException() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Messi");
        new Parser().produce("I am a ${name}, Who are ${subject}?", map);
    }

    @Test (expected = IllegalArgumentException.class)
    public void parseSecond() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Messi");
        map.put("subject", "Ronaldo");
        map.put("something", "Anything");
        assertThat(
                new Parser().produce("I am a ${name}, Who are ${subject}?", map),
                is("I am a Messi, Who are Ronaldo?"));
    }
}