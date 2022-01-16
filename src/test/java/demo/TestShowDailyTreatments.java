package demo;

import demo.po.HomePO;
import demo.po.LoginPO;
import demo.po.ShowDailyTreatmentsPO;
import demo.po.ShowTreatmentsPO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestShowDailyTreatments extends BaseTest{

    @Test
    public void testShowTreatments(){
        driver.get("http://localhost:8080/");
        LoginPO loginPage = new LoginPO(driver);
        assertEquals("Hi, Please Log-In to Mentcare system", loginPage.getMessage());

        loginPage.enterCredentials("admin", "admin");
        HomePO homePage = loginPage.validSubmit();

        assertEquals("Hi, Welcome to Mentcare system", homePage.getMessage());

        ShowTreatmentsPO treatmentsPage = homePage.showTreatmentsSubmit();

        assertEquals("Treatments list", treatmentsPage.getMessage());
        assertEquals(13, treatmentsPage.getTableSize());
        assertEquals("1", treatmentsPage.getFirstRowId());

        HomePO homePage1 = treatmentsPage.backToHome();

        assertEquals("Hi, Welcome to Mentcare system", homePage1.getMessage());
    }

    @Test
    public void testShowDailyTreatments(){
        driver.get("http://localhost:8080/");
        LoginPO loginPage = new LoginPO(driver);
        assertEquals("Hi, Please Log-In to Mentcare system", loginPage.getMessage());

        loginPage.enterCredentials("admin", "admin");
        HomePO homePage = loginPage.validSubmit();

        assertEquals("Hi, Welcome to Mentcare system", homePage.getMessage());

        ShowTreatmentsPO treatmentsPage = homePage.showTreatmentsSubmit();

        assertEquals("Treatments list", treatmentsPage.getMessage());
        assertEquals(13, treatmentsPage.getTableSize());
        assertEquals("1", treatmentsPage.getFirstRowId());

        ShowDailyTreatmentsPO dailyTreatmentsPage = treatmentsPage.goToDailyTreatmentsList();

        assertEquals("Today's treatments list", dailyTreatmentsPage.getMessage());
        assertEquals(11, dailyTreatmentsPage.getTableSize());
        assertEquals("3", dailyTreatmentsPage.getFirstRowId());

        ShowTreatmentsPO treatmentsPage1 = dailyTreatmentsPage.goToAllTreatmentsList();

        assertEquals("Treatments list", treatmentsPage1.getMessage());

        ShowDailyTreatmentsPO dailyTreatmentsPage1 = treatmentsPage1.goToDailyTreatmentsList();

        assertEquals("Today's treatments list", dailyTreatmentsPage1.getMessage());

        HomePO homePage1 = dailyTreatmentsPage1.backToHome();

        assertEquals("Hi, Welcome to Mentcare system", homePage1.getMessage());
    }
}
