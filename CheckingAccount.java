import java.util.Scanner;
import java.util.ArrayList;

public class CheckingAccount
{
    int startBalance;
    int balance;
    
    //checks balance
    public int CheckingAccount()
    {
        return balance;
    }
    
    public int CheckingAccount(int pick)
    {
        startBalance = pick;
        balance = startBalance;
        return balance;
    }
    
    //code used for deposit
    public int CheckingsDeposit(int take)
    {
        balance += take;
        return balance;
    }
    
    //code used for withdraw
    public int CheckingsWithdraw(int take)
    {
        balance -= take;
        return balance;
    }
    
    //taking money from chekings to savings
    public int SendCheck(int move)
    {
        balance -= move;
        return balance;
    }
    
    //receiving money from savings
    public int ReceiveCheck(int move)
    {
        balance += move;
        return balance;
    }
}