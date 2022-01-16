package demo;

import demo.po.HomePO;
import demo.po.InvalidLoginPO;
import demo.po.LoginPO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestInvalidLogin extends BaseTest{

    @Test
    public void testInvalidLogin(){
        driver.get("http://localhost:8080/");
        LoginPO loginPage = new LoginPO(driver);
        assertEquals("Hi, Please Log-In to Mentcare system", loginPage.getMessage());

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
}
