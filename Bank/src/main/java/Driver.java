import Domain.BankAccount;
import Domain.Branch;
import Domain.HeadOffice;

public class Driver {

    public static void main(String[] args) throws Exception {
        HeadOffice headOffice=new HeadOffice();
        //create a branch
        Branch branch=headOffice.createBranch();
        //create a savings account
        BankAccount bankAccount=branch.createBankAccount("1","Saving",40000.0);
        //deposit amount
        bankAccount.deposit(10000.0);
        System.out.println(bankAccount.getCurrentBalance());
        bankAccount.withdraw(550000);

    }
}
