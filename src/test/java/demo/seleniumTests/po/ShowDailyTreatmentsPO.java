package demo.seleniumTests.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShowDailyTreatmentsPO extends PageObject{

    public ShowDailyTreatmentsPO(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "/html[1]/body[1]/h1[1]")
    private WebElement titleMessage;

    @FindBy(tagName = "table")
    private WebElement table;

    @FindBy(xpath = "/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[1]")
    private WebElement firstRowId;

    @FindBy(xpath = "/html[1]/body[1]/form[2]/input[1]")
    private WebElement backToHomeButton;

    @FindBy(xpath = "/html[1]/body[1]/form[1]/input[1]")
    private WebElement showAllTreatmentsButton;

    @FindBy(xpath = "/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[7]/a[1]")
    private WebElement createPrescriptionLinkFirstRow;

    public String getMessage(){
        return titleMessage.getText();
    }

    public String getFirstRowId(){
        return firstRowId.getText();
    }

    public int getTableSize(){
        return table.findElements(By.tagName("tr")).size();
    }

    public ShowTreatmentsPO goToAllTreatmentsList(){
        showAllTreatmentsButton.click();
        return new ShowTreatmentsPO(driver);
    }

    public HomePO backToHome(){
        backToHomeButton.click();
        return new HomePO(driver);
    }

    public CreatePrescriptionsPo createPrescription(){
        createPrescriptionLinkFirstRow.click();
        return new CreatePrescriptionsPo(driver);
    }

}