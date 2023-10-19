package co.wemiguel.digitalbank.automation.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    private WebDriver driver;
    //  MockData mockData = new MockData();

    public BasePage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
}
