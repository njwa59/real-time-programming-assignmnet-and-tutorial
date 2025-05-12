public class ThreadExample3 {
public static class MyRunnable implements Runnable {
@override
public void run() {
sout (“MyThread Running”);
sout (“MyThread Finished”);
}
}
Public static void main(String[] args) {
Thread thread = new Thread(new Runnable () );
Thread.start();
}
}