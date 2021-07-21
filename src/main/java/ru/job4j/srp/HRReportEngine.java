package ru.job4j.srp;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class HRReportEngine implements Report {

    private Store store;

    public HRReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("Name; Salary;");
        List<Employee> employees = store.findBy(filter);
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int) (o2.getSalary() - o1.getSalary());
            }
        });
        for (Employee employee : employees) {
            strBuilder.append(System.lineSeparator());
            strBuilder.append(employee.getName()).append(";");
            strBuilder.append(employee.getSalary()).append(";");
        }
        return String.valueOf(strBuilder);
    }
}