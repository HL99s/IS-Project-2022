package demo.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends PageObject{

    public LoginPO(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "/html[1]/body[1]/h1[1]")
    private WebElement initialMessage;

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "/html[1]/body[1]/form[1]/input[3]")
    private WebElement submit;

    public String getMessage(){
        return this.initialMessage.getText();
    }

    public void enterCredentials(String username, String password){
        this.username.clear();
        this.password.clear();
        this.username.sendKeys(username);
        this.password.sendKeys(password);
    }

    public HomePO validSubmit(){
        submit.click();
        return new HomePO(driver);
    }

    public InvalidLoginPO invalidSubmit(){
        submit.click();
        return new InvalidLoginPO(driver);
    }



}
