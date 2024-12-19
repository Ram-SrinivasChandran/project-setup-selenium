package breezeware.Tests;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.Test;

import breezeware.Compass.LogInPage;
import breezeware.ManageDrivers.CompassShareContext;
import breezeware.data.TestDataProvider;

public class LoginSteps {
    CompassShareContext compassShareContext;

    LogInPage logInPage;

    public LoginSteps() throws IOException {
        compassShareContext = new CompassShareContext();
        logInPage = compassShareContext.compassPageObjectManager().getLoginPage();
    }

    @Test(dataProvider = "getData", dataProviderClass = TestDataProvider.class, groups = "login", alwaysRun = true)
    public void enterMail(HashMap<String, String> input) throws InterruptedException {
        logInPage.enterEmail(input.get("email"));
    }

    @Test(dataProvider = "getData", dataProviderClass = TestDataProvider.class, groups = "login", alwaysRun = true,
            dependsOnMethods = "enterMail")
    public void enterPassword(HashMap<String, String> input) {
        logInPage.enterPassword(input.get("password"));
    }

    @Test(groups = "login", alwaysRun = true, dependsOnMethods = "enterPassword")
    public void login() {
        logInPage.login();
    }
}
