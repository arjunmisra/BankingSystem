package Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class BankAccount {
    int accountNumber=0;
    Double minimumBalance;
    Double currentBalance=0.0;
    Double interestRate;
    List<Transaction> transactions=new LinkedList<>();

    public double withdraw(double amount) throws Exception {
        Transaction transaction;
        if(currentBalance-amount<minimumBalance)
            throw new Exception("Cannot withdraw. Minimum Balance not maintained");

        currentBalance=currentBalance-amount;
        if(transactions.size()==0)
            transaction=new Transaction(1,amount,"withdraw");
        else{
            transaction=new Transaction(transactions.get(transactions.size()-1).getTransactionId()+1,amount,"withdraw");
        }
        transactions.add(transaction);
        return amount;
    }

    public double deposit(double amount) throws Exception {
        Transaction transaction;
        if(amount<0.0)
            throw new Exception("Cannot deposit. Invalid deposit amount");

        currentBalance=currentBalance+amount;
        if(transactions.size()==0)
            transaction=new Transaction(1,amount,"deposit");
        else{
            transaction=new Transaction(transactions.get(transactions.size()-1).getTransactionId()+1,amount,"deposit");
        }
        transactions.add(transaction);
        return amount;
    }

    public List<Transaction> getTransactionHistory(){
        return transactions;
    }

    public List<Transaction> getMiniStatement(){
        if(transactions.size()<=10)
            return transactions;
        return transactions.subList(transactions.size()-10,transactions.size());
    }
}
