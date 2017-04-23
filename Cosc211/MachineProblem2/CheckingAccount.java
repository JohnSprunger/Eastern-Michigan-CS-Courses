import java.text.NumberFormat;
/*****************************************************************
 The CheckingAccount class handles the speciality checking account
 It handles overdraft protection on account that are applicable
 *****************************************************************/
public class CheckingAccount extends Account{

    /** Whether or not the account has overdraft protection */
    private boolean overDraft;

    /** The amount the customer is able to overdraft */
    private double draftLimit;

    /*****************************************************************
     A constructor to create the checking account
     @param num - handles the superclasses constructor
     @param hasProtection - whether or not an account has overdraft
     *****************************************************************/
    public CheckingAccount(int num, boolean hasProtection){
        super(num);
        overDraft = hasProtection;
        setLimit(200.0);
    }

    /*****************************************************************
     A method to set the overdraft limit
     @param limit - the overdraft limit
     *****************************************************************/
    public void setLimit(double limit){
        if(overDraft){
            draftLimit = (getBalance() + limit);
        }
        else{
            draftLimit = 0.0;
        }
    }

    @Override
    /*****************************************************************
     A method to withdraw funds from the checking account
     @param amt - amount to withdraw
     *****************************************************************/
    public void withdraw (double amt){
        //Nested if statement to make sure the customer can withdraw
        if(amt > 0.0){
            //Amount has to be greater than current balance
            if(amt <= getBalance()){
                setBalance((getBalance() - amt));
            }
            //or greater than the customers overdraft limit
            else if(draftLimit > amt){
                setBalance((getBalance() - amt));
            }
            //else he will not be able to withdraw funds
            else{
                System.out.println("You do not have sufficient funds");
            }
        }
    }

    @Override
    /*****************************************************************
     A method to print the statement from the checking account
     *****************************************************************/
    public void printStatement() {
        //Formats numbers into proper currency output
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String moneyString = formatter.format(getBalance());

        //Output statement
        System.out.println("Savings Account: " + getAcctNum() +
                " has a balance of " + moneyString);
    }
}

