package testCases;

import annotation.Author;
import annotation.TestCaseNotes;
import org.testng.annotations.Test;
import testBase.TestBase;
import utils.Categories;
import utils.Properties;

import static annotation.TesterName.AKASH;

public class LoginTestCase extends TestBase {


    @Author(name = AKASH)
    @TestCaseNotes(Steps = "https://www.makemytrip.com || click on login button|| enter the  valid user id || enter the valid password|| login", expecatedResult = "User should be login successfully")
    @Test(groups = {Categories.SMOKE})
    public void loginWithCorrectData() {
        navigateTo(Properties.baseUrl);
        loginPage.isLoginButtonIsDisplay();
        loginPage.clickOnLoginButton();
        loginPage.isUserNameTextIsDisplay();
        loginPage.enterUserId(Properties.username);
        loginPage.isContinueButtonIsDisplay();
        loginPage.clickContinueButton();
        loginPage.isEnterPasswordTextFieldIsDisplay();
        loginPage.clickOnEnterPasswordTextField(Properties.password);
        loginPage.isLoginIsDisplay();
        loginPage.clickOnLogin();
        loginPage.isMobilePopUpDisplay();
        loginPage.clickOnCloseMobilePopUp();
    }

    @Author(name = AKASH)
    @TestCaseNotes(Steps = "https://www.makemytrip.com || click on login button|| enter the  valid user id || enter the invalid password|| login", expecatedResult = "User should not login successfully")
    @Test(groups = {Categories.SMOKE})
    public void loginWithCorrectUserNameWrongPassword() {
        navigateTo(Properties.baseUrl);
        loginPage.isLoginButtonIsDisplay();
        loginPage.clickOnLoginButton();
        loginPage.isUserNameTextIsDisplay();
        loginPage.enterUserId(Properties.username);
        loginPage.isContinueButtonIsDisplay();
        loginPage.clickContinueButton();
        loginPage.isEnterPasswordTextFieldIsDisplay();
        loginPage.clickOnEnterPasswordTextField(Properties.wrongPassword);
        loginPage.isLoginIsDisplay();
        loginPage.clickOnLogin();
        loginPage.isErrorMessageDisplayForWrongPWD();

    }

    @Author(name = AKASH)
    @TestCaseNotes(Steps = "https://www.makemytrip.com || click on login button|| enter the  valid user id || enter the invalid password|| login", expecatedResult = "User should not login successfully")
    @Test(groups = {Categories.SMOKE})
    public void loginWithInCorrectUserNameCorrectPassword() {
        navigateTo(Properties.baseUrl);
        loginPage.isLoginButtonIsDisplay();
        loginPage.clickOnLoginButton();
        loginPage.isUserNameTextIsDisplay();
        loginPage.enterUserId(Properties.wrongUserName);
        loginPage.isContinueButtonIsDisplay();
        loginPage.clickContinueButton();
        loginPage.isErrorMessageDisplayForWrongUserName();

    }
}
