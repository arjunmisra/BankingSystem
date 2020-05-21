package Domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Data
public class Customer {
    String panNumber;
    LinkedList<BankAccount> accounts=new LinkedList<>();
    public Customer(String panNumber){
     this.panNumber=panNumber;
    }

}
