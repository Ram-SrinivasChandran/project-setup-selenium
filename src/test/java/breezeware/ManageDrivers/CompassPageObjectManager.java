package breezeware.ManageDrivers;

import org.openqa.selenium.WebDriver;

import breezeware.Compass.LogInPage;

public class CompassPageObjectManager {

    private WebDriver adminDriver;
    private LogInPage loginPage;

    public CompassPageObjectManager(WebDriver adminDriver) {
        this.adminDriver = adminDriver;
    }

    public LogInPage getLoginPage() {
        loginPage = new LogInPage(adminDriver);
        return loginPage;
    }

}
