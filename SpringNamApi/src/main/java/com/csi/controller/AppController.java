package com.csi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;

@RestController
@RequestMapping("/api")
public class AppController {
	
	@Autowired
	public EmployeeDaoImpl empdao;
	
	@GetMapping("/getdata")
	public List<Employee> getEmpData(){
		return empdao.getEmployeeList();
		
	}
	@PostMapping("/savedata")
	public String saveEmpData(@RequestBody Employee employee){
		empdao.saveEmployee(employee);
		return "Data Saved";
	}
	@PutMapping("/updatedata/{empid}")
	public String updateEmpData(@PathVariable("empid")int empid, @RequestBody Employee employee){
		return "Data Updated";
	}
	
	@DeleteMapping("/deletedata/{empid}")
	public String deleteEmpData(@PathVariable("empid")int empid){
		return "Data deleted";
	}
	

}
