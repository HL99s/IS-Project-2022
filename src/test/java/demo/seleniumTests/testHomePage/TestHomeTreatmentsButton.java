package demo.seleniumTests.testHomePage;

import demo.seleniumTests.po.*;
import demo.seleniumTests.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestHomeTreatmentsButton extends BaseTest {

    @Test
    public void testTreatmentsButton(){
        driver.get("http://localhost:8080/");
        LoginPO loginPage = new LoginPO(driver);
        assertEquals("Hi, Please Log-In to Mentcare system", loginPage.getMessage());

        loginPage.enterCredentials("admin", "admin");
        HomePO homePage = loginPage.validSubmit();

        assertEquals("Hi, Welcome to Mentcare system", homePage.getMessage());

        ShowTreatmentsPO treatmentsPage = homePage.showTreatmentsSubmit();

        assertEquals("Treatments list", treatmentsPage.getMessage());
    }

}
