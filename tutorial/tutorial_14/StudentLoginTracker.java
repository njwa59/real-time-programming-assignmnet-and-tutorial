package Week_13;

import java.util.concurrent.ConcurrentHashMap;

public class StudentLoginTracker {

    private static ConcurrentHashMap<String, Integer> studentLogins = new ConcurrentHashMap<>();

    public static void trackLogin(String studentId) {
        studentLogins.compute(studentId, (id, count) -> (count == null) ? 1 : count + 1);
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable loginStudent123 = () -> {
            for (int i = 0; i < 5; i++) {
                trackLogin("student123");
            }
        };

        Runnable loginStudent456 = () -> {
            for (int i = 0; i < 5; i++) {
                trackLogin("student456");
            }
        };

        Thread thread1 = new Thread(loginStudent123);
        Thread thread2 = new Thread(loginStudent456);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Logins for student123: " + studentLogins.get("student123"));
        System.out.println("Logins for student456: " + studentLogins.get("student456"));
    }
}
