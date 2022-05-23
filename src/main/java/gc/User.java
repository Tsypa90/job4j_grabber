package gc;

public class User {
    private int age;
    private String name;
    private boolean married;

    public User(int age, String name, boolean married) {
        this.age = age;
        this.name = name;
        this.married = married;
    }

    @Override
    protected void finalize() {
        System.out.printf("Removed %d %s%n", age, name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
