package demo.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddPersonPO extends PageObject{

    public AddPersonPO(WebDriver driver){
        super(driver);
    }

    @FindBy(name = "firstname")
    private WebElement firstName;

    @FindBy(name = "lastname")
    private WebElement lastName;

    @FindBy(tagName = "h1")
    private WebElement message;

    public String getMessage(){
        return message.getText();
    }

    public EmptyListPO enterName(String firstName, String lastName){
        this.firstName.clear();
        this.firstName.sendKeys(firstName);
        this.lastName.clear();
        this.lastName.sendKeys(lastName);
        this.lastName.submit();
        return new EmptyListPO(driver);
    }
}
