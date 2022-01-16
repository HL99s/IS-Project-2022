package demo;

import demo.po.*;
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

        createPage1.enterData("T28", "COMMENTO AHAH");

        ShowPrescriptionsPO prescriptionsPage = createPage1.validSubmit();

        assertEquals("Prescriptions list", prescriptionsPage.getMessage());
        assertEquals(4,  prescriptionsPage.getTableSize());
        assertEquals("3", prescriptionsPage.getNewRowId());

        HomePO homePage1 = prescriptionsPage.backToHome();

        assertEquals("Hi, Welcome to Mentcare system", homePage1.getMessage());
    }

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

        createPage.enterData("T28", "COMMENTO AHAH");

        ShowPrescriptionsPO prescriptionsPage = createPage.validSubmit();

        assertEquals("Prescriptions list", prescriptionsPage.getMessage());
        assertEquals(4,  prescriptionsPage.getTableSize());
        assertEquals("3", prescriptionsPage.getNewRowId());

        HomePO homePage1 = prescriptionsPage.backToHome();

        assertEquals("Hi, Welcome to Mentcare system", homePage1.getMessage());


    }

}
