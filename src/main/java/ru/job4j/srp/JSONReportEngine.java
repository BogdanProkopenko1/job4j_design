package ru.job4j.srp;

import java.util.function.Predicate;

public class JSONReportEngine implements Report {

    private Store store;

    public JSONReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("{");
        for (Employee employee : store.findBy(filter)) {
            text.append(System.lineSeparator()).append("\"employee\" : {")
                    .append(System.lineSeparator()).append("\"name\":").append("\"")
                    .append(employee.getName()).append("\",")
                    .append(System.lineSeparator()).append("\"hired\":").append("\"")
                    .append(employee.getHired().getTime()).append("\",")
                    .append(System.lineSeparator()).append("\"fired\":").append("\"")
                    .append(employee.getFired().getTime()).append("\",")
                    .append(System.lineSeparator()).append("\"salary\":").append("\"")
                    .append(employee.getSalary()).append("\"").append(System.lineSeparator())
                    .append("}");
        }
        text.append(System.lineSeparator()).append("}");
        return text.toString();
    }
}