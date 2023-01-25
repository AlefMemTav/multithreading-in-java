package multithreading.threads;

import multithreading.threads.dominio.Account;

public class Thread03Account implements Runnable {

    private final Account account = new Account();

    public static void main(String[] args) {
        Thread03Account threadAccount01 = new Thread03Account();
        Thread t1 = new Thread(threadAccount01, "Hestia");
        Thread t2 = new Thread(threadAccount01, "Bell Cranel");
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            withdrawal(10);
            if (account.getBalance() < 0) {
                System.out.println("Roubando o banco");
            }
        }
    }

    private void withdrawal(int amount) {
        if (account.getBalance() >= amount) {
            System.out.println(getThreadName() + " está indo sacar dinheiro");
            account.withdrawal(amount);
            System.out.println(getThreadName() + " completou o saque, valor atual da conta " + account.getBalance());
        } else {
            System.out.println("Sem dinheiro para " + getThreadName() + " efetuar o saque " + account.getBalance());
        }
    }

    private String getThreadName() {
        return Thread.currentThread().getName();
    }

}
