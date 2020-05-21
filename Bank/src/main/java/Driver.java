import Domain.BankAccount;
import Domain.Branch;
import Domain.HeadOffice;

public class Driver {

    public static void main(String[] args) throws Exception {
        HeadOffice headOffice=new HeadOffice();
        //create a branch
        Branch branch=headOffice.createBranch();
        //create a savings account
        BankAccount savingBankAccount=branch.createBankAccount("1","Saving",40000.0);
        //deposit amount
        savingBankAccount.deposit(10000.0);

        System.out.println(savingBankAccount.getCurrentBalance());

        //will throw exception
        try{
            savingBankAccount.withdraw(550000);
        }catch (Exception e){
            System.out.println(e);
        }
        //withdraw amount
        savingBankAccount.withdraw(500);

        //Create a current account
        BankAccount currentBankAccount=branch.createBankAccount("1","current",10000.0);

        //throws an exception
        try{
            currentBankAccount.withdraw(5000);
        }
        catch (Exception e){
            System.out.println(e);
        }

        //gets the customer
        System.out.println(branch.getCustomerByPan("1"));

    }
}
