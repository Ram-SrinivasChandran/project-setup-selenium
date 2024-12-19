package breezeware.Tests;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.Test;

import breezeware.Compass.LogInPage;
import breezeware.ManageDrivers.CompassShareContext;
import breezeware.data.TestDataProvider;

public class LoginTest {
    CompassShareContext compassShareContext;
    LogInPage logInPage;

    public LoginTest() throws IOException {
        compassShareContext = new CompassShareContext();
        logInPage = compassShareContext.compassPageObjectManager().getLoginPage();
    }

    @Test(dataProvider = "getData", dataProviderClass = TestDataProvider.class, groups = { "CompassLogIn" })
    public void LoginRenterApplication(HashMap<String, String> input) throws InterruptedException {
        logInPage.loginApplication(input.get("email"), input.get("password"));
    }
}
