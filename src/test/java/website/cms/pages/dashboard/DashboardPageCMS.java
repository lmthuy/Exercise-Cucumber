package website.cms.pages.dashboard;

import keywords.WebUI;
import org.openqa.selenium.By;
import website.cms.pages.category.AddCategoryPage;
import website.cms.pages.common.CommonCMS;
import website.cms.pages.uploadfile.UploadFilePageCMS;

public class DashboardPageCMS extends CommonCMS {
    public DashboardPageCMS(){
    }
    public By menuProducts = By.xpath("//span[normalize-space()='Products']");
    public By menuCategory = By.xpath("//span[normalize-space()='Category']");
    public By menuUploadFile = By.xpath("//span[normalize-space()='Uploaded Files']");
    public By buttonAddNewCategory = By.xpath("//a[@class='btn btn-primary']");
    public AddCategoryPage openAddCategory() {
        WebUI.clickElement(menuProducts);
        WebUI.clickElement(menuCategory);
        WebUI.clickElement(buttonAddNewCategory);
        return new AddCategoryPage();
    }
    public UploadFilePageCMS openUploadFilePageCMS(){
        WebUI.clickElement(menuUploadFile);
        return new UploadFilePageCMS();
    }
    }

