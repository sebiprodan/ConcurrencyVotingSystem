package ro.siit;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Buffer buffer = new Buffer();
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);
        producer.start();
        consumer.start();
    }
}
