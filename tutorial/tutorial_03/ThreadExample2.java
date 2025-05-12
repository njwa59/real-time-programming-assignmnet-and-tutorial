public class ThreadExample2{
public static class MyThread extends Thread {
public void() {
sout (“MyThread Running”);
sout (“MyThread Finished”);
}
}
Public static void main (String[]) args ) {
MyThread myThread = new MyThread();
myThread.start();
}
}
