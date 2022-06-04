package srp;

import java.util.Calendar;
import java.util.function.Predicate;

public class HrReport implements Report {
    private Store store;

    public HrReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;").append(System.lineSeparator());
        for (Employee employee : store.findBy(filter).stream().sorted((employee, t1) -> Double.compare(t1.getSalary(), employee.getSalary())).toList()) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
