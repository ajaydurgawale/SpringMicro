package com.csi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Drug {
	
	
	private int drugId;
	private String drugName;
	private MR mr;
	
	@ManyToOne
	public MR getMr() {
		return mr;
	}

	public void setMr(MR mr) {
		this.mr = mr;
	}
	@Id
	@GeneratedValue
	public int getDrugId() {
		return drugId;
	}

	public void setDrugId(int drugId) {
		this.drugId = drugId;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

}
