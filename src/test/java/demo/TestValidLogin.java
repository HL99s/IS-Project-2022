package demo;

import demo.po.HomePO;
import demo.po.InvalidLoginPO;
import demo.po.LoginPO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestValidLogin extends BaseTest{

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
