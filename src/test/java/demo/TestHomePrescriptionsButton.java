package demo;

import demo.po.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestHomePrescriptionsButton extends BaseTest{

    @Test
    public void testPrescriptionsButton(){
        driver.get("http://localhost:8080/");
        LoginPO loginPage = new LoginPO(driver);
        assertEquals("Hi, Please Log-In to Mentcare system", loginPage.getMessage());

        loginPage.enterCredentials("admin", "admin");
        HomePO homePage = loginPage.validSubmit();

        assertEquals("Hi, Welcome to Mentcare system", homePage.getMessage());

        ShowPrescriptionsPO prescriptionsPage = homePage.showPrescriptionsSubmit();

        assertEquals("Prescriptions list", prescriptionsPage.getMessage());
    }
}
