package demo;

import demo.po.AddPersonPO;
import demo.po.EmptyListPO;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.*;

public class SystemTestPO extends BaseTest{

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
