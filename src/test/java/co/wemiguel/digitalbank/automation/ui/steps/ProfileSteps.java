package co.wemiguel.digitalbank.automation.ui.steps;




import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import co.wemiguel.digitalbank.automation.ui.models.ProfileInfo;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import co.wemiguel.digitalbank.automation.ui.utils.Driver;
import co.wemiguel.digitalbank.automation.ui.pages.ProfilePage;



public class ProfileSteps {


 WebDriver driver = Driver.getDriver();
 private ProfilePage profilePage;

        //= new ProfilePage(driver);


    public ProfileSteps() {
        this.profilePage = new ProfilePage(this.driver);

    }
    @Given("user login as {string} {string}")
    public void user_login_as(String string, String string2) {

    }

    @When("user clicks on profile picture")
    public void user_clicks_on_profile_picture() {
        this.profilePage.clickProfilePic();
    }

    @When("click on my profile picture")
    public void click_on_my_profile_picture() {


    }

    @Then("user should see all registration info")
    public void user_should_see_all_registration_info(List<ProfileInfo> profileInfoList) {
        ProfileInfo expectedInfo = profileInfoList.get(0);
      //  assertEquals(expectedInfo.getTitle(),profilePage.getTitle(), "error title");
//        assertEquals(expectedInfo.getTitle(),profilePage.getfirstName(), "error firstname");
//        assertEquals(expectedInfo.getTitle(),profilePage.getlastName(), "error lastname");

        Assertions.assertEquals(expectedInfo.getTitle(), this.profilePage.getTitle(), "error title");
        Assertions.assertEquals(expectedInfo.getFirstName(), this.profilePage.getTheFirstname(), "error firstname");
        Assertions.assertEquals(expectedInfo.getLastName(), this.profilePage.getTheLastname(), "error lastname");
    }
}
