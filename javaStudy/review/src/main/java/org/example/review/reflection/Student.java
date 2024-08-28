package org.example.review.reflection;

public class Student {
    public int grade;
    private int id;
    private String name;

    public Student() {
        System.out.println("单参构造");
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Student(int id) {
        System.out.println("id单参构造");
        this.id = id;
    }
    private Student(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
