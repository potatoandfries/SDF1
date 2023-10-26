public class FixedDepositAccount extends BankAccount {
    private float interest;
    private int durInMonths;

    // Constructor with default values
    public FixedDepositAccount(String accountHolderName, float accountBalance) {
        this(accountHolderName, accountBalance, 0.03f, 6); // Default interest (3%) and duration (6 months)
    }

    // Constructor with custom interest and duration
    public FixedDepositAccount(String accountHolderName, float accountBalance, float interest, int durInMonths) {
        super(accountHolderName, accountBalance);
        this.interest = interest;
        this.durInMonths = durInMonths;
    }

    public float getInterest() {
        return interest;
    }

    public int getDurationInMonths() {
        return durInMonths;
    }

    public void withdraw(float amount) {
        // No operation (NOP)
    }

    public void deposit(float amount) {
        // No operation (NOP)
    }

    public static void main(String[] args) {
        FixedDepositAccount fDepositAccount = new FixedDepositAccount("John Doe", 1000.0f,0.04f,12);

        System.out.println("Account Holder: " + fDepositAccount.getAccountHolderName());
        System.out.println("Account Number: " + fDepositAccount.getAccountNumber());
        System.out.println("Account Balance: $" + fDepositAccount.getAccountBalance());
        System.out.println("Interest Rate: " + fDepositAccount.getInterest() * 100 + "%");
        System.out.println("Duration (Months): " + fDepositAccount.getDurationInMonths());

        fDepositAccount.deposit(10.0f);
        fDepositAccount.withdraw(5.0f);

        System.out.println("Account Balance after transactions: $" + fDepositAccount.getAccountBalance());

        // Close the account
        fDepositAccount.closeAccount();
        System.out.println("Account Closed on: " + fDepositAccount.getAccountCloseDate());
    }
}
