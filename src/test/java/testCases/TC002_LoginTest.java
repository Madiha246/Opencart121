package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.MyAccountPage;
import genericUtility.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups={"Sanity", "Master"})
	public void verify_login() {
		
		logger.info("***8starting TC002_LoginTest****");
		
		try {
		HomePage hp=new HomePage(driver);
		hp.getmyAccount().click();
		hp.getlogin().click();
		
		LoginPage lp=new LoginPage(driver);
		lp.getTxtEmailAddress().sendKeys(prop.getProperty("email"));
		lp.getTxtPassword().sendKeys(prop.getProperty("password"));
		lp.getBtnLogin().click();
		
		MyAccountPage macc=new MyAccountPage(driver);
        boolean targetpage=macc.isMyAccountPageExists();		
        Assert.assertTrue(targetpage); //Assert.assertEquals(targetpage, true, "Login passed");
	
		}catch(Exception e) {
		Assert.fail();
	}
		logger.info("***finished TC002_LoginTest****");

}
} 