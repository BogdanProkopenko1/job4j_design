package ru.job4j.serialization.java;

import com.sun.xml.txw2.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;

@XmlElement(value = "user")

public class User {

    @XmlAttribute
    private String name;
    private String pass;

    public User() { }

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
