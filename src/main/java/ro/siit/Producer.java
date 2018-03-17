package ro.siit;

public class Producer extends Thread{
    private Buffer buffer;
    public Producer(Buffer b) {
        buffer = b;
    }
    public void run() {
        for (int i = 0; i < 30; i++) {
            buffer.put(i);
            try {
                sleep(3000);
            } catch (InterruptedException e) { }
        }
    }

}
