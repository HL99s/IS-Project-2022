package demo;

import demo.po.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HomeTests extends BaseTest{

    @Test
    public void testPatientsButton(){
        driver.get("http://localhost:8080/");
        LoginPO loginPage = new LoginPO(driver);
        assertEquals("Hi, Please Log-In to Mentcare system", loginPage.getMessage());

        loginPage.enterCredentials("admin", "admin");
        HomePO homePage = loginPage.validSubmit();

        assertEquals("Hi, Welcome to Mentcare system", homePage.getMessage());

        ShowPatientsPO patientsPage = homePage.showPatientsSubmit();

        assertEquals("Patients list", patientsPage.getMessage());


    }

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
