package co.wemiguel.digitalbank.automation.ui.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class ProfilePage {

    @FindBy(
            xpath = "//img[@alt='User Avatar']"
    )
    WebElement profilePicture;
    @FindBy(
            xpath = "//a[normalize-space()='My Profile']"
    )
    WebElement myProfileBtn;
    @FindBy(
            xpath = "//li[@class='active']"
    )
    WebElement welcomeMessage;
    @FindBy(
            id = "title"
    )
    WebElement title;
    @FindBy(
            id = "firstName"
    )
    WebElement firstName;
    @FindBy(
            id = "lastName"
    )
    WebElement lastName;
    @FindBy(
            id = "homePhone"
    )
    WebElement homePhone;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickProfilePic() {
        this.profilePicture.click();
        this.myProfileBtn.click();
    }

    public String getTitle() {
        return this.title.getAttribute("value");
    }

    public String getTheFirstname() {
        return this.firstName.getAttribute("value");
    }

    public String getTheLastname() {
        return this.lastName.getAttribute("value");
    }
}






