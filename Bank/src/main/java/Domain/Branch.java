package Domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static Domain.CurrentAccount.getCurrentAccount;
import static Domain.SavingAccount.getSavingAccount;

@Data
public class Branch {
    List<BankAccount> bankAccounts=new ArrayList<>();
    List<Customer> customers=new ArrayList<>();
    int branchId;

    public Branch(int branchId){
        this.branchId=branchId;
    }

    public Customer customerExists(String partNumber){
        for(Customer customer:customers){
            if(customer.getPanNumber().equals(partNumber))
                return customer;
        }
        return null;
    }
    public BankAccount createBankAccount(String panNumber, String type, Double amount){
        BankAccount bankAccount;
        if(type.equalsIgnoreCase("saving"))
            bankAccount=getSavingAccount();
        else
            bankAccount=getCurrentAccount();
        bankAccount.setCurrentBalance(amount);
        Customer customer=customerExists(panNumber);
        if(customer!=null){
            bankAccount.setAccountNumber(customer.getAccounts().getLast().accountNumber+1);
            bankAccounts.add(bankAccount);
            customer.getAccounts().add(bankAccount);
        }
        else{
            Customer newCustomer=new Customer(panNumber);
            newCustomer.getAccounts().add(bankAccount);
            bankAccounts.add(bankAccount);
            customers.add(newCustomer);

        }
        return bankAccount;
    }

    public Customer getCustomerByPan(String panNumber) throws Exception {
        Customer customer=customerExists(panNumber);
        if(customer!=null)
            return customer;
        throw new Exception("Customer does not exist with the pan "+panNumber);

    }

    public BankAccount getAccountByAccountNumber(int accountNumber) throws Exception {
        for(BankAccount account:bankAccounts){
            if(account.getAccountNumber()==accountNumber)
                return account;
        }
        throw new Exception("Bank Account does not exist with the account number "+accountNumber);
    }
}
