package ru.job4j.io;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./app.propeties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"),is("Petr Arsentev"));
        assertThat(config.value("hibernate.connection.password"),is("password"));
    }

    @Test
    public void whenComment() {
        String path = "./app.propeties";
        Config config = new Config(path);
        config.load();
        assertNull(config.value("key"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenIllegalArgException() {
        String path = "./apperror.propeties";
        Config config = new Config(path);
        config.load();
    }
}