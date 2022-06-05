package srp;

import java.util.Calendar;
import java.util.function.Predicate;

public class ProgramReport implements Report {
    private Store store;

    public ProgramReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<html lang=\"ru\">\n")
                .append("<head>\n")
                .append("<meta charset=\"UTF-8\">\n")
                .append("<title>Report for department of programmers</title>\n")
                .append("</head>\n")
                .append("<body>\n");
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        text.append("</body>\n")
                .append("</html>\n");
        return text.toString();
    }
}
