package cn.gorit.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * JsonIgnore  不返回数据
 *     @JsonProperty("sex")  别名返回
 *         @JsonInclude(value = JsonInclude.Include.NON_NULL) 空值筛选出去
 */
public class Student {
    private String username;

    @JsonIgnore
    private String password;
    @JsonProperty("sex")
    private String gender;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private int age;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date makeTime;

    public Student(String username, String password, String gender, int age) {
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.age = age;
    }

    public Student(String username, String gender, int age) {
        this.username = username;
        this.gender = gender;
        this.age = age;
    }

    public Student() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}
