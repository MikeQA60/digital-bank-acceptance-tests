package co.wemiguel.digitalbank.automation.ui.steps;

import co.wemiguel.digitalbank.automation.ui.models.AccountCard;
import co.wemiguel.digitalbank.automation.ui.models.BankTransaction;
import co.wemiguel.digitalbank.automation.ui.models.NewCheckingAccountInfo;
import co.wemiguel.digitalbank.automation.ui.pages.CreateCheckingPage;
import co.wemiguel.digitalbank.automation.ui.pages.LoginPage;
import co.wemiguel.digitalbank.automation.ui.pages.ViewCheckingAccountPage;
import co.wemiguel.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CheckingAccountSteps {


   WebDriver driver = Driver.getDriver();

    private LoginPage loginPage = new LoginPage(driver);
    private CreateCheckingPage createCheckingPage = new CreateCheckingPage(driver);
    private ViewCheckingAccountPage viewCheckingAccountPage = new ViewCheckingAccountPage(driver);


    @Given("the user logged in as {string} {string}")
    public void the_user_logged_in_as(String username, String password) {
        loginPage.login(username,password);
//        WebElement usernametxt = driver.findElement(By.id("username"));
//        WebElement passwordtxt =  driver.findElement(By.id("password"));
//        WebElement submitBtn = driver.findElement(By.id("submit"));
//
//
//        usernametxt.sendKeys(username);
//        passwordtxt.sendKeys(password);
//        submitBtn.click();
    }

//    @Given("the user clicks on the checking button")
//    public void the_user_clicks_on_the_checking_button() {
//       WebElement checkingMenu = driver.findElement(By.id("checking-menu"));
//       checkingMenu.click();
//
//    }
//    @Given("the user click on new checking button")
//    public void the_user_click_on_new_checking_button() {
//    WebElement newCheckingButton = driver.findElement(By.id("new-checking-menu-item"));
//    newCheckingButton.click();
//
//    String expectedUrl = "https://dbank-qa.wedevx.co/bank/account/checking-add";
//    assertEquals(expectedUrl, driver.getCurrentUrl(), "new Checking Button didnt take to the" + expectedUrl);
//    }
//    @When("the user selects {string} Account type")
//    public void the_user_selects_account_type(String idOfRadioButton) {
//      WebElement accountTypeRadioButton =  driver.findElement(By.id(idOfRadioButton));
//      accountTypeRadioButton.click();
//
//    }
//    @When("the user selects {string} Account Ownership")
//    public void the_user_selects(String ownershipTypeRadioButtonId) {
//        WebElement ownershipTypeRadioButton = driver.findElement(By.id(ownershipTypeRadioButtonId));
//        ownershipTypeRadioButton.click();
//
//    }
//    @When("the user names the account {string}")
//    public void the_user_names_the_account(String accountName) {
//        WebElement accountNameTxt = driver.findElement(By.id("name"));
//        accountNameTxt.sendKeys(accountName);
//
//    }
//    @When("the user makes the initial deposit of {double}")
//    public void the_user_makes_the_initial_deposit_of(Double openingBalance) {
//        WebElement openingBalanceTxtBox = driver.findElement(By.id("openingBalance"));
//        openingBalanceTxtBox.sendKeys(String.valueOf(openingBalance));
//
//    }
//    @When("the user clicks on submit")
//    public void the_user_clicks_on_submit() {
//        WebElement submit = driver.findElement(By.id("newCheckingSubmit"));
//        submit.click();
//    }

    @When("the user creates a new checking account with the following date")
    public void the_user_creates_a_new_checking_account_with_the_following_date(List<NewCheckingAccountInfo> checkingAccountInfoList) {

        createCheckingPage.createNewChecking(checkingAccountInfoList);
//        NewCheckingAccountInfo testDataForOneCheckingAccount = checkingAccountInfoList.get(0);
//        //user clicks on checking button
//        WebElement checkingMenu =  driver.findElement(By.id("checking-menu"));
//        checkingMenu.click();
//
//        //the user clicks on the new checking button
//        WebElement newCheckingButton = driver.findElement(By.id("new-checking-menu-item"));
//        newCheckingButton.click();
//
//        String expectedUrl = "https://dbank-qa.wedevx.co/bank/account/checking-add";
//        assertEquals(expectedUrl, driver.getCurrentUrl(), "new Checking Button didnt take to the" + expectedUrl);
//
//        //the user selects the account type
//        WebElement accountTypeRadioButton =  driver.findElement(By.id(testDataForOneCheckingAccount.getCheckingAccountType()));
//        accountTypeRadioButton.click();
//
//        //the user selects ownership
//        WebElement ownershipTypeRadioButton = driver.findElement(By.id(testDataForOneCheckingAccount.getAccountOwnership()));
//        ownershipTypeRadioButton.click();
//
//        //the user names the account
//        WebElement accountNameTxt = driver.findElement(By.id("name"));
//        accountNameTxt.sendKeys(testDataForOneCheckingAccount.getAccountName());
//
//        //  the user makes the initial deposit
//        WebElement openingBalanceTxtBox = driver.findElement(By.id("openingBalance"));
//        openingBalanceTxtBox.sendKeys(String.valueOf(testDataForOneCheckingAccount.getInitialDepositAmount()));
//
//        //the user clicks on submit
//        WebElement submit = driver.findElement(By.id("newCheckingSubmit"));
//        submit.click();

    }
    @Then("the user should see the green {string} message")
    public void the_user_should_see_the_green_message(String expectedConfMessage) {
//        WebElement newAccountConfAlertDiv =  driver.findElement(By.id("new-account-conf-alert"));
//
       expectedConfMessage = "Confirmation " + expectedConfMessage + "\n×";


        //  String actualConfMessage = newAccountConfAlertDiv.getText();

        // System.out.println(actualConfMessage.substring(0, actualConfMessage.indexOf("\n")));

//        assertEquals(expectedConfMessage, newAccountConfAlertDiv.getText());
        //.substring(0,newAccountConfAlertDiv.getText().indexOf("\n")));

//        assertEquals(expectedConfMessage, createCheckingPage.getActualCreateAccountConfirmationMessage());

        assertEquals(expectedConfMessage, viewCheckingAccountPage.getActualConfMessage());
    }
    @Then("the user should see newly added account card")
    public void the_user_should_see_newly_added_account_card(List<AccountCard> accountCardList) {

        Map<String, String> actualResultMap = viewCheckingAccountPage.newlyAddedAccountInfo();


        AccountCard expectedResult = accountCardList.get(0);

       assertEquals(expectedResult.getAccountName(),actualResultMap.get("actualAccountName"));
        assertEquals("Account: " + expectedResult.getAccountType(), actualResultMap.get("actualAccountType"));
        assertEquals("Ownership: " + expectedResult.getOwnership(), actualResultMap.get("actualOwnership"));
        assertEquals("Interest Rate: " + expectedResult.getInterestRate(), actualResultMap.get("actualInterestRate"));

        //%.2f
       String expectedBalance = String.format("%.2f", expectedResult.getBalance());
       assertEquals("Balance: $" + expectedBalance, actualResultMap.get("actualBalance"));



   //     System.out.println("///////////////////");
//
   //     System.out.println(lastAccountCard.getText());
    }

    @Then("the user should see the following transaction")
    public void the_user_should_see_the_following_transaction(List<BankTransaction> expectedtransactions) {


        Map<String, String> actualResultMap = viewCheckingAccountPage.getnewlyAddedCheckingTransactionInfoMap();
        BankTransaction expectedTransaction = expectedtransactions.get(0);


       Assertions.assertEquals(expectedTransaction.getCategory(), actualResultMap.get("actualCategory"), "Transaction category mismatched");
        //   Assertions.assertEquals(expectedTransaction.getDescription(), actualDescription, "Transaction description mismatched");
        Assertions.assertEquals(expectedTransaction.getAmount(), Double.parseDouble(actualResultMap.get("actualAmount")), "Transaction amount mismatched");
        Assertions.assertEquals(expectedTransaction.getBalance(), Double.parseDouble(actualResultMap.get("actualBalance")), "Transaction balance mismatched");



//        assertEquals(expectedTransaction.getCategory(), actualCategory,"transaction category mismatch");
//        //  assertEquals(expectedTransaction.getDescription(), actualDescription, "transaction description mismatch");
//        assertEquals(expectedTransaction.getAmount(), actualAmount, "transaction amount mismatch");
//        assertEquals(expectedTransaction.getBalance(), actualBalance, "transaction balance mismatch");
//        fail();
    }

}


