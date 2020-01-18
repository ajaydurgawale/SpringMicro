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

import com.csi.dao.MrDao;
import com.csi.model.MR;

@RestController
@RequestMapping("/api")
public class Mrcontroller {

	@Autowired
	MrDao mrdao;

	@GetMapping("/getdata")
	public List<MR> getData() {
		return mrdao.getMrData();
	}

	@PostMapping("/savedata")
	public String saveData(@RequestBody MR mr) {
		mrdao.saveMrData(mr);
		return "save data successfully";
	}

	@PutMapping("/updatedata/{mrId}")
	public String updateData(@PathVariable("mrId") int mrId, @RequestBody MR mr) {
		mrdao.updateMrData(mrId, mr);
		return "update data successfully";
	}

	@DeleteMapping("/deletedata/{mrId}")
	public String deleteData(@PathVariable("mrId") int mrId) {
		mrdao.deleteMrData(mrId);
		return "delete data successfully";
	}
	
	@GetMapping("/getdatabyid/{mrId}")
	public List<MR> getDatabyId(@PathVariable("mrId") int mrId) {
		return mrdao.getMrDatabyID(mrId);
	}
}
