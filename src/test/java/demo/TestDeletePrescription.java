package demo;

import demo.po.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDeletePrescription extends BaseTest{

    @Test
    public void testDeletePrescription(){
        driver.get("http://localhost:8080/");
        LoginPO loginPage = new LoginPO(driver);
        assertEquals("Hi, Please Log-In to Mentcare system", loginPage.getMessage());

        loginPage.enterCredentials("admin", "admin");
        HomePO homePage = loginPage.validSubmit();

        assertEquals("Hi, Welcome to Mentcare system", homePage.getMessage());

        ShowPrescriptionsPO prescriptionsPage = homePage.showPrescriptionsSubmit();

        assertEquals("Prescriptions list", prescriptionsPage.getMessage());
        assertEquals(3, prescriptionsPage.getTableSize());
        assertEquals("1", prescriptionsPage.getFirstRowId());
        prescriptionsPage.deleteFirstRow();
        assertEquals(2, prescriptionsPage.getTableSize());
        assertEquals("2", prescriptionsPage.getFirstRowId());

        HomePO homePage1 = prescriptionsPage.backToHome();
        assertEquals("Hi, Welcome to Mentcare system", homePage1.getMessage());
    }



}
