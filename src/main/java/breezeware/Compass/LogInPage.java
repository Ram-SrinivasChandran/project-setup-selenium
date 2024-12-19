package breezeware.Compass;

import breezeware.AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends AbstractComponent {

    WebDriver driver;

    WebDriver renterDriver;

    public LogInPage(WebDriver renterDriver) {
        super(renterDriver);
        this.renterDriver = renterDriver;
        PageFactory.initElements(renterDriver, this);
    }

    @FindBy(xpath = "//button[normalize-space()='Profile']")
    WebElement profile;

    @FindBy(css = "div ul div li:nth-child(1)")
    WebElement login;
    @FindBy(xpath = "//*[@id=\":r0:\"]")
    WebElement userEmail;

    @FindBy(xpath = "//*[@id=\":r1:\"]")
    WebElement userPassword;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/div/div[2]/form/div/button")
    WebElement submit;

    @FindBy(css = "p[class*='css-fqrkig']")
    WebElement errorMessage;

    public void loginApplication(String email, String password) throws InterruptedException {
        userEmail.sendKeys(email);
        Thread.sleep(2000);
        userPassword.sendKeys(password);
        Thread.sleep(2000);
        submit.click();

    }

    public String getErrorMessage() {
        waitForWebElementToApper(errorMessage);
        return errorMessage.getText();
    }

    public void clickLogin() {
        profile.click();
        login.click();
    }

    public void enterEmail(String email) throws InterruptedException {
        Thread.sleep(1000);
        userEmail.sendKeys(email);
    }

    public void enterPassword(String password) {
        userPassword.sendKeys(password);
    }

    public void login() {
        submit.click();
    }

}
