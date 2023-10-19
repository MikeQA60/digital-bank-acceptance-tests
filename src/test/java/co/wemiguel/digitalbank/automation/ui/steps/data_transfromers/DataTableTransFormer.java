package co.wemiguel.digitalbank.automation.ui.steps.data_transfromers;

import co.wemiguel.digitalbank.automation.ui.models.AccountCard;
import co.wemiguel.digitalbank.automation.ui.models.BankTransaction;
import co.wemiguel.digitalbank.automation.ui.models.NewCheckingAccountInfo;
import co.wemiguel.digitalbank.automation.ui.models.ProfileInfo;
import io.cucumber.java.DataTableType;


import java.util.Map;

public class DataTableTransFormer {



    @DataTableType
    public AccountCard accountCardEntry(Map<String, String> entry) {
        String accountName = entry.get("accountName");
        String accountType = entry.get("accountType");
        String ownership = entry.get("ownership");
        long accountNumber = Long.parseLong(entry.get("accountNumber"));
        String interestRate = entry.get("interestRate ");
        double balance = Double.parseDouble(entry.get("balance"));


        return new AccountCard(accountName, accountType, ownership, accountNumber, interestRate, balance);

    }

    @DataTableType
    public BankTransaction transactionEntry(Map<String, String> entry) {
        String date = entry.get("date");
        String category = entry.get("category");
        String description = entry.get("description");
        double amount = Double.parseDouble(entry.get("amount"));
        double balance = Double.parseDouble(entry.get("balance"));

        return new BankTransaction(date,category,description,amount,balance);

    }

    @DataTableType
    public NewCheckingAccountInfo newCheckingAccountInfoEntry(Map<String, String> entry) {
        String checkingAccountType = entry.get("checkingAccountType");
        String ownership = entry.get("accountOwnership");
        String accountName = entry.get("accountName");
        double initialDepositAmount = Double.parseDouble(entry.get("initialDepositAmount"));


        return new NewCheckingAccountInfo(checkingAccountType,ownership,accountName,initialDepositAmount);

    }

    @DataTableType
    public ProfileInfo profileInfoEntry(Map<String, String> entry) {
        String title = entry.get("title");
        String firstName = entry.get("firstName");
         String lastName = entry.get("lastName");
         String homePhone= entry.get("homePhone");
         String mobilePhone = entry.get("mobilePhone");
         String workPhone = entry.get("workPhone");
         String address = entry.get("address");
         String postalCode = entry.get("postalCode");
         String region = entry.get("region");
         String locality = entry.get("locality");
         String country = entry.get("country");

         return new ProfileInfo(title,firstName, lastName, homePhone, mobilePhone, workPhone, address, postalCode, region, locality,country);







    }
}
