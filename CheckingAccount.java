import java.util.Scanner;
import java.util.ArrayList;

public class CheckingAccount
{
    int startBalance;
    int balance;
    public CheckingAccount()
    {
        startBalance = 10;
        balance = startBalance;
    }
    
    public CheckingAccount(int pick)
    {
        startBalance = pick;
        balance = startBalance;
    }
    
    
    public int CheckingsDeposit(int take)
    {
        balance += take;
        return balance;
    }
    
    public int CheckingsWithdraw(int take)
    {
        balance -= take;
        return balance;
    }
    
    public int CheckBal()
    {
        return balance;
    }
}