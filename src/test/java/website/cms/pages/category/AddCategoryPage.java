package website.cms.pages.category;

import driver.DriverManager;
import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class AddCategoryPage {
    By enterCategoryName = By.xpath("//input[@id='name']");
    By enterOrderLevel = By.xpath("//input[@id='order_level']");
    By enterMeteDescription = By.xpath("//textarea[@name='meta_description']");
    By submitButton = By.cssSelector("button[type='submit']");

    public void fillCategoryDetails(String categoryName) throws InterruptedException {
        WebUI.setText(enterCategoryName, categoryName);
        WebUI.setText(enterOrderLevel,"1");
        WebUI.setText(enterMeteDescription,"Testing Auto");
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        WebElement button = DriverManager.getDriver().findElement(submitButton);
        js.executeScript("arguments[0].click();", button);

    }
}




