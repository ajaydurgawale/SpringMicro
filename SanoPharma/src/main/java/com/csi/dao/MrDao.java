package com.csi.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.csi.model.MR;

public interface MrDao {
	public List<MR> getMrData();

   	public void saveMrData(MR mr);

   	public void updateMrData(int mrId, MR mr);

   	public void deleteMrData(int mrId);
   	
   	public List<MR> getMrDatabyID(int mrId);
}
	 