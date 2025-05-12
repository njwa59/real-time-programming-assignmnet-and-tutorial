package Assignment;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class JavaFileCounter {

    public static void main(String[] args) {

        String folderPath = getValidFolderPath();

        File folder = new File(folderPath);
        int javaFileCount = 0;
        int issueFileCount = 0;

        File[] files = folder.listFiles();

        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                File file = files[i];
                if (file.getName().endsWith(".java")) {
                    javaFileCount++;
                    if (containsSolvedKeyword(file)) {
                        issueFileCount++;
                    }
                }
            }

            if (javaFileCount == 0) {
                System.out.println("No java files in this folder.Please use other folder path.");
            } else {
                System.out.println("Number of java files = " + javaFileCount);
                System.out.println("Number of issues = " + issueFileCount);
            }
        } else {
            System.out.println("Invalid folder path: " + folderPath + "\nPlease check the folder path and try again");
        }
    }

    private static String getValidFolderPath() {
        String folderPath;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the folder path: ");
            folderPath = scanner.nextLine();
            File folder = new File(folderPath);
            if (folder.exists() && folder.isDirectory()) {
                return folderPath;
            } else {
                System.out.println("Invalid folder path.Please try again");
            }
        }

    }

    private static boolean containsSolvedKeyword(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("solved")) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + file.getName());
        }

        return false;
    }

}

