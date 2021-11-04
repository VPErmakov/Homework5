public class Task1 {
    public static void main(String[] args) {
        MyThread potok = new MyThread();
        Thread potok2 = new Thread(new Runner());
        potok.start();
        potok2.start();
    }
}



