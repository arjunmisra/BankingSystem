package Domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CurrentAccount extends BankAccount {
    String type;

    public CurrentAccount(){
        type="current";
        minimumBalance=20000.0;
        interestRate=0.0;
    }

    public static CurrentAccount getCurrentAccount(){
        return new CurrentAccount();
    }

}
