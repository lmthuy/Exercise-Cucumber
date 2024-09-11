package website.cms.pages.signin;

import keywords.WebUI;
import org.openqa.selenium.By;
import website.cms.pages.common.CommonCMS;

public class SignInPageCMS {

    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");

    public CommonCMS signinCMS(String email, String password) {
        WebUI.setText(inputEmail, email);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(buttonLogin);
        return new CommonCMS(); // Return a new CommonCMS object after login
    }
}
