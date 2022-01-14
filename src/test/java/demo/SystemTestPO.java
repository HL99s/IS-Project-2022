package demo;

import demo.po.*;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.*;

public class SystemTestPO extends BaseTest{

    @Test
    public void testValidLogin(){
        driver.get("http://localhost:8080/");
        LoginPO loginPage = new LoginPO(driver);

        loginPage.enterCredentials("admin", "admin");
        HomePO homePage = loginPage.validSubmit();

        assertEquals("Hi, Welcome to Mentcare system", homePage.getMessage());
    }

    @Test
    public void testInvalidLogin(){
        driver.get("http://localhost:8080/");
        LoginPO loginPage = new LoginPO(driver);

        loginPage.enterCredentials("admin", "pen");
        InvalidLoginPO reLogPage = loginPage.invalidSubmit();

        assertEquals("Username or Password incorrect, Please try again", reLogPage.getMessage());

        reLogPage.enterCredentials("apple", "a");
        InvalidLoginPO reLogPage1 = reLogPage.invalidSubmit();

        assertEquals("Username or Password incorrect, Please try again", reLogPage1.getMessage());

        reLogPage1.enterCredentials("admin", "admin");
        HomePO homePage = reLogPage1.validSubmit();

        assertEquals("Hi, Welcome to Mentcare system", homePage.getMessage());
    }

    @Test
    public void testAddPerson(){
        driver.get("http://localhost:8080/");
        EmptyListPO entryPage = new EmptyListPO(driver);
        assertEquals("People list", entryPage.getMessage());

        AddPersonPO addPage = entryPage.addPerson();
        assertEquals("Create a new record", addPage.getMessage());

        EmptyListPO listPage = addPage.enterName("mariano", "ceccato");
        assertEquals("People list", listPage.getMessage());
        assertEquals(2, listPage.getTableSize());
        assertEquals("mariano", listPage.getFirstRowName());

    }
}
