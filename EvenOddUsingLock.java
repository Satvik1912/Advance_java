import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class multithread_reentrant {
    private final int max;
    private int number = 1;
    private final Lock lock = new ReentrantLock();
    private final Condition evenCondition = lock.newCondition();
    private final Condition oddCondition = lock.newCondition();

    public multithread_reentrant(int max) {
        this.max = max;
    }

    public void printOdd() {
        while (number <= max) {
            lock.lock();
            try {
                while (number % 2 == 0) {
                    oddCondition.await(); // Wait for the even thread to signal
                }
                System.out.println("Odd Thread: " + number);
                number++;
                evenCondition.signal(); // Signal the even thread
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        }
    }

    public void printEven() {
        while (number <= max) {
            lock.lock();
            try {
                while (number % 2 != 0) {
                    evenCondition.await(); // Wait for the odd thread to signal
                }
                System.out.println("Even Thread: " + number);
                number++;
                oddCondition.signal(); // Signal the odd thread
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        }
    }
}

public class EvenOddUsingLock {
    public static void main(String[] args) {
        multithread_reentrant task = new multithread_reentrant(10);

        Thread oddThread = new Thread(task::printOdd);
        Thread evenThread = new Thread(task::printEven);

        oddThread.start();
        evenThread.start();
    }
}
