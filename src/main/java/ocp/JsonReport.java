package ocp;

import com.google.gson.GsonBuilder;
import srp.*;
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
}
