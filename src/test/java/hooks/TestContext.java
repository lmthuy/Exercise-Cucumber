package hooks;


import driver.DriverManager;
import driver.TargetFactory;
import website.cms.pages.common.CommonCMS;
import website.cms.pages.signin.SignInPageCMS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

public class TestContext {

    private WebDriver driver;

    public TestContext() {
        driver = ThreadGuard.protect(new TargetFactory().createInstance());
        driver.manage().window().maximize();
        DriverManager.setDriver(driver);
    }

    private SignInPageCMS signinPage;
    private CommonCMS commonPageCMS;

    public SignInPageCMS getSignInPage() {
        if (signinPage == null) {
            signinPage = new SignInPageCMS();
        }
        return signinPage;
    }

    public CommonCMS getCommonPage() {
        if (commonPageCMS == null) {
            commonPageCMS = new CommonCMS();
        }
        return commonPageCMS;
    }

    public WebDriver getDriver() {
        return DriverManager.getDriver();
    }

}
