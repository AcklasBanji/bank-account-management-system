
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
    
}
