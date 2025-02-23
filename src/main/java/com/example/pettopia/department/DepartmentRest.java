package com.example.pettopia.department;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pettopia.util.TeamColor;
import com.example.pettopia.vo.Department;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DepartmentRest {
	
	@Autowired DepartmentService departmentService; 
	
	// 팀 목록 조회 : 직원 등록시 소속 팀 선택 시 사용
	@GetMapping("/rest/departmentList/{divisionCode}")
	public List<Department> getDepartmentList(@PathVariable String divisionCode) {
		
		log.debug(TeamColor.KMJ + "DepartmentRest - getDepartmentList()");
		log.debug(TeamColor.KMJ + "departmentList : " + departmentService.getDepartmentList(divisionCode).toString() +TeamColor.RESET);
		
		return departmentService.getDepartmentList(divisionCode);
	}
	
	
	// 조직도 
	@GetMapping("/rest/orgChart/{deptCode}")
	public List<Map<String, Object>> getOrgChart(@PathVariable String deptCode) {
		
		log.debug(TeamColor.KMJ + "DepartmentRest - getOrgChart()");
		log.debug(TeamColor.KMJ+"divisionCode : " + deptCode);
		
		List<Map<String, Object>> orgChart = departmentService.getOrgChart(deptCode);
		
		log.debug(TeamColor.KMJ+"최종 orgChart : " + orgChart + TeamColor.RESET);
		
		return orgChart;
	}
	
	
	// 팀명 중복 검사
	@GetMapping("/rest/confirmDepartment")
	public String confirmDepartment(@RequestParam String deptName) {
		
		log.debug(TeamColor.OJY + "DepartmentRest - confirmDepartment()");
		
		log.debug(TeamColor.KMJ+"deptName : " + deptName);
		
		Integer deptCount = departmentService.confirmDepartment(deptName);

		log.debug(TeamColor.KMJ+"deptCount : " + deptCount);
		
		if(deptCount == 0 ) {
			log.debug(TeamColor.KMJ+"사용가능");
			return "Y";
		}
		return "N"; // 팀명 중복

		
	}
	
	
	
	

}
