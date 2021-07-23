package ru.job4j.srp;

import java.util.function.Predicate;

public class XMLReportEngine implements Report {

    private Store store;

    public XMLReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<?xml version=\"1.1\" encoding=\"UTF-8\" ?>");
        for (Employee employee : store.findBy(filter)) {
            text.append(System.lineSeparator())
                    .append("<employee name=\"").append(employee.getName())
                    .append("\" hired=\"").append(employee.getHired())
                    .append("\" fired=\"").append(employee.getFired())
                    .append("\" salary=\"").append(employee.getSalary())
                    .append("\"/>");
        }
        return text.toString();
    }
}