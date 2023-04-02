package cydeo.pages;

import cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    public Login () { PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id="prependedInput")
    public WebElement inputUsername;

    @FindBy(id="prependedInput2")
    public WebElement inputPassword;

    @FindBy (id="_submit")
    public WebElement loginButton;



























}
