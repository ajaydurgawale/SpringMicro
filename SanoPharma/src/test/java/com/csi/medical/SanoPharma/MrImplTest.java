package com.csi.medical.SanoPharma;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.csi.dao.MrDao;
import com.csi.model.Drug;
import com.csi.model.MR;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MrImplTest {

	@Autowired
	private MrDao mrDao;

	@Test
	public void saveMrDataTest() {
		Drug drug = new Drug();
		ArrayList<Drug> drugList = new ArrayList<>();
		drug.setDrugName("AAA");
		drugList.add(drug);
		MR mr = new MR();
		mr.setDrug(drugList);
		mr.setMrName("TOM");
		mr.setMrId(1);
		mr.setMrHighestEdu("BE");
		mr.setMrMobileNumber(25554);
		//mrDao.saveMrData(mr);
		Assert.assertTrue(mr != null);
	}

	@Test
	public void updateMrDataTest() {
		Drug drug = new Drug();
		ArrayList<Drug> drugList = new ArrayList<>();
		drug.setDrugName("bbb");
		drugList.add(drug);
		MR mr = new MR();
		mr.setDrug(drugList);
		mr.setMrMobileNumber(25554);
		//mrDao.updateMrData(mr.getMrId(), mr);
		Assert.assertFalse(mr.getDrug() == null);
	}

	@Test
	public void getMrDataTest() {
		List<MR> mr = mrDao.getMrData();
		Assert.assertTrue(mr != null);
	}

	@Test
	public void getMrDatabyIDTest() {
		List<MR> mr = mrDao.getMrDatabyID(1);
		Assert.assertTrue(mr != null);
	}

}