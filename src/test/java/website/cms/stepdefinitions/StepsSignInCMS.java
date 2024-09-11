package website.cms.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import keywords.WebUI;
import website.cms.pages.common.CommonCMS;
import website.cms.pages.signin.SignInPageCMS;

public class StepsSignInCMS {

    SignInPageCMS signInPage;
    CommonCMS commonCMS;

    @Given("User is on the Admin Login Page {string}")
    public void userIsOnTheAdminLoginPage(String url) {
        WebUI.openWebsite(url);
        signInPage = new SignInPageCMS();
    }

    @When("user logs in with {string} and {string}")
    public void userLogsInWithAnd(String email, String password) {
        commonCMS = signInPage.signinCMS(email, password);
    }

    @And("click Login button")
    public void clickLoginButton() {
    }

    @Then("user is redirected to the Dashboard")
    public void userIsRedirectedToTheDashboard() {
        commonCMS.verifyDashboardPageDisplays();
    }

}

