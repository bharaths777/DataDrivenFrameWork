package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.base.TestBase;

public class LoginPage extends TestBase{

	
	@FindBy(id="txtUsername") WebElement uname;
	@FindBy(id="txtPassword") WebElement pwd;
	@FindBy(name="Submit") WebElement loginbtn;
	
	@FindBy(xpath="//img[@src='/webres_5e7b15c4882d04.47780062/themes/default/images/login/logo.png']") WebElement logo;
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitle() {
	
		return driver.getTitle();
	}
	public boolean verifyLogo() {
		boolean flag = logo.isDisplayed();
		return flag;
	}
	
	public void verifyLogin(String unames,String pwds) {
		uname.sendKeys(unames);
		pwd.sendKeys(pwds);
		loginbtn.click();
		
	}
	
	
}
