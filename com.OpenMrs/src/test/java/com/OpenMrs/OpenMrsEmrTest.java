package com.OpenMrs;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.OpenMrs.Base.Testbase;
import com.OpenMrs.pages.OpenMrsFindPatientpage;
import com.OpenMrs.pages.OpenMrsHomepage;
import com.OpenMrs.pages.OpenMrsLoginpage;

public class OpenMrsEmrTest extends Testbase {
	OpenMrsLoginpage OML;
	OpenMrsHomepage OMH;
	OpenMrsFindPatientpage OMF;

	public OpenMrsEmrTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		init();
		OML = new OpenMrsLoginpage();
		OMH = new OpenMrsHomepage();
		OMF = new OpenMrsFindPatientpage();

	}

	@Test
	public void OpenMrsTest() {
		OML.verifytheTitle();
		OML.loginPage();
		OMH.OpenMrsHomePageverify();
		OMH.verifytheTitle();
		OMF.FindpatientEMR();
		OMF.validationPatient();
	}

	@AfterMethod
	public void teardown() {
		driver.close();
	}

}