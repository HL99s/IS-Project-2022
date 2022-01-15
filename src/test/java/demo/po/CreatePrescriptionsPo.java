package demo.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePrescriptionsPo extends PageObject{

    public CreatePrescriptionsPo(WebDriver driver){
        super(driver);
    }


    @FindBy(xpath = "/html[1]/body[1]/h1[1]")
    private WebElement initialMessage;

    @FindBy(name = "type")
    private WebElement type;

    @FindBy(name = "comment")
    private WebElement comment;

    @FindBy(xpath = "/html[1]/body[1]/form[1]/input[5]")
    private WebElement submit;

    @FindBy(xpath = "/html[1]/body[1]/form[2]/input[1]")
    private WebElement backToListButton;

    public String getMessage(){
        return this.initialMessage.getText();
    }

    public void enterData(String type, String comment){
        this.type.clear();
        this.comment.clear();
        this.type.sendKeys(type);
        this.comment.sendKeys(comment);
    }

    public ShowPrescriptionsPO validSubmit(){
        submit.click();
        return new ShowPrescriptionsPO(driver);
    }

    public ShowTreatmentsPO backToList(){
        backToListButton.click();
        return new ShowTreatmentsPO(driver);
    }
}
