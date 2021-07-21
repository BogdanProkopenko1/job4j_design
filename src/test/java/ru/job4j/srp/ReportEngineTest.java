package ru.job4j.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenAccountantGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 150);
        store.add(worker);
        Report engine = new AccountantsReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append((double) 2).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenNewGeneratedHR() {
        MemStore store = new MemStore();
        Calendar now = new GregorianCalendar(2021, Calendar.AUGUST, 1);
        Employee worker0 = new Employee("Arseny", new GregorianCalendar(2011, Calendar.MARCH, 17), now, 100000);
        Employee worker1 = new Employee("Bogdan", new GregorianCalendar(2018, Calendar.JANUARY, 11), now, 600000);
        Employee worker2 = new Employee("Egor",  new GregorianCalendar(2018, Calendar.DECEMBER, 3), now, 60000);
        Employee worker3 = new Employee("Makar", new GregorianCalendar(2021, Calendar.JULY, 8), now, 10000);
        Employee worker4 = new Employee("Matvey", new GregorianCalendar(2017, Calendar.SEPTEMBER, 25), now, 300000);
        Employee worker5 = new Employee("Igor", new GregorianCalendar(2021, Calendar.AUGUST, 30), now, 90000);
        store.add(worker0);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        store.add(worker4);
        store.add(worker5);
        Report engine = new HRReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker4.getName()).append(";")
                .append(worker4.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker0.getName()).append(";")
                .append(worker0.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker5.getName()).append(";")
                .append(worker5.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker3.getName()).append(";")
                .append(worker3.getSalary()).append(";");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenNewGeneratedProgrammer() {
        MemStore store = new MemStore();
        Calendar now = new GregorianCalendar(2021, Calendar.AUGUST, 1);
        Employee worker0 = new Employee("Arseny", new GregorianCalendar(2011, Calendar.MARCH, 17), now, 100000);
        Employee worker1 = new Employee("Bogdan", new GregorianCalendar(2018, Calendar.JANUARY, 11), now, 600000);
        Employee worker2 = new Employee("Egor",  new GregorianCalendar(2018, Calendar.DECEMBER, 3), now, 60000);
        Employee worker3 = new Employee("Makar", new GregorianCalendar(2021, Calendar.JULY, 8), now, 10000);
        Employee worker4 = new Employee("Matvey", new GregorianCalendar(2017, Calendar.SEPTEMBER, 25), now, 300000);
        Employee worker5 = new Employee("Igor", new GregorianCalendar(2021, Calendar.AUGUST, 30), now, 90000);
        store.add(worker0);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        store.add(worker4);
        store.add(worker5);
        Report engine = new ProgrammersReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("<!DOCTYPE html>").append(System.lineSeparator())
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
                .append("</tr>").append(System.lineSeparator()).append("<tr>").append(System.lineSeparator())
                .append("<td>").append(worker0.getName()).append("</td>").append(System.lineSeparator())
                .append("<td>").append(worker0.getHired().getTime()).append("</td>").append(System.lineSeparator())
                .append("<td>").append(worker0.getFired().getTime()).append("</td>").append(System.lineSeparator())
                .append("<td>").append(worker0.getSalary()).append("</td>").append(System.lineSeparator())
                .append("</tr>").append(System.lineSeparator()).append("<tr>").append(System.lineSeparator())
                .append("<td>").append(worker1.getName()).append("</td>").append(System.lineSeparator())
                .append("<td>").append(worker1.getHired().getTime()).append("</td>").append(System.lineSeparator())
                .append("<td>").append(worker1.getFired().getTime()).append("</td>").append(System.lineSeparator())
                .append("<td>").append(worker1.getSalary()).append("</td>").append(System.lineSeparator())
                .append("</tr>").append(System.lineSeparator()).append("<tr>").append(System.lineSeparator())
                .append("<td>").append(worker2.getName()).append("</td>").append(System.lineSeparator())
                .append("<td>").append(worker2.getHired().getTime()).append("</td>").append(System.lineSeparator())
                .append("<td>").append(worker2.getFired().getTime()).append("</td>").append(System.lineSeparator())
                .append("<td>").append(worker2.getSalary()).append("</td>").append(System.lineSeparator())
                .append("</tr>").append(System.lineSeparator()).append("<tr>").append(System.lineSeparator())
                .append("<td>").append(worker3.getName()).append("</td>").append(System.lineSeparator())
                .append("<td>").append(worker3.getHired().getTime()).append("</td>").append(System.lineSeparator())
                .append("<td>").append(worker3.getFired().getTime()).append("</td>").append(System.lineSeparator())
                .append("<td>").append(worker3.getSalary()).append("</td>").append(System.lineSeparator())
                .append("</tr>").append(System.lineSeparator()).append("<tr>").append(System.lineSeparator())
                .append("<td>").append(worker4.getName()).append("</td>").append(System.lineSeparator())
                .append("<td>").append(worker4.getHired().getTime()).append("</td>").append(System.lineSeparator())
                .append("<td>").append(worker4.getFired().getTime()).append("</td>").append(System.lineSeparator())
                .append("<td>").append(worker4.getSalary()).append("</td>").append(System.lineSeparator())
                .append("</tr>").append(System.lineSeparator()).append("<tr>").append(System.lineSeparator())
                .append("<td>").append(worker5.getName()).append("</td>").append(System.lineSeparator())
                .append("<td>").append(worker5.getHired().getTime()).append("</td>").append(System.lineSeparator())
                .append("<td>").append(worker5.getFired().getTime()).append("</td>").append(System.lineSeparator())
                .append("<td>").append(worker5.getSalary()).append("</td>").append(System.lineSeparator())
                .append("</tr>").append(System.lineSeparator())
                .append("</table>").append(System.lineSeparator())
                .append("</body").append(System.lineSeparator())
                .append("</html>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}