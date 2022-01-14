package demo.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePO extends PageObject{

    public HomePO(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "/html[1]/body[1]/h1[1]")
    private WebElement welcomeMessage;

    @FindBy(xpath = "/html[1]/body[1]/form[1]/input[1]")
    private WebElement patientsButton;

    @FindBy(xpath = "/html[1]/body[1]/form[2]/input[1]")
    private WebElement treatmentsButton;

    @FindBy(xpath = "/html[1]/body[1]/form[3]/input[1]")
    private WebElement prescriptionsButton;

    public String getMessage(){
        return welcomeMessage.getText();
    }

    public ShowPrescriptionsPO showPrescriptionsSubmit(){
        prescriptionsButton.click();
        return new ShowPrescriptionsPO(driver);
    }

    public ShowPatientsPO showPatientsSubmit(){
        patientsButton.click();
        return new ShowPatientsPO(driver);
    }
    
    public ShowTreatmentsPO showTreatmentsSubmit(){
        treatmentsButton.click();
        return new ShowTreatmentsPO(driver);
    }

}
