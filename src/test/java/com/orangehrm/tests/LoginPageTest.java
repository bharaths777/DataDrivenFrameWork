package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.base.TestBase;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.util.Log;
import com.orangehrm.util.TestUtil;

public class LoginPageTest extends TestBase{

	public LoginPage loginPage;
	
	public LoginPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		intialize();
		loginPage = new LoginPage();
		Log.info("Orange Hrm application launched....");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test(priority=1)
	public void validateTitle() {
		String title = loginPage.verifyTitle();
		Assert.assertEquals("OrangeHRM", title);
		Log.info("Login Page Title Verified...");
	}
	@Test(priority=2)
	public void validateLogo() {
		boolean flag = loginPage.verifyLogo();
		Assert.assertTrue(flag);
		Log.info("Login Page logo Verified...");
	}
	@Test(dataProvider="getLoginData",priority=3)
	public void validateLogin(String username,String password) {
		loginPage.verifyLogin(username, password);
		Log.info("Login success...");
	}
	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data = TestUtil.getData("testdata");
		return data;
	}
	
}
