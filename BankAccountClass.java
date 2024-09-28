import java.util.Scanner;

public class BankAccountClass {
    String HolderName;
    int AccountNumber;
    int Balance = 0;
    static Scanner sc = new Scanner(System.in);

    // Constructor to initialize the data
    BankAccountClass(String HolderName, int AccountNumber, int balance) {
        this.HolderName = HolderName;
        this.AccountNumber = AccountNumber;
        this.Balance = balance;
    }

    // Method to print the account details
    void PrintstatementDetails() {
        System.out.println("Name: " + HolderName + "\nAccountNumber: " + AccountNumber + "\nBalance: " + Balance);
    }

    // Method to deposit money
    void DepositMoney() {
        System.out.println("Enter the deposit amount:");
        int deposit = sc.nextInt();
        if (deposit <= 0) {
            System.err.print("Please enter a valid amount.");
        } else {
            Balance = Balance + deposit;
            System.out.println("Deposit Amount: " + deposit);
        }
    }

    // Method to withdraw money
    void WithdrawalMoney() {
        System.out.print("Enter the withdrawal amount:");
        int withdrawal = sc.nextInt();
        if (withdrawal <= 0) {
            System.err.println("Please enter a valid amount.");
        } else if (Balance < withdrawal) {
            System.err.println("Insufficient balance.");
        } else {
            Balance = Balance - withdrawal;
            System.out.println("Withdrawal Amount: " + withdrawal);
        }
    }

    // Method to check balance
    void CheckBalance() {
        System.out.println("Available Balance: " + Balance);
    }
    int Getaccount(){
        return AccountNumber;
    }

    // Main method
    public static void main(String[] args) {
        
        BankAccountClass BAC = new BankAccountClass("Sai", 101, 100);
        BankAccountClass BAC1 = new BankAccountClass("Shiva", 102, 200);
        BankAccountClass BAC2 = new BankAccountClass("Swamy", 103, 300);
        BankAccountClass BAC3 = new BankAccountClass("Skylab", 104, 400);
        
        BankAccountClass[] accounts={BAC,BAC1,BAC2,BAC3};
        
        for(BankAccountClass account:accounts){
            System.out.println(account.Getaccount());
        }
            
        boolean WhileCondition = true;
        while (WhileCondition) {
            
            System.out.println("please select account number(101 - "+(100+accounts.length)+"):");
            int accountChoice = sc.nextInt();
            
            BankAccountClass selectedAccount=null;
            
            for(BankAccountClass account:accounts){
                if(account.Getaccount()==accountChoice){
                    selectedAccount=account;
                    break;
                }
            }
            // for(BankAccountClass )
           switch(accountChoice){
               case 1:selectedAccount=BAC;break;
               case 2:selectedAccount=BAC1;break;
               case 3:selectedAccount=BAC2;break;
               case 4:selectedAccount=BAC3;break;
           }
           if (selectedAccount == null) {
            System.err.println("Invalid account number. Please try again.");
            continue;
        }

            System.out.println("1. Check Balance\n2. Deposit\n3. Withdrawal\n4. Print Statement\n5. Exit");
            System.out.print("Enter the Input: ");
            int InputValue = sc.nextInt();

            switch (InputValue) {
                case 1:
                    selectedAccount.CheckBalance();
                    break;
                case 2:
                    selectedAccount.DepositMoney();
                    break;
                case 3:
                    selectedAccount.WithdrawalMoney();
                    break;
                case 4:
                    selectedAccount.PrintstatementDetails();
                    break;
                case 5:
                    WhileCondition = false;
                    break;
                default:
                    System.out.println("Please enter a correct input.");
            }

            if (!WhileCondition) {
                System.out.println("Thank you");
            }

            System.out.println("-----------------------");
        }

        sc.close();
    }
}
