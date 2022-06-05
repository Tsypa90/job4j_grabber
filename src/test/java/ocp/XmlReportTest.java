package ocp;

import org.junit.Test;
import srp.Employee;
import srp.MemStore;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class XmlReportTest {

    @Test
    public void generate() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        XmlReport report = new XmlReport(store);
        StringBuilder expected = new StringBuilder();
        expected.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<employees>\n"
                + "    <employees>\n"
                + "        <fired>").append(dateFormat.format(worker.getFired().getTime())).append("</fired>\n")
                        .append("        <hired>").append(dateFormat.format(worker.getHired().getTime()))
                        .append("</hired>\n").append("        <name>").append(worker.getName()).append("</name>\n")
                        .append("        <salary>").append(worker.getSalary()).append("</salary>\n")
                        .append("    </employees>\n"
                                + "</employees>\n");
        assertThat(report.generate(em -> true), is(expected.toString()));
    }
}