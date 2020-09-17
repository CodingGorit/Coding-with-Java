package cn.gorit.entity;

public class Student {
    private Integer id;
    private String name;
    private String gender;
    private int age;
    private Clazz clazz;

//    public Student(Integer id, String name, String gender, int age, Clazz clazz) {
//        this.id = id;
//        this.name = name;
//        this.gender = gender;
//        this.age = age;
//        this.clazz = clazz;
//    }

//    public Student(Integer id, String name, String gender, int age) {
//        this.id = id;
//        this.name = name;
//        this.gender = gender;
//        this.age = age;
//    }


//    public Student(String name, String gender, int age, Clazz clazz) {
//        this.name = name;
//        this.gender = gender;
//        this.age = age;
//        this.clazz = clazz;
//    }

//    public Student(String name, String gender, int age) {
//        this.name = name;
//        this.gender = gender;
//        this.age = age;
//    }

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSname() {
        return name;
    }

    public void setSname(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", clazz=" + clazz +
                '}';
    }
}
