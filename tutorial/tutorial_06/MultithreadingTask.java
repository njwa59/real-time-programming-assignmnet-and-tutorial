package Week_06;

public class MultithreadingTask implements Runnable {
    int threadNumber;


    public MultithreadingTask(int threadNumber) {

        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + threadNumber + " * " + i + " = " + (threadNumber * i));
            try{
                Thread.sleep((long) (Math.random()*1000));
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}



