package srp;

import java.util.Map;

public class Student {
    private static Map<String, Student> students;
    public int age;
    public String name;
    public int course;
    public String hobby;

    public Student(int age, String name, int course, String hobby) {
        this.age = age;
        this.name = name;
        this.course = course;
        this.hobby = hobby;
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

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public int howAgeWasWhenStartStudy(int age, int course) {
        return age - course;
    }

    public void courseStudentsAdd(Student student) {
        students.put(student.getName(), student);
    }
}