package srp;

public class Person {
    private static Person person;
    int age;
    String name;
    String work;
    double salary;
    String hobby;
    int sonAge;
    boolean married;

    private Person() {
    };

    public Person(int age, String name, String work, double salary) {
        this.age = age;
        this.name = name;
        this.work = work;
        this.salary = salary;
    }

    public Person(int age, String name, String hobby, int sonAge, boolean married) {
        this.age = age;
        this.name = name;
        this.hobby = hobby;
        this.sonAge = sonAge;
        this.married = married;
    }

    public static Person getPerson() {
        if (person == null) {
            person = new Person();
        }
        return person;
    }

    private int whenMarriedAndGetSon(int age, int sonAge) {
        return age - sonAge;
    }
}
