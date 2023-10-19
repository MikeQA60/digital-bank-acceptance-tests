package co.wemiguel.digitalbank.automation.ui.pages;

import co.wemiguel.digitalbank.automation.ui.utils.MockData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import co.wemiguel.digitalbank.automation.ui.utils.MockData;

import java.util.List;
import java.util.Map;

public class RegistrationPage extends BasePage {

    //private WebDriver driver;
    //  MockData mockData = new MockData();

    public RegistrationPage(WebDriver driver) {

        super(driver);


    }

    MockData mockData = new MockData();


    @FindBy(xpath = "//img[@src ='images/logo.png']")
    private WebElement imageForRegistrationHomePage;

 // @FindBy (xpath = //img[@src = 'images/logo.png']")
 //         private WebElement imageForRegistrationHomePage;
    @FindBy(id = "title")
    private WebElement titleDropDown;

    @FindBy(id = "firstName")
    private WebElement firstNameTxt;

    @FindBy(id = "lastName")
    private WebElement lastNameTxt;

    @FindBy(xpath = "//input[@type='radio' and @value='M']")
    private WebElement genderMRadio;

    @FindBy(xpath = "//label[@for='female']//input")
    private WebElement genderFRadio;

    @FindBy(id = "dob")
    private WebElement dobTxt;

    @FindBy(id = "ssn")
    private WebElement ssnTxt;

    @FindBy(id = "emailAddress")
    private WebElement emailAddressTxt;

    @FindBy(id = "password")
    private WebElement passwordTxt;

    @FindBy(id = "confirmPassword")
    private WebElement passwordConfirmText;

    ////button[text()='Register']
    ////button[@class='btn btn-primary btn-flat m-b-30 m-t-30']
//    @FindBy(xpath = "//button[@class='btn btn-primary btn-flat m-b-30 m-t-30']")
//    private WebElement RegistrationButton;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement nextButton;

    @FindBy(id = "address")
    private WebElement addressTxt;

    @FindBy(id = "locality")
    private WebElement localityTxt;

    @FindBy(id = "region")
    private WebElement regionTxt;

    @FindBy(id = "postalCode")
    private WebElement postalCodeTxt;

    @FindBy(id = "country")
    private WebElement countryTxt;

    @FindBy(id = "homePhone")
    private WebElement homePhoneTxt;

    @FindBy(id = "mobilePhone")
    private WebElement mobilePhoneTxt;

    @FindBy(id = "workPhone")
    private WebElement workPhoneTxt;

    @FindBy(id = "agree-terms")
    private WebElement agreeTermsCheckbox;

    @FindBy(xpath = "//button[text() = 'Register']")
    private WebElement registerButton;

    @FindBy(xpath = "//div[@class='sufee-alert alert with-close alert-success alert-dismissible fade show']")
    private WebElement messageLabel;

