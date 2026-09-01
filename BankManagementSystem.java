
import java.util.Scanner;
import java.util.ArrayList;

class Account{
    private int accountNumber;
    private String accountHolder;
    private double deposit;
    private double balance;

    Account(int accountNumber, String accountHolder, double deposit, double balance){
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber; 
        this.balance = deposit;
    }
    public int getNumber(){
        return accountNumber;
    }

    public String getHolder(){
        return accountHolder;
    }

    public double getDeposit(){
        return deposit;
    }
    public double getBalance(){
        return balance;
    }

    public void Deposit(double amount){
        if(amount < 0){
            System.out.println("Invalid Amount to Deposit...");
            return;
        }
        balance += amount;
        System.out.println("Money Deposited Successfully...");
        System.out.println("New Balance: " + balance);
    }

    public void Withdraw(double amount){
        if(amount > balance){
            System.out.println("Insufficient Funds to make Withdraw...");
            return;
        }
        balance -= amount;
        System.out.println("Money Withdrawn Successfully...");
        System.out.println("New Balance: " + balance);
    }
}

public class BankManagementSystem {
    public static void main(String [] args){
        ArrayList<Account> Database = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        boolean running = true;
        while(running){
            System.out.println("\t\nBANK ACCOUNT MANAGEMENT SYSTEM");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Display Account");
            System.out.println("6. Search Account");
            System.out.println("7. Display All Accounts");
            System.out.println("8. Delete Account");
            System.out.println("9. Transaction History");
            System.out.println("10.Transfer Money");
            System.out.println("11. Exit");

            System.out.print("Enter Option: ");
            String choice = input.nextLine();

            switch(choice){
                case "1":

                break;
                case "2":

                break;
                case "3":

                break;
                case "4":

                break;
                case "5":

                break;
                case "6":

                break;
                case "7":

                break;
                case "8":

                break;
                case "9":

                break;
                case "10":

                break;
                case "11":
                    running = false;
                    System.out.println("Exiting...");

                break;
                default:
                    System.out.println("Inavlid Option...");
            }
        }    
    }
}
