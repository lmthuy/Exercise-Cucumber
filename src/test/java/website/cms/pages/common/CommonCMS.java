package website.cms.pages.common;

import keywords.WebUI;
import org.openqa.selenium.By;
import website.cms.pages.dashboard.DashboardPageCMS;
import website.cms.pages.category.AddCategoryPage;
import website.cms.pages.signin.SignInPageCMS;

public class CommonCMS {

    private SignInPageCMS signInPage;
    private DashboardPageCMS dashboardPageCMS;
    private AddCategoryPage addProductPageCMS;

    private By dropdownAccount = By.xpath("//a[@id='user-dropdown']//span[2]");
    private By buttonSignOut = By.xpath("//a[normalize-space()='Sign Out']");
    private By menuProducts = By.xpath("//span[normalize-space()='Products']");

    public SignInPageCMS signOut() {
        WebUI.clickElement(dropdownAccount);
        WebUI.clickElement(buttonSignOut);
        return new SignInPageCMS();
    }

    public SignInPageCMS getSignInPage() {
        if (signInPage == null) {
            signInPage = new SignInPageCMS();
        }
        return signInPage;
    }

    public DashboardPageCMS getDashboardPage() {
        if (dashboardPageCMS == null) {
            dashboardPageCMS = new DashboardPageCMS();
        }
        return dashboardPageCMS;
    }

    public AddCategoryPage getAddProductPage() {
        if (addProductPageCMS == null) {
            addProductPageCMS = new AddCategoryPage();
        }
        return addProductPageCMS;
    }

    // Method to verify if the dashboard page is displayed correctly
    public void verifyDashboardPageDisplays() {
        WebUI.waitForPageLoaded();  // Ensure the page is fully loaded before performing checks
        WebUI.verifyContains(WebUI.getCurrentUrl(), "/admin", "The URL does not match.");
        WebUI.verifyElementPresent(menuProducts, 5, "Login failed. The Dashboard page is not displayed.");
    }


}
