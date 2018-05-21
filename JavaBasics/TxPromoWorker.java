public class TxPromoWorker extends TxWorker {
    public TxPromoWorker(BankAccount acc, char txType, int amt) {
        super(acc, txType, amt);
    }
    
    public void run() {
        System.out.println(this.acc.currentBalance());
        if (this.txType == 'w') {
            this.acc.withdrawal(this.amt);
        } else if (this.txType == 'd') {
            synchronized(this.acc) {
                this.acc.deposit(amt);
                if (this.acc.currentBalance() > 500) {
                    this.acc.deposit((this.acc.currentBalance() - 500) * 0.1);
                }
            }
        }   
    }
}