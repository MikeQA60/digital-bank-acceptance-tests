package co.wemiguel.digitalbank.automation.ui.pages;

import co.wemiguel.digitalbank.automation.ui.models.NewCheckingAccountInfo;
import co.wemiguel.digitalbank.automation.ui.utils.ConfigReader;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.NoSuchElementException;

import static co.wemiguel.digitalbank.automation.ui.utils.Driver.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateCheckingPage extends BaseMenuPage {
//    private WebDriver driver;


    public CreateCheckingPage(WebDriver driver) {
super(driver);

    }

//    @FindBy(id = "checking-menu")
//    private WebElement checkingMenu;
//
//    @FindBy(id = "new-checking-menu-item")
//    private WebElement newCheckingMenuBtn;

    @FindBy(id = "Standard Checking")
    private WebElement standardCheckingAccountTypRadioBtn;


    @FindBy(id = "Interest Checking")
    private  WebElement interestCheckingAccountTypeRadioBtn;

    @FindBy(id = "Individual")
    private WebElement indOwnershipTypeRadioBtn;
    @FindBy(id = "Joint")
    private WebElement jointOwnershipTypeRadioBtn;

    @FindBy(id = "name")
    private WebElement accountNameTxtBtn;

    @FindBy(id = "openingBalance")
    private WebElement openingBalanceTxtBox;

    @FindBy(id = "newCheckingSubmit")
    private WebElement submitBtn;

//    @FindBy(id = "new-account-conf-alert")
//    private  WebElement alertConfMessage;

   // WebElement newAccountConfAlertDiv =  driver.findElement(By.id("new-account-conf-alert"));

//    expectedConfMessage = "Confirmation " + expectedConfMessage + "\n×";
//    assertEquals(expectedConfMessage, newAccountConfAlertDiv.getText();


  //  @When("the user creates a new checking account with the following date")
    public void createNewChecking(List<NewCheckingAccountInfo> checkingAccountInfoList) {

        NewCheckingAccountInfo testDataForOneCheckingAccount = checkingAccountInfoList.get(0);
        //user clicks on checking button
        checkingMenu.click();

        //the user clicks on the new checking button

        newCheckingMenuBtn.click();

        String expectedUrl = "https://dbank-qa.wedevx.co/bank/account/checking-add";
        assertEquals(ConfigReader.getPropertiesValue("digitalbank.createnewcheckingurl"), getDriver().getCurrentUrl(), "new Checking Button didnt take to the" + expectedUrl);

        //the user selects the account type
        if(testDataForOneCheckingAccount.getCheckingAccountType().equalsIgnoreCase("Standard Checking")) {
        standardCheckingAccountTypRadioBtn.click();
        }
        else if (testDataForOneCheckingAccount.getCheckingAccountType().equalsIgnoreCase("Interest Checking")) {
            interestCheckingAccountTypeRadioBtn.click();
        }

        else {
            throw new NoSuchElementException("Invalid checking account type option. Only supports Standard Checking and Interest Checking");

        }


        if(testDataForOneCheckingAccount.getAccountOwnership().equalsIgnoreCase("Individual")) {
            indOwnershipTypeRadioBtn.click();
        }

        else if (testDataForOneCheckingAccount.getAccountOwnership().equalsIgnoreCase("Joint")){
            jointOwnershipTypeRadioBtn.click();

        }

        else {
            throw new NoSuchElementException("Invalid ownership type option provided.  Only supports Individual Checking and Joint Checking");

        }
//        WebElement accountTypeRadioButton =  driver.findElement(By.id(testDataForOneCheckingAccount.getCheckingAccountType()));
//        accountTypeRadioButton.click();
//
//        //the user selects ownership
//        WebElement ownershipTypeRadioButton = driver.findElement(By.id(testDataForOneCheckingAccount.getAccountOwnership()));
//        ownershipTypeRadioButton.click();

        //the user names the account

        accountNameTxtBtn.sendKeys(testDataForOneCheckingAccount.getAccountName());

        //  the user makes the initial deposit

        openingBalanceTxtBox.sendKeys(String.valueOf(testDataForOneCheckingAccount.getInitialDepositAmount()));

        //the user clicks on submit
        submitBtn.click();

    }

}
