package demo.seleniumTests;

import demo.seleniumTests.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCreatePrescriptionsByTreatmentsList extends BaseTest {

    @Test
    public void testCreatePrescriptionsByTreatmentsList(){
        driver.get("http://localhost:8080/");
        LoginPO loginPage = new LoginPO(driver);
        assertEquals("Hi, Please Log-In to Mentcare system", loginPage.getMessage());

        loginPage.enterCredentials("admin", "admin");
        HomePO homePage = loginPage.validSubmit();

        assertEquals("Hi, Welcome to Mentcare system", homePage.getMessage());

        ShowTreatmentsPO treatmentsPage = homePage.showTreatmentsSubmit();

        assertEquals("Treatments list", treatmentsPage.getMessage());

        CreatePrescriptionsPo createPage = treatmentsPage.createPrescription();

        assertEquals("Create a new Prescription", createPage.getMessage());

        ShowTreatmentsPO treatmentsPage1 = createPage.backToList();

        assertEquals("Treatments list", treatmentsPage1.getMessage());

        CreatePrescriptionsPo createPage1 = treatmentsPage.createPrescription();

        createPage1.enterData("T28", "Commento prova");

        ShowPrescriptionsPO prescriptionsPage = createPage1.validSubmit();

        assertEquals("Prescriptions list", prescriptionsPage.getMessage());
        assertEquals(4,  prescriptionsPage.getTableSize());
        assertEquals("3", prescriptionsPage.getNewRowId());

        HomePO homePage1 = prescriptionsPage.backToHome();

        assertEquals("Hi, Welcome to Mentcare system", homePage1.getMessage());
    }

}
