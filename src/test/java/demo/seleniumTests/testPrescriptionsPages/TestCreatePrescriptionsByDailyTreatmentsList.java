package demo.seleniumTests.testPrescriptionsPages;

import demo.seleniumTests.po.*;
import demo.seleniumTests.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCreatePrescriptionsByDailyTreatmentsList extends BaseTest {

    @Test
    public void testCreatePrescriptionsByDailyTreatmentsList(){
        driver.get("http://localhost:8080/");
        LoginPO loginPage = new LoginPO(driver);
        assertEquals("Hi, Please Log-In to Mentcare system", loginPage.getMessage());

        loginPage.enterCredentials("admin", "admin");
        HomePO homePage = loginPage.validSubmit();

        assertEquals("Hi, Welcome to Mentcare system", homePage.getMessage());

        ShowTreatmentsPO treatmentsPage = homePage.showTreatmentsSubmit();

        assertEquals("Treatments list", treatmentsPage.getMessage());

        ShowDailyTreatmentsPO dailyTreatmentsPage = treatmentsPage.goToDailyTreatmentsList();

        assertEquals("Today's treatments list", dailyTreatmentsPage.getMessage());

        CreatePrescriptionsPo createPage = dailyTreatmentsPage.createPrescription();

        assertEquals("Create a new Prescription", createPage.getMessage());

        createPage.enterData("T28", "Prova 1");

        ShowPrescriptionsPO prescriptionsPage = createPage.validSubmit();

        assertEquals("Prescriptions list", prescriptionsPage.getMessage());
        assertEquals(4,  prescriptionsPage.getTableSize());
        assertEquals("3", prescriptionsPage.getNewRowId());

        HomePO homePage1 = prescriptionsPage.backToHome();

        assertEquals("Hi, Welcome to Mentcare system", homePage1.getMessage());


    }

}
