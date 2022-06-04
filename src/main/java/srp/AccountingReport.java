package srp;

import java.util.function.Predicate;

public class AccountingReport implements Report {
    private Store store;

    public AccountingReport(MemStore store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary in RUB;").append(System.lineSeparator());
        for (Employee employee : store.findBy(filter).stream().map(em -> new Employee(em.getName(), em.getHired(), em.getFired(), em.getSalary() * 60)).toList()) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