    //      | title | firstName | lastName | gender | dateOfBirth | ssn         | email          | password    | confirmPassword | address    | locality | region | postalCode | country | mobilePhone  |
   //going into another file 100 - 241
    public void fillOutTheRegistrationPage(List<Map<String, String>> registrationPageTestDataListOfMap) {


        Select titleSelect = new Select(titleDropDown);

        Map<String, String> firstRow = registrationPageTestDataListOfMap.get(0);

        if (firstRow.get("title") != null) {
            titleSelect.selectByVisibleText(firstRow.get("title"));
        }
        if (firstRow.get("firstName") != null) {
            firstNameTxt.sendKeys(firstRow.get("firstName"));
        }
        if (firstRow.get("lastName") != null) {
            lastNameTxt.sendKeys(firstRow.get("lastName"));
        }


        if (firstRow.get("gender") != null) {
            if (firstRow.get("gender").equalsIgnoreCase("M")) {
                //   if (firstRow.get("gender").equals("M")) {
                genderMRadio.click();
            } else if (firstRow.get("gender").equalsIgnoreCase("F")) {
                //else if (firstRow.get("gender").equalsIgnoreCase("F")) {
                genderFRadio.click();
            } else {
                System.out.println("Invalid gender");
            }
        }

        if (firstRow.get("dob") != null) {
            dobTxt.sendKeys(firstRow.get("dob"));

        }

            if (firstRow.get("ssn") != null) {
                // if (firstRow.get("ssn"));
                //.equalsIgnoreCase("random")) {
                ssnTxt.sendKeys(firstRow.get("ssn"));


        }
        if (firstRow.get("email") != null) {
            // if (firstRow.get("email").equalsIgnoreCase("random")) {
//                    Map<String, String> mockNameAndEmail = mockData.generateRandomNameAndEmail();
            emailAddressTxt.sendKeys(firstRow.get("email"));

        }
        if (firstRow.get("password") != null) {
            passwordTxt.sendKeys(firstRow.get("password"));
            passwordConfirmText.sendKeys(firstRow.get("password"));
        }


        nextButton.click();


        if (addressTxt.isDisplayed()) {


            if (firstRow.get("address") != null) {
                addressTxt.sendKeys(firstRow.get("address"));
            }
        if (firstRow.get("locality") != null) {
            localityTxt.sendKeys(firstRow.get("locality"));
        }
        if (firstRow.get("region") != null) {
            regionTxt.sendKeys(firstRow.get("region"));
        }
        if (firstRow.get("postalCode") != null) {
            postalCodeTxt.sendKeys(firstRow.get("postalCode"));
        }
        if (firstRow.get("country") != null) {
            countryTxt.sendKeys(firstRow.get("country"));
        }
        if (firstRow.get("homePhone") != null) {
            homePhoneTxt.sendKeys(firstRow.get("homePhone"));
        }
        if (firstRow.get("mobilePhone") != null) {
            mobilePhoneTxt.sendKeys(firstRow.get("mobilePhone"));
        }
        if (firstRow.get("workPhone") != null) {
            workPhoneTxt.sendKeys(firstRow.get("workPhone"));
        }
        if (firstRow.get("termsCheckMark") != null) {
            if (firstRow.get("termsCheckMark").equalsIgnoreCase("true")) {
                agreeTermsCheckbox.click();
            }
        }
            registerButton.click();
        }

    }
    public String getMessage() {

        return messageLabel.getText().substring(0, messageLabel.getText().lastIndexOf(".") + 1);
    }

    public String getRequiredFieldErrorMessage(String fieldName) {

        switch (fieldName.toLowerCase()) {
            case "title":
                return titleDropDown.getAttribute("validationMessage");

            case "firstname":
                return firstNameTxt.getAttribute("validationMessage");
            case "lastname":
                return lastNameTxt.getAttribute("validationMessage");
            case "gender":
                return genderMRadio.getAttribute("validationMessage");
            case "dob":
                return dobTxt.getAttribute("validationMessage");
            case "ssn":
                return ssnTxt.getAttribute("validationMessage");
            case "email":
                return emailAddressTxt.getAttribute("validationMessage");
            case "password":
                return passwordTxt.getAttribute("validationMessage");
            case "address":
                return addressTxt.getAttribute("validationMessage");
            case "locality":
                return localityTxt.getAttribute("validationMessage");
            case "region":
                return regionTxt.getAttribute("validationMessage");
            case "postalcode":
                return postalCodeTxt.getAttribute("validationMessage");
            case "country":
                return countryTxt.getAttribute("validationMessage");
            case "homephone":
                return homePhoneTxt.getAttribute("validationMessage");
            case "mobilephone":
                return mobilePhoneTxt.getAttribute("validationMessage");
            case "workphone":
                return workPhoneTxt.getAttribute("validationMessage");
            case "termscheckmark":
                return agreeTermsCheckbox.getAttribute("validationMessage");
            default:
                return null;


        }

    }
}



