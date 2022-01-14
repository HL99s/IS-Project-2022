package demo.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShowTreatmentsPO extends PageObject{

    public ShowTreatmentsPO(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "/html[1]/body[1]/h1[1]")
    private WebElement titleMessage;

    @FindBy(tagName = "table")
    private WebElement table;

    @FindBy(xpath = "//table//tbody//td[2]")
    private WebElement firstRow;

    public String getFirstRowName(){
        return firstRow.getText();
    }

    public int getTableSize(){
        return table.findElements(By.tagName("tr")).size();
    }

    public String getMessage(){
        return titleMessage.getText();
    }


}