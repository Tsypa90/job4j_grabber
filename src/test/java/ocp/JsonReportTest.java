package ocp;

import org.junit.Test;
import srp.Employee;
import srp.MemStore;

import java.util.Calendar;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class JsonReportTest {

    @Test
    public void generate() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        JsonReport report = new JsonReport(store);
        StringBuilder expected = new StringBuilder();
        expected.append("[{\"name\":\"").append(worker.getName()).append("\",\"hired\":{\"year\":").append(worker.getHired().getTime().getYear() + 1900)
                .append(",\"month\":").append(worker.getHired().getTime().getMonth()).append(",\"dayOfMonth\":")
                .append(worker.getHired().getTime().getDate()).append(",\"hourOfDay\":")
                .append(worker.getHired().getTime().getHours()).append(",\"minute\":")
                .append(worker.getHired().getTime().getMinutes()).append(",\"second\":")
                .append(worker.getHired().getTime().getSeconds()).append("},\"fired\":{\"year\":")
                .append(worker.getFired().getTime().getYear() + 1900)
                .append(",\"month\":").append(worker.getFired().getTime().getMonth()).append(",\"dayOfMonth\":")
                .append(worker.getFired().getTime().getDate()).append(",\"hourOfDay\":")
                .append(worker.getFired().getTime().getHours()).append(",\"minute\":")
                .append(worker.getFired().getTime().getMinutes()).append(",\"second\":")
                .append(worker.getFired().getTime().getSeconds()).append("},\"salary\":").append(worker.getSalary())
                .append("}]");
        assertThat(report.generate(em -> true), is(expected.toString()));
    }
}