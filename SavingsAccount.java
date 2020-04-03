import java.util.Scanner;
import java.util.ArrayList;

public class SavingsAccount
{
    int startSaveBalance;
    int SaveBalance;
    public SavingsAccount()
    {
        startSaveBalance = 10;
        SaveBalance = startSaveBalance;
    }
    
    public SavingsAccount(int pick)
    {
        startSaveBalance = pick;
        SaveBalance= startSaveBalance;
    }
    
    
    public int SaveWithdraw(int take)
    {
        SaveBalance -= take;
        return SaveBalance;
    }
    
    public int SaveDeposit(int take)
    {
        SaveBalance += take;
        return SaveBalance;
    }
    
    public int CheckBalSave()
    {
        return SaveBalance;
    }
}