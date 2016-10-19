package com.heroku.theinternet.tests.web;

import com.frameworkium.core.common.retry.RetryFlakyTest;
import com.frameworkium.core.ui.tests.BaseTest;
import com.heroku.theinternet.pages.web.*;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Stories;

import java.io.File;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class TheInternetExampleTests extends BaseTest {

    @Test
    public void formAuthenticationSuccess() {

        // Navigate to the heroku site's welcome page
        WelcomePage welcomePage = WelcomePage.open();

        // Click the form authentication link
        FormAuthenticationPage formAuthenticationPage = welcomePage.clickFormAuthenticationLink();

        // Log in with the username password provided
        FormAuthenticationSuccessPage successPage = formAuthenticationPage
                .login("tomsmith", "SuperSecretPassword!", FormAuthenticationSuccessPage.class);

        // Confirm that we're on the success page
        assertThat(successPage.getSource()).contains("Welcome to the Secure Area");
    }



    //Test 2 - Form Authentication Failure
    // Navigate to the heroku site's welcome page
    // Click the form authentication link
    // Log in with an incorrect password (but a valid username)
    // Confirm that 'Your password is invalid!' is displayed
}
