package demo.seleniumTests;

import demo.seleniumTests.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestShowInfoPatients extends BaseTest {

    @Test
    public void testShowInfoPatients(){
        driver.get("http://localhost:8080/");
        LoginPO loginPage = new LoginPO(driver);
        assertEquals("Hi, Please Log-In to Mentcare system", loginPage.getMessage());

        loginPage.enterCredentials("admin", "admin");
        HomePO homePage = loginPage.validSubmit();

        assertEquals("Hi, Welcome to Mentcare system", homePage.getMessage());

        ShowPatientsPO patientsPage = homePage.showPatientsSubmit();

        assertEquals("Patients list", patientsPage.getMessage());
        assertEquals(11 , patientsPage.getTableSize());
        assertEquals("1", patientsPage.getFirstRowId());

        ShowPatientsInfoPO showInfoPage = patientsPage.showPatientsInfo();

        assertEquals("Details of patient:", showInfoPage.getMessage());
        assertEquals(3, showInfoPage.getTableSize());
        assertEquals("1", showInfoPage.getFirstRowId());

        ShowPatientsPO patientsPage1 = showInfoPage.backToListButton();

        assertEquals("Patients list", patientsPage1.getMessage());

        HomePO homePage1 = patientsPage1.backToHome();

        assertEquals("Hi, Welcome to Mentcare system", homePage1.getMessage());
    }

}
