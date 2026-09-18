import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

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
                    transactionHistory(Database, input);
                break;
                case "10":
                    transfer(Database, input);
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

        if(!name.matches("[a-zA-Z]+")){
            System.out.println("Name must contain letters Only..");
            return;
        }
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
            System.out.println("\tAccount-" + num);
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
    public static void transactionHistory(ArrayList<Account> Database, Scanner input){
        if( Database.isEmpty()){
            System.out.println("Database is empty...");
            return;
        }
        System.out.print("Enter Account Number to Check History");
        int accountNumber = input.nextInt();
        input.nextLine();
        boolean found = false;
        for(Account s:Database){
            if(accountNumber == s.getNumber()){
                s.History();
                found = true;
                break;
            }
        }

        if(!found){
            System.out.print("Account not found...");
            return;
        }
    }
    public static void transfer(ArrayList<Account> Database, Scanner input){
        if(Database.isEmpty()){
            System.out.println("Database is Empty...");
            return;
        }
        try{
            System.out.print("Enter Sender Account Number: ");
            int senderAccount = input.nextInt();
            input.nextLine();

            System.out.print("Enter Receiver Account Number: ");
            int receiverAccount = input.nextInt();
            input.nextLine();

            
        Account sender = null;
        Account receiver = null;
        for(Account s:Database){
            if(senderAccount == s.getNumber()){
                sender = s;
            }
            if(receiverAccount == s.getNumber()){
                receiver = s;
            }
        }

        if(sender == null){
            System.out.println("Sender Account not Found....");
            return;
        }
        if(receiver == null){
            System.out.println("Receiver Account not Found....");
            return;
        }
        if(sender == receiver){
            System.out.println("Same Account, Invalid Transaction...");
            return;
        }

            try{
                
        System.out.print("Enter Amount to Transfer: ");
        double amount = input.nextDouble();
        //input.close();
        if(amount <= 0){
            System.out.println("Invalid Amount....");
            return;
        }
        if(amount > sender.getBalance()){
            System.out.println("Insufficient Amount...");
            return;
        }
        sender.Withdraw(amount);
        receiver.Deposit(amount);
        System.out.println("Transaction Complete...");

        input.nextLine();
            }catch(InputMismatchException e){
                System.out.println("Invalid Input. Please enter a Valid amount");
                input.nextLine();
            }

        }catch(InputMismatchException e){
            System.out.println("Invalid Input. Please enter a Valid account number");
            input.nextLine();
        }

        

    }

    }

    
