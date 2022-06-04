package srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class HrReportTest {
    @Test
    public void HrGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee pavel = new Employee("Pavel", now, now, 100);
        Employee olga = new Employee("Olga", now, now, 160);
        Employee dmitry = new Employee("Dmitry", now, now, 80);
        store.add(pavel);
        store.add(olga);
        store.add(dmitry);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(olga.getName()).append(";")
                .append(olga.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(pavel.getName()).append(";")
                .append(pavel.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(dmitry.getName()).append(";")
                .append(dmitry.getSalary()).append(";")
                .append(System.lineSeparator());
        Report engine = new HrReport(store);
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}