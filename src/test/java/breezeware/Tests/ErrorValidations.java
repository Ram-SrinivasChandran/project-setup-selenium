package breezeware.Tests;

import breezeware.Components.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;



public class ErrorValidations extends BaseTest {
    @Test
    public void loginErrorValidation() throws InterruptedException {
        loginPage.loginApplication("ramsrinivas@breezeware.net", "Breeze@123");
        Assert.assertEquals("The credential that you've entered is incorrect", loginPage.getErrorMessage());
    }

}
