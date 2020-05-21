package Domain;

import lombok.Data;

@Data
public class SavingAccount extends BankAccount {

    String type;

    public SavingAccount(){
        type="saving";
        minimumBalance=10000.0;
        interestRate=4.5;
    }

    public static SavingAccount getSavingAccount(){
        return new SavingAccount();
    }
}
