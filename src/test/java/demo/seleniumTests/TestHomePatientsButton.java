package demo.seleniumTests;

import demo.seleniumTests.BaseTest;
import demo.seleniumTests.po.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestHomePatientsButton extends BaseTest {

    @Test
    public void testPatientsButton() {
        driver.get("http://localhost:8080/");
        LoginPO loginPage = new LoginPO(driver);
        assertEquals("Hi, Please Log-In to Mentcare system", loginPage.getMessage());

        loginPage.enterCredentials("admin", "admin");
        HomePO homePage = loginPage.validSubmit();

        assertEquals("Hi, Welcome to Mentcare system", homePage.getMessage());

        ShowPatientsPO patientsPage = homePage.showPatientsSubmit();

        assertEquals("Patients list", patientsPage.getMessage());


    }
}
