package cydeo.step_definitions;


import cydeo.pages.LandingPage;
import cydeo.pages.Login;
import cydeo.utilities.ConfigurationReader;
import cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_StepDefinitions {
    Login login=new Login();
    LandingPage landingPage = new LandingPage();
    @Given("User is on the login page")
    public void user_is_on_the_login_page()  {
        Driver.getDriver().get(ConfigurationReader.getProperty("login.page.url"));

    }
    @When("The user logs in as a driver")
    public void the_user_logs_in_as_a_driver()  {
        login.inputUsername.sendKeys(ConfigurationReader.getProperty("driver.username"));
        login.inputPassword.sendKeys(ConfigurationReader.getProperty("all.pw"));
        login.loginButton.click();

    }
    @Then("The user is on the Quick Launchpad page")
    public void the_user_is_on_the_quick_launchpad_page() {
        String expectedQLaunchpadText="Quick Launchpad";
        String actualQLaunchpadText= landingPage.quickLaunchpad.getText();
        Assert.assertEquals(expectedQLaunchpadText,actualQLaunchpadText);
    }
    @When("The user logs in as a sales manager")
    public void the_user_logs_in_as_a_sales_manager() {
        login.inputUsername.sendKeys(ConfigurationReader.getProperty("salesmanager.username"));
        login.inputPassword.sendKeys(ConfigurationReader.getProperty("all.pw"));
        login.loginButton.click();

    }

    @Then("The user is on the Dashboard page")
    public void the_user_is_on_the_dashboard_page() {
        String expectedDashboardText="Dashboard";
        String actualDashboardText= landingPage.dashboard.getText();
        Assert.assertEquals(expectedDashboardText,actualDashboardText);
    }


    @When("The user logs in as a store manager")
    public void the_user_logs_in_as_a_store_manager() {
        login.inputUsername.sendKeys(ConfigurationReader.getProperty("storemanager.username"));
        login.inputPassword.sendKeys(ConfigurationReader.getProperty("all.pw"));
        login.loginButton.click();

    }


    @When("The user enters invalid username and password")
    public void the_user_enters_invalid_username_and_password() {
login.inputUsername.sendKeys(ConfigurationReader.getProperty("invalid.username"));
login.inputPassword.sendKeys(ConfigurationReader.getProperty("invalid.pw"));
login.loginButton.click();
    }
    @Then("The user sees 'Invalid username or password'")
    public void the_user_sees_invalid_username_or_password() {
        landingPage.invalidUsernameOrPassword.isDisplayed();

    }

    @When("The user leaves the username or password input box empty")
    public void the_user_leaves_the_username_or_password_input_box_empty() {
        login.inputPassword.sendKeys(ConfigurationReader.getProperty("all.pw"));
        login.loginButton.click();

    }
    @Then("The user sees 'Please fill in this field' warning message")
    public void the_user_sees_warning_message_please_fill_in_this_field() {
        String expectedMessage="Please fill in this field.";
        String actualMessage=login.inputUsername.getAttribute("validationMessage");
        Assert.assertEquals(expectedMessage,actualMessage);


    }
    @When("The user leaves both username and password input boxes are empty and clicks on login button")
    public void the_user_leaves_both_username_and_password_input_boxes_are_empty_and_clicks_on_login_button() {
        login.loginButton.click();

    }
    @Then("The user sees 'Please fill in this field' warning message only in the username input box")
    public void the_user_sees_warning_message_only_in_the_username_input_box_please_fill_in_this_field() {
        String expectedMessage="Please fill in this field.";
        String actualMessage=login.inputUsername.getAttribute("validationMessage");
        Assert.assertEquals(expectedMessage,actualMessage);

    }

    @Then("The driver sees their own username in the profile menu")
    public void the_driver_sees_their_own_username_in_the_profile_menu() throws InterruptedException {
        Thread.sleep(3000);
        String expectedProfileName=ConfigurationReader.getProperty("driver.username");
        String actualProfileName=landingPage.userProfile.getText();
        Assert.assertEquals(expectedProfileName,actualProfileName);

    }


    @Then("The sales manager sees their own username in the profile menu")
    public void the_sales_manager_sees_their_own_username_in_the_profile_menu() throws InterruptedException {
        Thread.sleep(3000);
        String expectedProfileName=ConfigurationReader.getProperty("salesmanager.username");
        String actualProfileName=landingPage.userProfile.getText();
        Assert.assertEquals(expectedProfileName,actualProfileName);
    }

    @Then("The store manager sees their own username in the profile menu")
    public void the_store_manager_sees_their_own_username_in_the_profile_menu() throws InterruptedException {
        Thread.sleep(3000);
        String expectedProfileName=ConfigurationReader.getProperty("storemanager.username");
        String actualProfileName=landingPage.userProfile.getText();
        Assert.assertEquals(expectedProfileName,actualProfileName);
    }









}
