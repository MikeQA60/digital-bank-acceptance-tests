package co.wemiguel.digitalbank.automation.ui.steps;

import io.cucumber.java.*;
import co.wemiguel.digitalbank.automation.ui.utils.DBUtils;
import co.wemiguel.digitalbank.automation.ui.utils.Driver;


import java.util.concurrent.TimeUnit;

import static co.wemiguel.digitalbank.automation.ui.utils.Driver.getDriver;

public class Hooks {

//    @Before("@Registration")
//
//    public static void establishConnectionToDB() {
//        DBUtils.establishConnection();
//    }
//    @Before("not @Registration")
//    public void the_user_is_on_dbank_homepage() {
//
//      //  getDriver().get("https://dbank-qa.wedevx.co/bank/login");
//        getDriver().get("https://dbank-qa.wedevx.co/bank/login");
//
//    }
//
//    @Before()
//
//    public void clearTheDBForRegistration(Scenario scenario) {
//       // getDriver().get("https://dbank-qa.wedevx.co/bank/login");
//        DBUtils.establishConnection();
//       // DBUtils.runSQLUpdateQuery("DELETE FROM user_profile where email_address = '" + scenario. ")
//    }
//    @After("not @NegativeRegistrationCases")
//    public void afterScenario(Scenario scenario) {
////        Driver.takeScreenShot(scenario);
////        Driver.closeDriver();
//
//
//    }
//
//    @After()
//    public static void closeConnectionToDB() {
//
//        DBUtils.closeConnection();


    @Before("not @Registration")
    public void url() {
        getDriver().get("http://miguel.mydevx.com/bank");

    }
   @Before("@Registration")
    public void establishConnectionTODB() {
       DBUtils.establishConnection();


    }

    @After("@Registration")
    public void closeConnectionTODB() {
        DBUtils.closeConnection();
    }
}
