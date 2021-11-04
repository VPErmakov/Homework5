public class MyClock extends Thread {
    @Override
    public void run(){
        while(!Thread.currentThread().isInterrupted()){
            try{
                System.out.println("tik");
                Thread.sleep(500);
                System.out.println("tak");
            }
            catch (InterruptedException e){
                System.out.println("Thread has been stopped");
                break;
            }
        }

    }
}
