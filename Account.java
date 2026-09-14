

import java.util.ArrayList;

public class Account{
    private int accountNumber;
    private String accountHolder;
    private double balance;

    private ArrayList<String> history = new ArrayList<>();

    Account(int accountNumber, String accountHolder, double balance){
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber; 
        this.balance = balance;
        history.add("Balance: " + balance);
     
       
    }
    public int getNumber(){
        return accountNumber;
    }

    public String getHolder(){
        return accountHolder;
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
        
        history.add("Deposit: " + amount);
        System.out.println("Transaction Successfully...");
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
        history.add("Withdraw: " + amount);
        System.out.println("Transaction Successfully...");
        System.out.println("New Balance: " + balance);
    }
 
    public void History(){
       System.out.println("Transaction History");
        for(String trans: history){
            System.out.println(trans);
        }
    }
}