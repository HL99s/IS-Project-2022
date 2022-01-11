package demo.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmptyListPO extends PageObject{

    public EmptyListPO(WebDriver driver){
        super(driver);
    }

    @FindBy(linkText = "Add new person")
    private WebElement addPersonLink;

    @FindBy(tagName = "h1")
    private WebElement message;

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
        return message.getText();
    }

    public AddPersonPO addPerson(){
        addPersonLink.click();
        return new AddPersonPO(driver);
    }
}
