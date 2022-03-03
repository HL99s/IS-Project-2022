package demo.seleniumTests.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShowPrescriptionsPO extends PageObject{

    public ShowPrescriptionsPO(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "/html[1]/body[1]/h1[1]")
    private WebElement titleMessage;

    @FindBy(tagName = "table")
    private WebElement table;

    @FindBy(xpath = "/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[1]")
    private WebElement firstRow;

    @FindBy(xpath = "/html[1]/body[1]/table[1]/tbody[1]/tr[3]/td[1]")
    private WebElement newRow;

    @FindBy(xpath = "/html[1]/body[1]/table[1]/tbody[1]/tr[2]/td[1]")
    private WebElement secondRow;

    @FindBy(xpath = "/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[9]/a[1]")
    private WebElement editFirstRowLink;

    @FindBy(xpath = "/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[10]/a[1]")
    private WebElement deleteFirstRowLink;

    @FindBy(xpath = "/html[1]/body[1]/form[1]/input[1]")
    private WebElement backToHomeButton;

    public HomePO backToHome(){
        backToHomeButton.click();
        return new HomePO(driver);
    }

    public ShowPrescriptionsPO deleteFirstRow(){
        deleteFirstRowLink.click();
        return new ShowPrescriptionsPO(driver);
    }

    public EditPrescriptionsPo editFirstRow(){
        editFirstRowLink.click();
        return new EditPrescriptionsPo(driver);
    }

    public String getFirstRowId(){
        return firstRow.getText();
    }

    public String getSecondRowId(){
        return secondRow.getText();
    }
    
    public String getNewRowId(){
        return newRow.getText();
    }

    public int getTableSize(){
        return table.findElements(By.tagName("tr")).size();
    }

    public String getMessage(){
        return titleMessage.getText();
    }




}
