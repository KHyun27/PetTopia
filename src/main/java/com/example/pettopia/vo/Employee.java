package com.example.pettopia.vo;

import lombok.Data;

@Data
public class Employee {
	private String empNo; // PK
	private String empName;
	private String empPw;
	private String empEmail;
	private String empBirth;
	private String empGender;
	private String empPhone;
	private Integer postalCode;
	private String basicAddress;
	private String detailAddress;
	private String empStatus;
	private String isTeamLeader;
	private String isFirstLogin;
	private String deptCode; // FK
	private Integer rankNo; // FK
	private String hiredate;
	private String resignationDate;
	private String createDatetime;
	private String updateDatetime;
}