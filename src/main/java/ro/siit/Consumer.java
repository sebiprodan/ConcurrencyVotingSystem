package ro.siit;

public class Consumer extends Thread{
    private Buffer buffer;
    public Consumer(Buffer b) {
        buffer = b;
    }
    public void run() {
        for (int i = 0; i < 30; i++) {
            buffer.get();
            try {
                sleep(1000);
            } catch (InterruptedException e) { }
        }
    }

}
