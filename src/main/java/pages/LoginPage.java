package pages;

import driver.DriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BasePage {


    @FindBy(css = "li[data-cy='account']")
    private WebElement loginButton;

    @FindBy(css = "#username")
    private WebElement userName;

    @FindBy(css = "button[data-cy='continueBtn']")
    private WebElement continueButton;

    @FindBy(id = "password")
    private WebElement enterPasswordTextField;


    @FindBy(css = "button[data-cy='login']")
    private WebElement login;

    @FindBy(css = "span[data-cy='modalClose']")
    private WebElement closeMobilePopUp;

    @FindBy(css = "span[data-cy='userNotPresent']")
    private WebElement wrongUserNameError;

    @FindBy(css = "span[data-cy='serverError']")
    private WebElement wrongPasswordErrorMessage;

    public LoginPage() {
        driver = DriverProvider.getDriver();
        PageFactory.initElements(driver, this);
    }


    public void isLoginButtonIsDisplay() {
        waitForElementToBeDisplay(loginButton);
        Assert.assertTrue(loginButton.isDisplayed(), String.format("%s button is not display", loginButton.getText()));
    }


    public void clickOnLoginButton() {
        waitForElementToBeDisplay(loginButton);
        jsClick(loginButton);
    }

    public void isUserNameTextIsDisplay() {
        waitForElementToBeDisplay(userName);
        Assert.assertTrue(userName.isDisplayed(), "user unable to enter the user id in text field");
    }


    public void enterUserId(String id) {
        waitForElementToBeDisplay(userName);
        userName.sendKeys(id);
    }

    public void isContinueButtonIsDisplay() {
        waitForElementToBeDisplay(continueButton);
        Assert.assertTrue(continueButton.isDisplayed(), String.format("%s button is not display", continueButton.getText()));
    }


    public void clickContinueButton() {
        System.out.println(continueButton.getText());
        waitForElementTobeClickable(continueButton);
        continueButton.click();
        jsClick(continueButton);
    }

    public void isEnterPasswordTextFieldIsDisplay() {
        waitForElementToBeDisplay(enterPasswordTextField);
        Assert.assertTrue(enterPasswordTextField.isDisplayed(), " enter password text filed  is not display");
    }


    public void clickOnEnterPasswordTextField(String password) {
        waitForElementToBeDisplay(enterPasswordTextField);
        enterPasswordTextField.sendKeys(password);
    }

    public void isLoginIsDisplay() {
        waitForElementToBeDisplay(login);
        Assert.assertTrue(login.isDisplayed(), " login button  is not display");
    }


    public void clickOnLogin() {
        waitForElementToBeDisplay(login);
        jsClick(login);
    }

    public void isMobilePopUpDisplay() {
        waitForElementToBeDisplay(closeMobilePopUp);
        Assert.assertTrue(closeMobilePopUp.isDisplayed(), " close Mobile PopUp  is not display");
    }


    public void clickOnCloseMobilePopUp() {
        waitForElementToBeDisplay(closeMobilePopUp);
        jsClick(closeMobilePopUp);
    }

    public void isErrorMessageDisplayForWrongUserName() {
        waitForElementToBeDisplay(wrongUserNameError);
        Assert.assertTrue(wrongUserNameError.isDisplayed(), " error message is not display");
        System.out.println(wrongUserNameError.getText());
        Assert.assertEquals(wrongUserNameError.getText(),"This username does not exist. CLICK HERE If your are trying to create a new personal account" ," after login with incorrect data error message is not displaying");
    }

 public void isErrorMessageDisplayForWrongPWD() {
        waitForElementToBeDisplay(wrongPasswordErrorMessage);
        Assert.assertTrue(wrongPasswordErrorMessage.isDisplayed(), " error message  is not display");
        Assert.assertEquals(wrongPasswordErrorMessage.getText(),"Either Username or Password is incorrect." ," after login with incorrect data error message is not displaying");
    }



}
