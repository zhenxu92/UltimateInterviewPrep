public class Worker implements Runnable {
    private BankAccount account;
    
    public Worker(BankAccount acc) {
        this.account = acc;
    }
    
    public void run() {
        for (int i = 0; i < 10; i++) {
            // protect objects: account
            synchronized(this.account) {
                this.account.deposit(10);            
            }
        }
    }
}