package examples;

/*
📌 Real-Time Example of Multithreading: Online Banking System
Let's take an online banking system as a real-world scenario where multiple users perform simultaneous 
banking operations like:
1️ Checking account balance
2️ Depositing money
3️ Withdrawing money
4️ Printing account statement
Each operation runs in a separate thread to ensure faster processing and improved efficiency. 
*/
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Deposit money (synchronized to prevent race conditions)
    public synchronized void deposit(double amount) {
        System.out.println(Thread.currentThread().getName() + " depositing $" + amount);
        balance += amount;
        System.out.println("Updated Balance after deposit: $" + balance);
    }

    // Withdraw money (synchronized to prevent overdraft)
    public synchronized void withdraw(double amount) {
        if (amount > balance) {
            System.out.println(Thread.currentThread().getName() + " ❌ Insufficient balance. Withdrawal failed!");
        } else {
            System.out.println(Thread.currentThread().getName() + " withdrawing $" + amount);
            balance -= amount;
            System.out.println("Updated Balance after withdrawal: $" + balance);
        }
    }

    // Check balance
    public synchronized void checkBalance() {
        System.out.println(Thread.currentThread().getName() + " checking balance: $" + balance);
    }
}

// Deposit thread
class DepositThread extends Thread {
    private BankAccount account;
    private double amount;

    public DepositThread(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.deposit(amount);
    }
}

// Withdraw thread
class WithdrawThread extends Thread {
    private BankAccount account;
    private double amount;

    public WithdrawThread(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withdraw(amount);
    }
}

// Balance check thread
class BalanceThread extends Thread {
    private BankAccount account;

    public BalanceThread(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        account.checkBalance();
    }
}

public class OnlineBankingDemo_Thread {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount(1000); // Initial balance = $1000

        // Creating multiple threads for banking operations
        Thread t1 = new DepositThread(myAccount, 500);   // Deposit $500
        Thread t2 = new WithdrawThread(myAccount, 700); // Withdraw $700
        Thread t3 = new WithdrawThread(myAccount, 900); // Withdraw $900 (Insufficient balance)
        Thread t4 = new BalanceThread(myAccount);       // Check balance

        // Start the threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

