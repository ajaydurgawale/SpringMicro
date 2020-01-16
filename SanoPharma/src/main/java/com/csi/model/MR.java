package com.csi.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MR {

	private int mrId;
	private String mrName;
	private int mrMobileNumber;
	private String mrHighestEdu;
	private List<Drug> drug;

	@OneToMany(targetEntity = Drug.class, mappedBy = "mr",fetch=FetchType.EAGER)
	public List<Drug> getDrug() {
		return drug;
	}

	public void setDrug(List<Drug> drug) {
		this.drug = drug;
	}

	@Id
	@GeneratedValue
	public int getMrId() {
		return mrId;
	}

	public void setMrId(int mrId) {
		this.mrId = mrId;
	}

	public String getMrName() {
		return mrName;
	}

	public void setMrName(String mrName) {
		this.mrName = mrName;
	}

	public int getMrMobileNumber() {
		return mrMobileNumber;
	}

	public String getMrHighestEdu() {
		return mrHighestEdu;
	}

	public void setMrHighestEdu(String mrHighestEdu) {
		this.mrHighestEdu = mrHighestEdu;
	}

	public void setMrMobileNumber(int mrMobileNumber) {
		this.mrMobileNumber = mrMobileNumber;
	}

}
