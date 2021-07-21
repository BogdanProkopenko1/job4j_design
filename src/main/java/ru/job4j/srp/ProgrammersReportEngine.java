package ru.job4j.srp;

import java.util.function.Predicate;

public class ProgrammersReportEngine implements Report {

    private Store store;

    public ProgrammersReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("<!DOCTYPE html>").append(System.lineSeparator())
                .append("<html lang=\"en\">").append(System.lineSeparator())
                .append("<head>").append(System.lineSeparator())
                .append("<meta charset=\"utf-8\">").append(System.lineSeparator())
                .append("<title>REPORT</title>").append(System.lineSeparator())
                .append("</head>").append(System.lineSeparator())
                .append("<body>").append(System.lineSeparator())
                .append("<table>").append(System.lineSeparator())
                .append("<tr>").append(System.lineSeparator())
                .append("<td>Name</td>").append(System.lineSeparator())
                .append("<td>Hired</td>").append(System.lineSeparator())
                .append("<td>Fired</td>").append(System.lineSeparator())
                .append("<td>Salary</td>").append(System.lineSeparator())
                .append("</tr>").append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            strBuilder.append("<tr>").append(System.lineSeparator())
                    .append("<td>").append(employee.getName()).append("</td>").append(System.lineSeparator())
                    .append("<td>").append(employee.getHired().getTime()).append("</td>").append(System.lineSeparator())
                    .append("<td>").append(employee.getFired().getTime()).append("</td>").append(System.lineSeparator())
                    .append("<td>").append(employee.getSalary()).append("</td>").append(System.lineSeparator())
                    .append("</tr>").append(System.lineSeparator());
        }
        strBuilder.append("</table>").append(System.lineSeparator())
                .append("</body").append(System.lineSeparator())
                .append("</html>");
        return String.valueOf(strBuilder);
    }
}