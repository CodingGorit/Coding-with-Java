package cn.gorit.entity;

public class Student {

    private String name;
    private Integer age;


    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
        System.out.println("有参构造执行了");
    }

    public Student() {
        System.out.println("无参构造方法执行了");
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
