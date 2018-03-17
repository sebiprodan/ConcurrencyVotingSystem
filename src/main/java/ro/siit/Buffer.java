package ro.siit;

public class Buffer {
    private int number = -1;
    public boolean readyForReading = false;
    public synchronized int get() {
        while (!readyForReading) {
            try {
                wait(); // Wait for producer to put a value
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        readyForReading = false;
        System.out.println("Consumatorul a primit:\t" + number);
        notifyAll();
        return number;
    }

    public synchronized void put(int number) {
        while (readyForReading) {
            try {
                wait(); // Wait for consumer to take value
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.number = number;
        System.out.println("Producatorul a pus:\t" + this.number);
        readyForReading = true;
        notifyAll();

    }

}
