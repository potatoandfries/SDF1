import java.util.ArrayList;
import java.util.Date;
import java.util.List;

 //"final" keyword is used in different contexts. First of all, final is a non-access modifier applicable only to a variable, a method, or a class. The following are different contexts where final is used.

public class BankAccount {
    private final String accountHolderName;
    private final String accountNumber;
    private float accountBalance;
    private final List<String> transactions;
    private boolean closed;
    private final Date accountCreateDate;
    private Date accountCloseDate;

    // Constructor for creating an account with only the account holder's name
    public BankAccount(String accountHolderName) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = generateAccountNumber(); // Generate a random account number
        this.accountBalance = 0.0f; // Initialize the balance to 0
        this.transactions = new ArrayList<>(); // Initialize the transactions list
        this.closed = false; // Initially, the account is open
        this.accountCreateDate = new Date(); // Record the account creation date
    }

    // Constructor for creating an account with an initial balance
    public BankAccount(String accountHolderName, float initialBalance) {
        this(accountHolderName);
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.accountBalance = initialBalance;
    }

    // Getters for account holder's name and account number (read-only properties)
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    // Getters for account balance, transactions, closed status, account creation date, and account closing date
    public float getAccountBalance() {
        return accountBalance;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public boolean isClosed() {
        return closed;
    }

    public Date getAccountCreateDate() {
        return accountCreateDate;
    }

    public Date getAccountCloseDate() {
        return accountCloseDate;
    }

    // Method for depositing money into the account
    public void deposit(float amount) {
        if (amount <= 0 || closed) {
            throw new IllegalArgumentException("Invalid deposit amount or closed account");
        }
        accountBalance += amount;
        String transaction = "Deposit $" + amount + " at " + new Date(); // Record the transaction
        transactions.add(transaction);
    }

    // Method for withdrawing money from the account
    public void withdraw(float amount) {
        if (amount <= 0 || amount > accountBalance || closed) {
            throw new IllegalArgumentException("Invalid withdrawal amount or closed account");
        }
        accountBalance -= amount;
        String transaction = "Withdraw $" + amount + " at " + new Date(); // Record the transaction
        transactions.add(transaction);
    }

    // Method to close the account
    public void closeAccount() {
        closed = true;
        accountCloseDate = new Date(); // Record the account closing date
    }

    // Method to generate a random account number (a simple example, not recommended for production)
    private String generateAccountNumber() {
        return Integer.toString((int) (Math.random() * 1000000));
    }

    public static void main(String[] args) {
        // Example usage
        BankAccount account = new BankAccount("John Doe", 1000.0f);

        System.out.println("Account Holder: " + account.getAccountHolderName());
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Account Balance: $" + account.getAccountBalance());

        account.deposit(10.0f);
        account.withdraw(5.0f);

        System.out.println("Account Balance after transactions: $" + account.getAccountBalance());

        // Close the account
        account.closeAccount();
        System.out.println("Account Closed on: " + account.getAccountCloseDate());
    }
}