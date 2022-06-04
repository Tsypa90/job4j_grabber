package srp;

public class Person {
    private static Person person;

    private Person() {
    };

    public static Person getPerson() {
        if (person == null) {
            person = new Person();
        }
        return person;
    }
}
