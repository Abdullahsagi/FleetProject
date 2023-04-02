package cydeo.pages;

import cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    public LandingPage( ) { PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    public WebElement quickLaunchpad;

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    public WebElement dashboard;

    @FindBy(xpath = "//*[@id='login-form']/fieldset/div[1]/div")
    public WebElement invalidUsernameOrPassword;

    @FindBy(css = "li a.dropdown-toggle")
    public WebElement userProfile;

    @FindBy(xpath = "//a[.='Logout']")
    public WebElement logoutButton;

    @FindBy(xpath = "//h2")
    public WebElement loginPageTitle;






















}
