package com.csi.dao;


import java.util.List;

import com.csi.model.Drug;

public interface DrugDao {
public List<Drug> getDrugData();

	   	public void saveDrugData(Drug drug);

	   	public void updateDrugData(int drugId, Drug drug);

	   	public void deleteDrug(int drugId);

	   }



