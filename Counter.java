import java.util.concurrent.Semaphore;

public class Counter extends Thread{
    Semaphore mutex;

    public Counter(Semaphore mutex) {
        this.mutex = mutex;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000000; ++i) {
            try {
                mutex.acquire(); // Lock critical region
                Main.sum += 1;
                mutex.release(); // Unlock critical region
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }
    }
}
