
package com.edayspractice.userInfo.Utils;

import java.io.Serializable;

public class Info implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer deptId;

	private String deptName;

	private String DeptCode;

	Info() {
	}

	public Info(String deptName, String deptCode) {
		super();
		this.deptName = deptName;
		DeptCode = deptCode;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptCode() {
		return DeptCode;
	}

	public void setDeptCode(String deptCode) {
		DeptCode = deptCode;
	}

	@Override
	public String toString() {
		return "Info [deptId=" + deptId + ", deptName=" + deptName + ", DeptCode=" + DeptCode + "]";
	}

}
