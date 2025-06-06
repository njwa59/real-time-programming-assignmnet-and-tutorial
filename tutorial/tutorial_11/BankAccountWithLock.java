package Week_9;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.Lock;

public class BankAccountWithLock {
    private double balance;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public BankAccountWithLock(double initialBalance) {
        this.balance = initialBalance;
    }

    //Read balance(shared lock)
    public double getBalance() {
        readLock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + ": reads balance " + balance);
            return balance;
        }finally{
            readLock.unlock();
        }
    }

    //Deeposit money(exclusive lock)
    public void deposit(double amount) {
        writeLock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + ": deposits " + amount);
            balance += amount;
        }finally{
            writeLock.unlock();
        }
    }

    //Withdraw money(exclusive lock)
    public void withdraw(double amount) {
        writeLock.lock();
        try{
            if(balance >= amount){
                System.out.println(Thread.currentThread().getName() + ": withdraws " + amount);
                balance -= amount;
            }else{
                System.out.println(Thread.currentThread().getName() + ": insufficient funds for " + amount);
            }
        }finally{
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        BankAccountWithLock account = new BankAccountWithLock(1000.00);

        Thread t1 = new Thread(() ->{
            account.deposit(500.00);
            account.getBalance();
        },"Thread-1");
        Thread t2 = new Thread(() ->{
            account.withdraw(200.00);
            account.getBalance();
        },"Thread-2");
        Thread t3 = new Thread(() ->{
            account.getBalance();
        },"Thread-3");
        Thread t4 = new Thread(() ->{
            account.withdraw(1500.00);
            account.getBalance();
        },"Thread-4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}


