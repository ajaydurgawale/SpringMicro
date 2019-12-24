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
import org.springframework.web.bind.annotation.RestController;

import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;

@RestController
@RequestMapping("/api")
public class ApplicationController {

	@Autowired
	EmployeeDaoImpl empdao;

	@GetMapping("/getdata")
	public List<Employee> getEmpData() {
		return empdao.employeelist();
	}

	@PutMapping("/updatedata/{empid}")
	public String updateEmpData(@PathVariable("empid") int empid, @RequestBody Employee employee) {
		empdao.updateData(empid, employee);
		return "Data Updated";

	}

	@PostMapping("/savedata")
	public String saveData(@RequestBody Employee employee) {
		empdao.saveData(employee);
		return "Data Saved";
	}
	
	@DeleteMapping("/deletedata/{empid}")
	public String deleteData(@PathVariable("empid") int empid){
		empdao.deleteData(empid);
		return "Data deleted";
	}
}
