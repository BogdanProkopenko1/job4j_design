package ru.job4j.serialization.java;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import ru.job4j.collection.list.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;

@XmlRootElement(name = "jsontest")
@XmlAccessorType(XmlAccessType.FIELD)

public class JSONTest {

    @XmlAttribute
    private boolean resolution;
    private int balance;
    private String login;
    private User user;

    private String[] requisites;

    public JSONTest() { }

    public JSONTest(boolean resolution, int balance, String login, String[] requisites, User user) {
        this.resolution = resolution;
        this.balance = balance;
        this.requisites = requisites;
        this.login = login;
        this.user = user;
    }


    public boolean isResolution() {
        return resolution;
    }

    public int getBalance() {
        return balance;
    }

    public String getLogin() {
        return login;
    }

    public User getUser() {
        return user;
    }

    public String[] getRequisites() {
        return requisites;
    }

    @Override
    public String toString() {
        return "JSONTest{"
                + "resolution=" + resolution
                + ", balance=" + balance
                + ", login='" + login + '\''
                + ", requisites=" + Arrays.toString(requisites)
                + ", user=" + user
                + '}';
    }

    public static void main(String[] args) throws JAXBException {
        JSONTest pre = new JSONTest(
                true, 0, "log", new String[]{"hr", "pm"},
                new User("Name", "password")
        );
        final Gson gson = new GsonBuilder().create();
        String el = gson.toJson(pre);
        System.out.println(el);
        final JSONTest post = gson.fromJson(el, JSONTest.class);
        System.out.println(post + System.lineSeparator());
        JAXBContext context = JAXBContext.newInstance(JSONTest.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(pre, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            JSONTest result = (JSONTest) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }

        JSONObject jsonUser = new JSONObject(
                "{"
                        + "\"name\":i am"
                        + "\"pass\":passw"
                        + "}"
        );
    }
}
        /* JSONArray из ArrayList *
        List<String> list = new ArrayList<String>();
        list.add("Student");
        list.add("Free");
        JSONArray jsonStatuses = new JSONArray(list);

        /* JSONObject напрямую методом put *
        final JSONTest jsonTest = new JSONTest(false, 1, "LoGiN1", new String[] {"gt"}, new User("Bogdan", "password"));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("resolution", jsonTest.isResolution());
        jsonObject.put("age", person.getAge());
        jsonObject.put("contact", jsonContact);
        jsonObject.put("statuses", jsonStatuses);

        /* Выведем результат в консоль *
        System.out.println(jsonObject.toString());

        /* Преобразуем объект person в json-строку *
        System.out.println(new JSONObject(person).toString());
    }
}
         */