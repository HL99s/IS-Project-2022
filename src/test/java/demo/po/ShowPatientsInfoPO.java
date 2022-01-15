package demo.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShowPatientsInfoPO extends PageObject{

    public ShowPatientsInfoPO(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "/html[1]/body[1]/h1[1]")
    private WebElement initialMessage;

    @FindBy(xpath = "/html[1]/body[1]/form[1]/input[1]")
    private WebElement backToListButton;

    @FindBy(tagName = "table")
    private WebElement table;

    @FindBy(xpath ="/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[1]" )
    private WebElement firstRowId;

    public String getMessage(){
        return initialMessage.getText();
    }

    public ShowPatientsPO backToListButton(){
        backToListButton.click();
        return new ShowPatientsPO(driver);
    }

    public Integer getTableSize(){
        return table.findElements(By.tagName("tr")).size();
    }

    public String getFirstRowId(){
        return firstRowId.getText();
    }
}
