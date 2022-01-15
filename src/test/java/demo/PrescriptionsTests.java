package demo;

import demo.po.HomePO;
import demo.po.InvalidLoginPO;
import demo.po.LoginPO;
import demo.po.ShowPrescriptionsPO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrescriptionsTests extends BaseTest{

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

    @Test
    public void testEditPrescription(){
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
        EditPrescriptionsPo editPage = prescriptionsPage.editFirstRow();

        ShowPrescriptionsPO prescriptionsPage1 = editPage.backToList();
        assertEquals("Prescriptions list", prescriptionsPage1.getMessage());
        assertEquals(3, prescriptionsPage1.getTableSize());
        assertEquals("1", prescriptionsPage1.getFirstRowId());
        EditPrescriptionsPo editPage1 = prescriptionsPage1.editFirstRow();

        editPage1.enterData("1","1","test","test");
        ShowPrescriptionsPO prescriptionsPage2 = editPage1.validSubmit();
        assertEquals("Prescriptions list", prescriptionsPage2.getMessage());
        assertEquals(3, prescriptionsPage2.getTableSize());
        assertEquals("2", prescriptionsPage2.getFirstRowId());
        assertEquals(3, prescriptionsPage2.getTableSize());
        assertEquals("3", prescriptionsPage2.getSecondRowId());

        HomePO homePage1 = prescriptionsPage2.backToHome();
        assertEquals("Hi, Welcome to Mentcare system", homePage1.getMessage());
    }

}
