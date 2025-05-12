package Week_04;

public class ThreadStatesInJava {
//solved
    public static void main(String[] args) {
        Thread.State[] states = Thread.State.values();
        for (int i = 0; i < states.length; i++) {
            for(Thread.State state: states) {
            System.out.println(state);
            }
        }
    }
}
