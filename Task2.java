public class Task2 {
    public static void Main(String[] args) throws InterruptedException{
        MyClock tiktak = new MyClock();
        tiktak.start();
        Thread.sleep(5000);
        tiktak.interrupt();
    }

}
