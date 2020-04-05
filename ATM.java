import java.util.Scanner;

public class ATM
{
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        CheckingAccount checking = new CheckingAccount();
        SavingsAccount savings = new SavingsAccount();
        
        checking.CheckingAccount(10);
        savings.SavingsAccount(10);
        
        String checkBank = "d, w, c, t, q";
        boolean stop = false;
        int decision;
        int add;
        int totalCheck;
        int totalSave;
        int pick;
        int minus;
        int minusCheck;
        int minusSave;
        int choice;
        int transfer;
        int InterestCounter = 0;
        int NewBal;
       
        while(stop == false)
        {
            System.out.println("Do you want to: (D)eposit, (W)ithdraw, (C)heck Balance, (T)ransfer, (Q)uit?");
            // String inputRow = kb.nextLine();
            String name = kb.nextLine();
            String input = name.toLowerCase();
        
            //makes sure that the imput is valid
            while(!checkBank.contains(input))
            {
                System.out.println("Do you want to: (D)eposit, (W)ithdraw, (C)heck Balance, (T)ransfer, (Q)uit? Must enter either D, W, C, T, Q.");
                // String inputRow = kb.nextLine();
                name = kb.nextLine();
                input = name.toLowerCase();
            }
            
            //code to check balance in each account
            if(input.equals("c"))
            {
                int CheckBal = checking.CheckingAccount();
                int SaveBal = savings.SavingsAccount();
                System.out.println("your checking account has " + CheckBal);
                System.out.println("your savings account has " + SaveBal);
                InterestCounter++; 
            }
            
            //code to deposit in each account
            if(input.equals("d"))
            {
                System.out.println("Deposit to: (1)Checkings or (2)Savings");
                decision = kb.nextInt();
                //makes sure there is a valid input
                if(decision != 1 && decision != 2)
                {
                    System.out.println("Deposit to: (1)Checkings or (2)Savings. Must enter either 1 or 2");
                }
                
                System.out.println("How many credits do you want to deposit?");
                add = kb.nextInt();
                if(decision == 1)
                {
                    totalCheck = checking.CheckingsDeposit(add);
                    System.out.println("Your checkings account has " + totalCheck + " credits");
                    System.out.println("Your savings account has " + savings.SavingsAccount() + " credits");
                    InterestCounter++; 
                }
                else if(decision == 2)
                {
                    totalSave = savings.SaveDeposit(add);
                    System.out.println("Your checkings account has " + checking.CheckingAccount() + " credits");
                    System.out.println("Your savings account has " + totalSave + " credits");
                    InterestCounter++; 
                }
            }
            
            //code for withdrawing money from each account
            if(input.equals("w"))
            {
                System.out.println("Withdraw from: (1)Checkings or (2)Savings");
                pick = kb.nextInt();
                if(pick != 1 && pick != 2)
                {
                    System.out.println("Withdraw from: (1)Checkings or (2)Savings. Must enter either 1 or 2");
                }
                System.out.println("How many credits do you want to withdraw?");
                minus = kb.nextInt();
                
                
                if(pick == 1)
                {
                    if(minus > checking.CheckingAccount())
                    {
                        System.out.println("Insufficient funds");
                        System.out.println("Your checkings account has " + checking.CheckingAccount() + " credits");
                        System.out.println("Your savings account has " + savings.SavingsAccount() + " credits");
                        InterestCounter++; 
                    }
                    else
                    {
                        minusCheck = checking.CheckingsWithdraw(minus);
                        System.out.println("Your checkings account has " + minusCheck + " credits");
                        System.out.println("Your savings account has " + savings.SavingsAccount() + " credits");
                        InterestCounter++;  
                    }
                }
                else if(pick == 2)
                {
                    if(minus > savings.SavingsAccount())
                    {
                        System.out.println("Insufficient funds");
                        System.out.println("Your checkings account has " + checking.CheckingAccount() + " credits");
                        System.out.println("Your savings account has " + savings.SavingsAccount() + " credits");
                        InterestCounter++; 
                    }
                    else
                    {
                        minusSave = savings.SaveWithdraw(minus);
                        System.out.println("Your checkings account has " + checking.CheckingAccount() + " credits");
                        System.out.println("Your savings account has " + minusSave + " credits");
                        InterestCounter++; 
                    }
                    
                }
            }
            
            //code for a transfer
            if(input.equals("t"))
            {
                System.out.println("Transfer from: (1)Checkings to Savings or (2)Savings to Checkings.");
                choice = kb.nextInt();
                
                if(choice != 1 && choice != 2)
                {
                    System.out.println("Transfer from: (1)Checkings to Savings or (2)Savings to Checkings. Must enter either 1 or 2");
                    choice = kb.nextInt();
                }
                
                System.out.println("Amount to transfer?");
                transfer = kb.nextInt();
                
                if(choice == 1)
                {
                    if(transfer > checking.CheckingAccount())
                    {
                        System.out.println("insufficient funds");
                        InterestCounter++; 
                    }
                    else
                    {
                        System.out.println("Your checkings account has " + checking.SendCheck(transfer) + " credits");
                        System.out.println("Your savings account has " + savings.ReceiveSave(transfer) + " credits");
                        InterestCounter++; 
                    }
                }
                else if(choice == 2)
                {
                    if(transfer > savings.SavingsAccount())
                    {
                        System.out.println("insufficient funds");
                        InterestCounter++; 
                    }
                    else
                    {
                        System.out.println("Your checkings account has " + checking.ReceiveCheck(transfer) + " credits");
                        System.out.println("Your savings account has " + savings.SendSave(transfer) + " credits");
                        InterestCounter++; 
                    }
                }
            }
            
            //code for quitting 
            if(input.equals("q"))
            {
                stop = true;
            }
            
            //code that calculates the interest
            if(InterestCounter == 5)
            {
                System.out.println();
                System.out.println("interest has been calculated!");
                System.out.println("Your checkings account has " + checking.CheckingAccount() + " credits");
                System.out.println("Your savings account has " + savings.interest() + " credits");
                InterestCounter = 0;
            }
        }
    }
}