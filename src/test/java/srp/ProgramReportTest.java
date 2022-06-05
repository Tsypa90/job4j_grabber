package srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProgramReportTest {
    @Test
    public void whenProgramGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ProgramReport(store);
        StringBuilder expect = new StringBuilder()
                .append("<html lang=\"ru\">\n")
                .append("<head>\n")
                .append("<meta charset=\"UTF-8\">\n")
                .append("<title>Report for department of programmers</title>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator())
                .append("</body>\n")
                .append("</html>\n");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}