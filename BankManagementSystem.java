import java.util.Scanner;
import java.util.ArrayList;

class Account{
    private int accountNumber;
    private String accountHolder;
    private double deposit;
    private double balance;

    Account(int accountNumber, String accountHolder, double balance){
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber; 
        this.balance = balance;
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
        if(amount <= 0){
            System.out.println("Invalid Amount to Deposit...");
            return;
        }
        balance += amount;
        System.out.println("Money Deposited Successfully...");
        System.out.println("New Balance: " + balance);
    }

    public void Withdraw(double amount){
        if(amount <= 0){
            System.out.println("Invalid Amount to Withdraw...");
            return;
        }
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
                    createAccount(Database, input);
                break;
                case "2":
                    Deposit(Database, input);
                break;
                case "3":
                    withdraw(Database, input);
                break;
                case "4":
                    checkBalance(Database, input);
                break;
                case "5":
                    displayAccount(Database, input);
                break;
                case "6":
                    search(Database, input);
                break;
                case "7":
                    displayAccounts(Database);
                break;
                case "8":
                    delete(Database, input);
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

    public static void createAccount(ArrayList<Account> Database, Scanner input){
        System.out.println("\n\tCreate Bank Account");
        System.out.print("Enter name: ");
        String name = input.nextLine();
        System.out.print("Enter Account number(8-digits): ");
        int accountNumber1 = input.nextInt();
        input.nextLine();
        String accStr = String.valueOf(accountNumber1);
        if(!accStr.matches("\\d{8}")){
            System.out.print("Account Number must be 8 digits...");
            return;
        }
        int accountNumber = Integer.parseInt(accStr);
        for(Account s: Database){
            if(s.getNumber() == accountNumber){
                System.out.println("Account number Already exists...");
                return;
            }
        }
        

        System.out.print("Enter First Deposit: ");
        double deposit = input.nextDouble();
        //input.nextLine();
        if(deposit <= 0){
            System.out.println("Initial deposit must be greater than 0...");
            return;
        }

        Account account = new Account(accountNumber, name, deposit);
        Database.add(account);
        System.out.println("Account Created...");
        input.nextLine();

    }
    public static void Deposit(ArrayList<Account> Database, Scanner input){
        if( Database.isEmpty()){
            System.out.println("Database is empty...");
            return;
        }
        System.out.print("Enter Account Number to Deposit Into: ");
        int accountNumber = input.nextInt();
        boolean found = false;
        for(Account s: Database){
            if(accountNumber == s.getNumber()){
                System.out.print("Enter amount to Deposit: ");
                double deposit = input.nextDouble();
                s.Deposit(deposit);
                found = true;
                break;
            }
            }
            
        if(!found){
            System.out.println("Account not Found...");
           
            return;
        }
        input.nextLine();
    }
    public static void withdraw(ArrayList<Account> Database, Scanner input){
        if( Database.isEmpty()){
            System.out.println("Database is empty...");
            return;
        }
        System.out.print("Enter Account Number to Withdraw from: ");
        int accountNumber = input.nextInt();
        boolean found = false;
        for(Account s: Database){
            if(accountNumber == s.getNumber()){
                System.out.print("Enter amount to Withdraw: ");
                double withdraw = input.nextDouble();
                s.Withdraw(withdraw);
                found = true;
                break;

            }
            }
            
        if(!found){
            System.out.println("Account not Found...");
           
            return;
        }
        input.nextLine();
    }

    public static void checkBalance(ArrayList<Account> Database, Scanner input){
        if( Database.isEmpty()){
            System.out.println("Database is empty...");
            return;
        }
        System.out.print("Enter Account Number to Check Balance: ");
        int accountNumber = input.nextInt();
        input.nextLine();
        boolean found = false;
        for(Account s:Database){
            if(accountNumber == s.getNumber()){
                System.out.println("Name: " + s.getHolder());
                System.out.println("Account Number: " + s.getNumber());
                System.out.println("Balance: " + s.getBalance());
                found = true;
                break;
            }
        }

        if(!found){
            System.out.println("Account not Found...");
            return;
        }
    }

    public static void displayAccount(ArrayList<Account> Database, Scanner input){
        if( Database.isEmpty()){
            System.out.println("Database is empty...");
            return;
        }
        System.out.print("Enter Account Number to View Account: ");
        int accountNumber = input.nextInt();
        input.nextLine();
        boolean found = false;
        for(Account s:Database){
            if(accountNumber == s.getNumber()){
                System.out.println("Name: " + s.getHolder());
                System.out.println("Account Number: " + s.getNumber());
                System.out.println("Balance: " + s.getBalance());
                found = true;
                break;
            }
        }

        if(!found){
            System.out.println("Account not Found...");
            return;
        }
    }
    
    public static void search(ArrayList<Account> Database, Scanner input){
        if( Database.isEmpty()){
            System.out.println("Database is empty...");
            return;
        }
        System.out.print("Enter Account Number to Search Account: ");
        int accountNumber = input.nextInt();
        input.nextLine();
        boolean found = false;
        for(Account s:Database){
            if(accountNumber == s.getNumber()){
                System.out.println("Name: " + s.getHolder());
                System.out.println("Account Number: " + s.getNumber());
                System.out.println("Balance: " + s.getBalance());
                found = true;
                break;
            }
        }

        if(!found){
            System.out.println("Account not Found...");
            return;
        }
    }
    public static void displayAccounts(ArrayList<Account> Database){
        if( Database.isEmpty()){
            System.out.println("Database is empty...");
            return;
        }
        int num = 1;
        for(Account s: Database){
            System.out.println("Student- " + num);
            System.out.println("Name: " + s.getHolder());
            System.out.println("Account Number: " + s.getNumber());
            System.out.println("Balance: " + s.getBalance());
            num++;
        }
    } 

    public static void delete(ArrayList<Account> Database, Scanner input){
        if( Database.isEmpty()){
            System.out.println("Database is empty...");
            return;
        }
        System.out.print("Enter Account Number to delete Account: ");
        int accountNumber = input.nextInt();
        input.nextLine();

        Account accountToDelete = null;
        
        for(Account s:Database){
            if(accountNumber == s.getNumber()){
                accountToDelete = s;
                break;
            }
        }
        if(accountToDelete != null){
            Database.remove(accountToDelete);
            System.out.println("Account Deleted successfully");
        }else{
            System.out.println("Account not Found...");
            return;
        }
    }

    }

    
