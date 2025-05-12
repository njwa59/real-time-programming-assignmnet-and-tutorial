package Week_04;

public class ThreadRunnable {
//solved
    public static void main(String[] args) {
        Thread t = new Thread();
        t.start();
        System.out.println(t.getState());
    }
}
