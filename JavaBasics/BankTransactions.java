import java.util.*;
import java.util.concurrent.*;
public class BankTransactions {
    public static void main(String args[]) {
        ExecutorService es = Executors.newFixedThreadPool(5);
        TxWorker[] workers = new TxPromoWorker[10];
        BankAccount acc = new BankAccount(500);
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new TxPromoWorker(acc, 'd', 100);
        }
        
        for (TxWorker worker : workers) {
            es.submit(worker);
        }
        System.out.println(acc.currentBalance());
    }
}