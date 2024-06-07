import java.util.concurrent.Semaphore;

public class Main {
    static int sum = 0;

    public static void main(String[] args) {
        Counter[] counterThreads = new Counter[10]; // Creating an array of 10 threads
        Semaphore mutex = new Semaphore(1); // Creating a mutex

        for (int i = 0; i < 10; i++) { // Creating 10 threads
            counterThreads[i] = new Counter(mutex); // Passing the mutex to the thread
            counterThreads[i].start(); // Starting the thread
        }

        for (int i = 0; i < 10; i++) { // Joining the threads
            try {
                counterThreads[i].join();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }

        System.out.println("Result is " + sum); // Printing the result
    }
}
