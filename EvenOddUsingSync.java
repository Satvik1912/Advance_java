class multithread_sync {
    private final int max;
    private int number = 1;

    public multithread_sync(int max) {
        this.max = max;
    }

    public synchronized void printOdd() {
        while (number <= max) {
            if (number % 2 == 0) {
                try {
                    wait(); // Wait for the even thread to notify
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            } else {
                System.out.println("Odd Thread: " + number);
                number++;
                notify(); // Notify the even thread
            }
        }
    }

    public synchronized void printEven() {
        while (number <= max) {
            if (number % 2 != 0) {
                try {
                    wait(); // Wait for the odd thread to notify
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            } else {
                System.out.println("Even Thread: " + number);
                number++;
                notify(); // Notify the odd thread
            }
        }
    }
}

public class EvenOddUsingSync {
    public static void main(String[] args) {
        multithread_sync task = new multithread_sync(10);

        Thread oddThread = new Thread(task::printOdd);
        Thread evenThread = new Thread(task::printEven);

        oddThread.start();
        evenThread.start();
    }
}
