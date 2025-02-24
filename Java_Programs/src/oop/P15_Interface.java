package oop;
/*
An interface in Java is a blueprint of a class that defines abstract methods. 
It is declared using the interface keyword and is used to achieve 100% abstraction since all methods 
in an interface are abstract by default (except default and static methods).

### Characteristics of an Interface:
- Declared using interface keyword.
- Cannot have instance variables (only static and final constants allowed).
- Supports multiple inheritance: A class can implement multiple interfaces.
- All methods are public and abstract by default, except default and static methods.
- Cannot have constructors since an interface cannot be instantiated.
- A class implementing an interface must provide implementations for all its methods.

### Types of Methods in an Interface:
- Abstract Methods - Methods without a body (implicitly public and abstract).
- Default Methods - Methods with a body using the default keyword (introduced in Java 8).
- Static Methods - Methods with a body using the static keyword (introduced in Java 8). 

###
Interfaces no longer provide 100% abstraction after Java 8. However, they still enforce a strict contract 
for implementing classes, making them useful for abstraction and multiple inheritance.
*/

/*
Banking System with Interface Multiple Inheritance
Design a banking system where different bank services (Account Management, Transactions, and Interest Calculation) are handled using interfaces. Implement multiple inheritance using interfaces and demonstrate:

Defining an interface with constants and methods.
Using default and static methods.
Implementing multiple interfaces in a single class.
 */
public class P15_Interface {

	public static void main(String[] args) {
	     BankAccount_ account = new BankAccount_("Anirudha", 1000);

	     // Default method from interface
	     account.showBankRules();

	     // Static methods from interfaces
	     Banking.bankingGuidelines();
	     Transactions.transactionPolicy();

	     // Deposit and Withdraw transactions
	     account.deposit(500);
	     account.withdraw(200);
	     account.withdraw(2000); // Invalid Withdrawal

	     // Interest Calculation
	     double interest = account.calculateInterest(1300, 5);
	     System.out.println("Interest on balance: " + interest);

	     // Enable Card Security Feature
	     account.enableTwoFactorAuthentication();

	     // Close the account
	     account.closeAccount();


	}

}

//Main Banking Interface
interface Banking {
 // 1. Constant Field (public static final by default)
 double MIN_BALANCE = 500; // Minimum required balance

 // 2. Abstract Methods (Must be implemented by classes)
 void openAccount(String name, double initialDeposit);
 void closeAccount();

 // 3. Default Method (Implemented inside interface)
 default void showBankRules() {
     System.out.println("Bank Rules: Minimum balance should be " + MIN_BALANCE);
 }

 // 4. Static Method (Belongs to interface, called directly)
 static void bankingGuidelines() {
     System.out.println("Banking Guidelines: Secure transactions, regular account updates.");
 }
}

//Transactions Interface (Extends Banking)
interface Transactions extends Banking {
 void deposit(double amount);
 void withdraw(double amount);

 // 5. Private Method (Used inside the interface)
 private boolean isValidAmount(double amount) {
     return amount > 0;
 }

 // 3. Default Method using Private Method
 default boolean isTransactionValid(double amount) {
     return isValidAmount(amount);
 }

 // 4. Static Method
 static void transactionPolicy() {
     System.out.println("Transactions above 10,000 require OTP verification.");
 }
}

//Interest Interface (Separate functionality)
interface Interest {
 double calculateInterest(double balance, double rate);
}

//Nested Interface Example
interface CardServices {
 void activateCard();
 void deactivateCard();

 // 7. Nested Interface
 interface CardSecurity {
     void enableTwoFactorAuthentication();
 }
}

//Class implementing multiple interfaces
class BankAccount_ implements Transactions, Interest, CardServices.CardSecurity {
 private String accountHolder;
 private double balance;

 // Constructor
 public BankAccount_(String name, double initialDeposit) {
     openAccount(name, initialDeposit);
 }

 // Implementing Banking (From Transactions)
 @Override
 public void openAccount(String name, double initialDeposit) {
     this.accountHolder = name;
     if (initialDeposit >= MIN_BALANCE) {
         this.balance = initialDeposit;
         System.out.println("Account opened for " + name + " with balance: " + initialDeposit);
     } else {
         System.out.println("Initial deposit must be at least " + MIN_BALANCE);
     }
 }

 @Override
 public void closeAccount() {
     System.out.println("Account closed for " + accountHolder);
     this.balance = 0;
 }

 // Implementing Transactions
 @Override
 public void deposit(double amount) {
     if (isTransactionValid(amount)) {
         balance += amount;
         System.out.println("Deposited: " + amount + " | New Balance: " + balance);
     } else {
         System.out.println("Invalid deposit amount!");
     }
 }

 @Override
 public void withdraw(double amount) {
     if (isTransactionValid(amount) && balance - amount >= MIN_BALANCE) {
         balance -= amount;
         System.out.println("Withdrawn: " + amount + " | Remaining Balance: " + balance);
     } else {
         System.out.println("Invalid withdrawal! Minimum balance required: " + MIN_BALANCE);
     }
 }

 // Implementing Interest
 @Override
 public double calculateInterest(double balance, double rate) {
     return balance * rate / 100;
 }

 // Implementing Nested Interface Method (Card Security)
 @Override
 public void enableTwoFactorAuthentication() {
     System.out.println("Two-factor authentication enabled for account security.");
 }
}

