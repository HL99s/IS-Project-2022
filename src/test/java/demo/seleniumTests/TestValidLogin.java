package demo.seleniumTests;

import demo.seleniumTests.po.HomePO;
import demo.seleniumTests.po.InvalidLoginPO;
import demo.seleniumTests.po.LoginPO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestValidLogin extends BaseTest {

    @Test
    public void testValidLogin(){
        driver.get("http://localhost:8080/");
        LoginPO loginPage = new LoginPO(driver);
        assertEquals("Hi, Please Log-In to Mentcare system", loginPage.getMessage());

        loginPage.enterCredentials("admin", "admin");
        HomePO homePage = loginPage.validSubmit();

        assertEquals("Hi, Welcome to Mentcare system", homePage.getMessage());
    }

}
