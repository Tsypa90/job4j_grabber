package ocp;

import com.google.gson.GsonBuilder;
import srp.*;

import javax.xml.bind.JAXBException;
import java.util.Calendar;
import java.util.function.Predicate;

public class JsonReport implements Report {
    private Store store;

    public JsonReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        var lib = new GsonBuilder().create();
        return lib.toJson(store.findBy(filter));
    }

    public static void main(String[] args) throws JAXBException {
        MemStore memStore = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        memStore.add(worker);
        Report report = new JsonReport(memStore);
        System.out.println(report.generate(employee -> true));
    }
}
