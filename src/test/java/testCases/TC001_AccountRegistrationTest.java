package testCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import elementRepository.AccountRegistrationPage;
import elementRepository.HomePage;
import genericUtility.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups={"Regression","Master"})
   public void verify_account_registration() {
	    
		try {
		logger.info("***Starting TC001_AccountRegistrationTest*****");
		HomePage hp=new HomePage(driver);
		hp.getmyAccount().click();
		logger.info(" clicked on My Account link ");
		hp.getRegister().click();
		logger.info(" clicked on Register link ");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		logger.info(" Providing Customer details ");
		regpage.getTxtFirstname().sendKeys(randomString().toUpperCase());
		regpage.getTxtLastname().sendKeys(randomString().toUpperCase());
		regpage.getTxtEmail().sendKeys(randomString()+"@gmail.com");
		regpage.getTxtTelephone().sendKeys(randomNumeric());
		
		String password=randomAlphaNumeric();
		regpage.getTxtPassword().sendKeys(password);
		regpage.getTxtConfirmpassword().sendKeys(password);
		
		regpage.getChkdPolicy().click();
		regpage.getBtnContinue().click();
		
		logger.info(" Validating expected message ");
		
	    String confMsg=regpage.getConfirmationMsg();    
	    Assert.assertEquals(confMsg, "Your Account Has Been Created!");
	    
		logger.info("*********TC001_AccountRegistrationTest end****************");
		}
		catch(Exception e) {
			logger.error("Test failed..");
			logger.debug("Debug logs..");
			Assert.fail();
		
		}
		    
		}
}