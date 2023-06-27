package com.dr.pojo;

public class Dept {
	private Long id;
	private String deptId;
	private String deptName;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Dept{" +
				"id=" + id +
				", deptId='" + deptId + '\'' +
				", deptName='" + deptName + '\'' +
				'}';
	}
}
