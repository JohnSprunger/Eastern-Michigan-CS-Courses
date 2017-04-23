import java.util.ArrayList;
/*****************************************************************
 Program Description:
 A bank application that handles both Checking and Savings
 accounts. It handles advance features like overdraft protection
 and accounts that garner interest.

 @author John Sprunger
 @version 1.0
 @date 09/28/2016
 @class COSC 211 - Programming Data Structures
 @assignment Machine Problem #2
 *****************************************************************/

/*****************************************************************
 The main class of the application. It creates the bank which
 handles all the users accounts.
 *****************************************************************/
public class Bank {

     /*****************************************************************
     Main method of the application, runs the created accounts
     *****************************************************************/
    public static void main(String[] args) {

        //Creating my bank account
        ArrayList<Account> johnAccount = new ArrayList<>();

        //Creating and adding my checking and savings accounts.
        CheckingAccount johnCheck = new CheckingAccount(1, true);
        SavingsAccount johnSave = new SavingsAccount(2);
        johnAccount.add(johnCheck);
        johnAccount.add(johnSave);

        //Handling transactions
        updateAccount(johnAccount, 150.0, 100.0);
        updateAccount(johnAccount, 250.0, 1.0);
        updateAccount(johnAccount, 5744.0, 800.0);
        updateAccount(johnAccount, 111.82, 564.23);
        updateAccount(johnAccount, 315.89, 777.0);
        updateAccount(johnAccount, 400.0, 387.5612);

        //Calculating interest
        johnSave.calcInterest(1);
        johnSave.calcInterest(1);

        updateAccount(johnAccount, 0.0, 0.0);
    }

    /*****************************************************************
     A method to update all accounts for a bank customer
     @param actName - The name of the customers account
     @param deposit - The amount to deposit
     @param withdraw - The amount to withdraw
     *****************************************************************/
    public static void updateAccount(ArrayList<Account> actName, double deposit, double withdraw){
        for(int i = 0; i < actName.size(); i++){
            actName.get(i).deposit(deposit);
            actName.get(i).withdraw(withdraw);
            actName.get(i).printStatement();
        }
    }
}

