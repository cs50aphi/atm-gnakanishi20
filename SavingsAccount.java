import java.util.Scanner;
import java.util.ArrayList;

public class SavingsAccount
{
    int startSaveBalance = 0;
    int SaveBalance = 0;
    
    public int SavingsAccount()
    {
        return SaveBalance;
    }
    
    public int SavingsAccount(int pick)
    {
        startSaveBalance = pick;
        SaveBalance= startSaveBalance;
        return SaveBalance;
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
    
    public int SendSave(int move)
    {
        SaveBalance -= move;
        return SaveBalance;
    }
    
    //receiving money from savings
    public int ReceiveSave(int move)
    {
        SaveBalance += move;
        return SaveBalance;
    }
    
    public int interest()
    {
        SaveBalance *= 1.05;
        return SaveBalance;
    }
}