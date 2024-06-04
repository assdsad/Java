package org.example.reflection;

public class Student {
    private Integer id;
    private String name;
    public Student(){
        System.out.println("无参构造");
    }

    public Student(Integer id ){
        this.id = id;
        System.out.println("单参构造");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setId(Integer id, String name) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
