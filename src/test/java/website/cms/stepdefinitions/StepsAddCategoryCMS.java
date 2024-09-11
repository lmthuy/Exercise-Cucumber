package website.cms.stepdefinitions;

import driver.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import website.cms.pages.category.AddCategoryPage;
import website.cms.pages.common.CommonCMS;
import website.cms.pages.dashboard.DashboardPageCMS;
import website.cms.pages.signin.SignInPageCMS;

public class StepsAddCategoryCMS {
    SignInPageCMS signInPage;
    CommonCMS commonCMS;
    DashboardPageCMS dashboardPageCMS;
    AddCategoryPage addCategoryPage;

    @Given("User is logged in to the CMS")
    public void userIsLoggedInToTheCMS(String email, String password) {
        WebUI.openWebsite("https://cms.anhtester.com/login");
        signInPage = new SignInPageCMS();
        commonCMS = signInPage.signinCMS(email, password);
        WebUI.waitForPageLoaded();
    }
    @Given("User navigates to the {string} page")
    public void userNavigatesToThePage(String pageName) {
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        dashboardPageCMS = new DashboardPageCMS();
        addCategoryPage = new AddCategoryPage();
        addCategoryPage = dashboardPageCMS.openAddCategory();
    }
    @And("User enters the category name {string}")
    public void userEntersTheCategoryName(String categoryName) throws InterruptedException {
        if (addCategoryPage == null) {
            addCategoryPage = new AddCategoryPage();
        }
        addCategoryPage.fillCategoryDetails(categoryName);
    }


    @Then("the new category {string} should be added to the list")
    public void theNewCategoryShouldBeAddedToTheList(String categoryName) {
        WebUI.openWebsite("https://cms.anhtester.com/admin/categories");
        WebUI.setText(By.xpath("//input[@id='search']"), categoryName);
        DriverManager.getDriver().findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
        By categoryLocator = By.xpath("//td[contains(text(), '" + categoryName + "')]");

        // Verify if the category is present in the list
        WebUI.verifyElementPresent(categoryLocator, "The category '" + categoryName + "' was not found in the list.");
    }
    }

