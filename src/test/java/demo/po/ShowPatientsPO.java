package demo.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShowPatientsPO extends PageObject{

    public ShowPatientsPO(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "/html[1]/body[1]/h1[1]")
    private WebElement titleMessage;

    @FindBy(xpath = "/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[6]/a[1]")
    private WebElement showPatientInfoLink;

    @FindBy(xpath = "/html[1]/body[1]/form[1]/input[1]")
    private WebElement backToHomeButton;

    @FindBy(xpath = "/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[1]")
    private WebElement firstRowId;

    @FindBy(tagName = "table")
    private WebElement table;

    public String getMessage(){
        return titleMessage.getText();
    }

    public ShowPatientsInfoPO showPatientsInfo(){
        showPatientInfoLink.click();
        return new ShowPatientsInfoPO(driver);
    }

    public HomePO backToHome(){
        backToHomeButton.click();
        return new HomePO(driver);
    }

    public String getFirstRowId(){
        return firstRowId.getText();
    }

    public int getTableSize(){
        return table.findElements(By.tagName("tr")).size();
    }


}