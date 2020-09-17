package cn.gorit.entity;

public class Student_Clazz {
    private Integer id; // 学生 id
    private String sname;// 学生姓名
    private String gender; // 学生性别
    private Integer age; // 学生年龄
    private Integer cno; // 编号
    private String cname; // 班级

    public Student_Clazz(Integer id, String sname, String gender, Integer age, Integer cno, String cname) {
        this.id = id;
        this.sname = sname;
        this.gender = gender;
        this.age = age;
        this.cno = cno;
        this.cname = cname;
    }

    public Student_Clazz() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return sname;
    }

    public void setName(String sname) {
        this.sname = sname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getCno() {
        return cno;
    }

    public void setCno(Integer cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Student_Clazz{" +
                "id=" + id +
                ", sname='" + sname + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", cno=" + cno +
                ", cname='" + cname + '\'' +
                '}';
    }
}
