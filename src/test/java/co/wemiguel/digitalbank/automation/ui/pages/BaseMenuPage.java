package co.wemiguel.digitalbank.automation.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BaseMenuPage extends BasePage{

    public BaseMenuPage(WebDriver driver) {

        super(driver);
    }

        @FindBy(id = "checking-menu")
    protected WebElement checkingMenu;

    @FindBy(id = "new-checking-menu-item")
    protected WebElement newCheckingMenuBtn;

    @FindBy(id = "view-checking-menu-item")
    protected WebElement viewCheckingMenuBtn;

    @FindBy(id = "home-menu-item")
    protected WebElement homeBtn;


    public void goToHomePage() {
        homeBtn.click();
    }
}
