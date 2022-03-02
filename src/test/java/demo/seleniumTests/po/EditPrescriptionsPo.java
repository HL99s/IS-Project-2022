package demo.seleniumTests.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditPrescriptionsPo extends PageObject{

    public EditPrescriptionsPo(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "/html[1]/body[1]/h1[1]")
    private WebElement initialMessage;

    @FindBy(name = "idPatient")
    private WebElement idPatient;

    @FindBy(name = "idTreatment")
    private WebElement idTreatment;

    @FindBy(name = "type")
    private WebElement type;

    @FindBy(name = "comment")
    private WebElement comment;

    @FindBy(xpath = "/html[1]/body[1]/form[1]/input[6]")
    private WebElement submit;

    @FindBy(xpath = "/html[1]/body[1]/form[2]/input[1]")
    private WebElement backToListButton;

    public String getMessage(){
        return this.initialMessage.getText();
    }

    public void enterData(String idPatient, String idTreatment, String type, String comment){
        this.idPatient.clear();
        this.idTreatment.clear();
        this.idPatient.sendKeys(idPatient);
        this.idTreatment.sendKeys(idTreatment);
        this.type.clear();
        this.comment.clear();
        this.type.sendKeys(type);
        this.comment.sendKeys(comment);
    }

    public ShowPrescriptionsPO validSubmit(){
        submit.click();
        return new ShowPrescriptionsPO(driver);
    }

    public ShowPrescriptionsPO backToList(){
        backToListButton.click();
        return new ShowPrescriptionsPO(driver);
    }
}
