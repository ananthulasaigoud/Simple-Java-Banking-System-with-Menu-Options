import java.util.Scanner;
public class ClassObjExample {
     static String Name = "Sai";
     static long AccountNumber = 5234235453l;
    static double Balance = 5000;
    static boolean continueStatus = true;
  
    void getBalance(){
        System.out.println("Your balance was "+Balance);
        System.out.println("---------------------------------");
    }

    void deposit(double depositAmount){
        Balance+=depositAmount;
        System.out.println(depositAmount+" was succuessfully deposited");
        System.out.println("---------------------------------");
    }

    void WithdrawAmount(double WithdrawAmount){
        Balance-=WithdrawAmount;
        System.out.println(WithdrawAmount+" was succuessfully withdrawed");
        System.out.println("---------------------------------");
    }

    void displayAccountInfo(){
        System.out.println("Accountant name :"+Name);
        System.out.println("Account Number "+AccountNumber);
        System.out.println("Available Balance :"+Balance);
        System.out.println("---------------------------------");
    }
    
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    while (continueStatus) { 
        System.out.println("1.Display account details");
        System.out.println("2.Deposit");
        System.out.println("3.Withdrawl");
        System.out.println("4.Show balance");
        System.out.println("5.Exit");
        System.out.print("Please select the any one option:");
        int Input = sc.nextInt();

        ClassObjExample ce = new ClassObjExample();
        boolean loopStop = false;

        switch (Input) {
            case 1:
                ce.displayAccountInfo();
                break;
            case 2:
                System.out.print("Enter the deposit amount: ");
                double depositAmount = sc.nextDouble();
                ce.deposit(depositAmount);
                break;
            case 3:
                System.out.print("Enter the withdrawal amount: ");
                double withdrawalAmount = sc.nextDouble();
                if (withdrawalAmount > ce.Balance) {
                    System.out.println("Insufficient balance");
                } else {
                    ce.WithdrawAmount(withdrawalAmount);
                }
                break;
            case 4:
                ce.getBalance();
                break; 
                
            case 5:
                System.out.println("Exiting. Have a great day!");
                loopStop = true;
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option (1-6).");
        
    }
    if(loopStop==true){
        break;
    }else{
            System.out.println("Do you want to continue(y/n)");
            char ContinueOrNot = Character.toLowerCase(sc.next().charAt(0));
            if(ContinueOrNot=='y'){
                continueStatus=true;
            }else{
                continueStatus=false;
            }
    }

}

}
}
