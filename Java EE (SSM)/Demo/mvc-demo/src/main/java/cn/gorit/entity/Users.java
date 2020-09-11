package cn.gorit.entity;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Users {
	@NotNull
	private String account;
	@Length(max = 6,min = 4)
	private String passwrod;
	private String gender;
	private int age;
	@Pattern(regexp = "^\\d{11}$",message = "手机号长度不对")
	private String phoneNum;
	private String idCard;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPasswrod() {
		return passwrod;
	}
	public void setPasswrod(String passwrod) {
		this.passwrod = passwrod;
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
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public Users(String account, String passwrod, String gender, int age, String phoneNum, String idCard) {
		super();
		this.account = account;
		this.passwrod = passwrod;
		this.gender = gender;
		this.age = age;
		this.phoneNum = phoneNum;
		this.idCard = idCard;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
}
