public class BankAccount {
    private double balance;
    
    public BankAccount(double init) {
        this.balance = init;
    }
    
    public synchronized void deposit(double val) {
        this.balance += val;
    }
    
    public synchronized double currentBalance() {
        return this.balance;
    }
    
    public synchronized void withdrawal(double val) {
        this.balance -= val;
    }
}