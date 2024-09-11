package website.cms.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import keywords.WebUI;
import org.openqa.selenium.By;
import website.cms.pages.common.CommonCMS;
import website.cms.pages.signin.SignInPageCMS;

public class StepsDashboardCMS extends CommonCMS {
    SignInPageCMS signInPage;
    CommonCMS commonCMS;
    @Given("User logged in with email {string} and password {string}")
    public void userLoggedInWithEmailAndPassword(String email, String password) {
        WebUI.openWebsite("https://cms.anhtester.com/login");
        signInPage = new SignInPageCMS();
        commonCMS = signInPage.signinCMS(email, password);
    }

    @Given("User navigate to dashboard")
    public void userNavigateToDashboard() {
        commonCMS.verifyDashboardPageDisplays();
    }

    @When("User click {string}")
    public void userClick(String menu) {
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(By.xpath("//span[contains(text(),'" + menu + "')]"));
    }

    @Then("The user redirect to this page {string}")
    public void theUserRedirectToThisPage(String menu) {
        WebUI.waitForPageLoaded();
        WebUI.verifyElementTextContains(By.xpath("//span[contains(text(),'" + menu + "')]"), menu);

    }
}
