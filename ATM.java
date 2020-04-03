import java.util.Scanner;

public class ATM
{
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        CheckingAccount checking = new CheckingAccount();
        SavingsAccount savings = new SavingsAccount();
        String checkBank = "d, w, c, t, q";
        boolean stop = false;
        int decision;
        int add;
        int totalCheck;
        int totalSave;
        int pick;
        int minusCheck;
        int minusSave;
        int choice;
        int transfer;
        int InterestCounter;
        int NewBal;
       
        while(stop == false)
        {
            System.out.println("Do you want to: (D)eposit, (W)ithdraw, (C)heck Balance, (T)ransfer, (Q)uit?");
            // String inputRow = kb.nextLine();
            String name = kb.nextLine();
            String input = name.toLowerCase();
        
            while(!checkBank.contains(input))
            {
                System.out.println("Do you want to: (D)eposit, (W)ithdraw, (C)heck Balance, (T)ransfer, (Q)uit? Must enter either D, W, C, T, Q.");
                // String inputRow = kb.nextLine();
                name = kb.nextLine();
                input = name.toLowerCase();
            }
            
            if(input.equals("c"))
            {
                System.out.println("your checking account has" + balance);
                System.out.println("your savings account has" + SaveBalance);
                InterestCounter++; 
            }
            
            if(input.equals("d"))
            {
                System.out.println("Deposit to: (1)Checkings or (2)Savings");
                decision = kb.nextInt();
                if(decision != 1 || decision != 2)
                {
                    System.out.println("Deposit to: (1)Checkings or (2)Savings. Must enter either 1 or 2");
                }
                System.out.println("How many credits do you want to deposit?");
                add = kb.nextInt();
                if(decision == 1)
                {
                    totalCheck = CheckingsDeposit(add);
                    System.out.println("Your checkings account has" + totalCheck + "credits");
                    System.out.println("Your savings account has" + SaveBalance + "credits");
                    InterestCounter++; 
                }
                else
                {
                    totalSave = SavingsDeposit(add);
                    System.out.println("Your checkings account has" + balance + "credits");
                    System.out.println("Your savings account has" + totalSave + "credits");
                    InterestCounter++; 
                }
            }
            
            if(input.equals("w"))
            {
                System.out.println("Withdraw from: (1)Checkings or (2)Savings");
                pick = kb.nextInt();
                if(pick != 1 || pick != 2)
                {
                    System.out.println("Withdraw from: (1)Checkings or (2)Savings. Must enter either 1 or 2");
                }
                System.out.println("How many credits do you want to withdraw?");
                minus = kb.nextInt();
                
                
                if(pick == 1)
                {
                    if(minus > balance)
                    {
                        System.out.println("Insufficient funds");
                        System.out.println("Your checkings account has" + balance + "credits");
                        System.out.println("Your savings account has" + SaveBalance + "credits");
                        InterestCounter++; 
                    }
                    else
                    {
                        minusCheck = CheckingsWithdraw(minus);
                        System.out.println("Your checkings account has" + minusCheck + "credits");
                        System.out.println("Your savings account has" + SaveBalance + "credits");
                        InterestCounter++;  
                    }
                }
                else
                {
                    if(minus > SaveBalance)
                    {
                        System.out.println("Insufficient funds");
                        System.out.println("Your checkings account has" + balance + "credits");
                        System.out.println("Your savings account has" + SaveBalance + "credits");
                        InterestCounter++; 
                    }
                    else
                    {
                        minusSave = SavingsWithdraw(minus);
                        System.out.println("Your checkings account has" + balance + "credits");
                        System.out.println("Your savings account has" + minusSave + "credits");
                        InterestCounter++; 
                    }
                    
                }
            }
            
            if(input.equals("t"))
            {
                System.out.println("Transfer from: (1)Checkings to Savings or (2)Savings to Checkings.");
                choice = kb.nextInt();
                
                if(choice != 1 || choice != 2)
                {
                    System.out.println("Transfer from: (1)Checkings to Savings or (2)Savings to Checkings. Must enter either 1 or 2");
                    choice = kb.nextInt();
                }
                
                System.out.println("Amount to transfer?");
                transfer = kb.nextInt();
                
                if(choice == 1)
                {
                    balance -= transfer;
                    SaveBalance += transfer;
                    System.out.println("Your checkings account has" + balance + "credits");
                    System.out.println("Your savings account has" + SaveBalance + "credits");
                    InterestCounter++; 
                }
                else
                {
                    SaveBalance -= transfer;
                    balance += transfer;
                    System.out.println("Your checkings account has" + balance + "credits");
                    System.out.println("Your savings account has" + SaveBalance + "credits");
                    InterestCounter++; 
                }
            }
            
            if(input.equals("q"))
            {
                stop = true;
            }
            
            if(InterestCounter == 5)
            {
                NewBal = SaveBal * 1.05;
                System.out.println("Your checkings account has" + balance + "credits");
                System.out.println("Your savings account has" + NewBal + "credits");
                InterestCounter = 0;
            }
        }
    }
}