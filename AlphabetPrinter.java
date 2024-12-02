package lab5;

import java.util.Random;

public class AlphabetPrinter {
    public static void main(String[] args) {
        // Create a new thread to handle the printing
        Thread alphabetThread = new Thread(new Runnable() {
            public void run() {
                // Loop to print 26 letters (A to Z)
                for (char letter = 'A'; letter <= 'Z'; letter++) {
                    // Random sleep time between 100 and 1000 milliseconds (0.1s to 1s)
                    try {
                        int randomSleepTime = (int)(Math.random() * 900) + 100;
                        Thread.sleep(randomSleepTime);  // Sleep for a random time
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // Print the current letter
                    System.out.print(letter + " ");
                }
                // End the loop and the thread
                System.out.println();
            }
        });

        // Start the thread
        alphabetThread.start();
        
        try {
            // Ensure the main thread waits until the alphabetThread finishes
            alphabetThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
