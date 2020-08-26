package bankfacade;

import bankcustomers.BankAccount;
import bankcustomers.BankCustomer;
import gencustaccount.AccountIf;
import gencustaccount.CustomerIf;
import java.util.ArrayList;

import java.util.ArrayList;

public class Facade {
    public ArrayList<CustomerIf> custAccounts;

    public Facade() {
        custAccounts = new ArrayList();
        ArrayList<AccountIf> accfor1 = new ArrayList();

        AccountIf acc1 = new BankAccount(001);
        acc1.deposit(500);
        accfor1.add(acc1);

        AccountIf acc2 = new BankAccount(002);
        acc2.deposit(1000);
        accfor1.add(acc2);
        CustomerIf cust1 = new BankCustomer("John", accfor1);
        custAccounts.add(cust1);
        ArrayList<AccountIf> accfor2 = new ArrayList();

        AccountIf acc3 = new BankAccount(003);
        acc3.deposit(500);
        accfor2.add(acc3);

        AccountIf acc4 = new BankAccount(004);
        acc4.deposit(1000);
        accfor2.add(acc4);
        CustomerIf cust2 = new BankCustomer("Big", accfor2);
        custAccounts.add(cust2);


    }
    public void doDeposit(double amt, CustomerIf cust, int accNo){
        cust.getAccount(accNo).deposit(amt);
    }
    public AccountIf getBankAccount(CustomerIf cust, int accNo){
        return  cust.getAccount(accNo);
    }

    public CustomerIf getBanCustomer(String custName){
        CustomerIf account = null;
        for (int i = 0 ; i < custAccounts.size (); i++) {
            if (custAccounts.get(i).getCustomerName() == custName) {
                account = custAccounts.get(i);
                break;
            }
        }
        return account;
    }
}
