package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.MyAccountPage;
import genericUtility.BaseClass;
import genericUtility.DataProviders;

/*Data is valid - login success --test pass ---logout
                - login unsuccess --test fail
  
  Data is invalid - login unsuccess --test pass 
                  - login success --test fail ---logout 
 * 
 */
public class TC003_LoginDDT extends BaseClass {
    
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="Datadriven")//gttng data provider from different class
	public void verify_loginDDT(String email, String password, String exp) {
		
		logger.info("*************starting TC003_LoginDDT**********");
		
		try {
		//Home Page
		HomePage hp=new HomePage(driver);
		hp.getmyAccount().click();
		hp.getlogin().click();
		
		//Login Page
		LoginPage lp=new LoginPage(driver);
		lp.getTxtEmailAddress().sendKeys(email);
		lp.getTxtPassword().sendKeys(password);
		lp.getBtnLogin().click();
		
		//MyAccount Page
		MyAccountPage macc=new MyAccountPage(driver);
        boolean targetpage=macc.isMyAccountPageExists();		
		
        if(exp.equalsIgnoreCase("valid")) {
        	if(targetpage==true) {
        		macc.getlnkLogout().click();
        		Assert.assertTrue(true);
        	}else {
        		Assert.assertTrue(false);
        	}
        }
        
        if(exp.equalsIgnoreCase("invalid")) {
        	if(targetpage==true) {
        		macc.getlnkLogout().click();;
        		Assert.assertTrue(false);
        	}else {
        		Assert.assertTrue(true);
        	}
      
         }
		}catch(Exception e) {
			Assert.fail();
		}
        logger.info("*************finished TC003_LoginDDT**********");
    }
	
}
