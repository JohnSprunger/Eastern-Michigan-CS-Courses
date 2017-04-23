import java.text.NumberFormat;
/*****************************************************************
 The SavingsAccount class handles the speciality savings account
 It handles calculating interest
 *****************************************************************/
public class SavingsAccount extends Account {

    /** The percentage of interest the account draws per day */
    private double intrestPer;

    /** The number of days the account has had money in it */
    private int numDays;

    /*****************************************************************
     A constructor for the Savings Account
     @param num - handles the super class parameters
     *****************************************************************/
    public SavingsAccount(int num){
        super(num);
        intrestPer = 1.04863;
        numDays = 0;
    }

    /*****************************************************************
     A method to calculate interest
     @param numDays - The number of days that interest is being added
     *****************************************************************/
    public void calcInterest(double numDays){
        double amount = getBalance();
        amount = amount * (intrestPer * numDays);
        setBalance(amount);
    }

    @Override
    /*****************************************************************
     A method to print the statement from the Savings Account
     *****************************************************************/
    public void printStatement(){
        //Formats numbers into proper currency output
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String moneyString = formatter.format(getBalance());

        //Output statement
        System.out.println("Savings Account: " + getAcctNum() +
                " has a balance of " + moneyString);
    }
}

