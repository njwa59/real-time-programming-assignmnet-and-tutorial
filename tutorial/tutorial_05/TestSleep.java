package Week_06;

public class TestSleep extends Thread {
    public void run() {
        try{
            for(int i=1; i<=20; i++){
                System.out.println("ONE");
                Thread.sleep(1000);
                System.out.println("TWO");
                Thread.sleep(1000);
                System.out.println("THREE");
                Thread.sleep(1000);
                System.out.println("XXXXXXXXXX");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main (String[] args) {
        TestSleep t = new TestSleep();
        t.start();
    }

}
