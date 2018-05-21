public class TxWorker implements Runnable {
    protected BankAccount acc;
    
    protected char txType;
    protected int amt;
    
    public TxWorker(BankAccount acc, char txType, int amt) {
        this.acc = acc;
        this.txType = txType;
        this.amt = amt;
    }
    
    @Override
    public void run() {
        if (txType == 'w') {
            acc.withdrawal(amt);
        } else if (txType == 'd') {
            acc.deposit(amt);
        }
    }
}