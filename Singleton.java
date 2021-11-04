public final class Singleton {
    private static Singleton instance;
    String value;

    private Singleton(String value){
        try{
            Thread.sleep(10000);
        }
        catch (InterruptedException ex){
            ex.printStackTrace();
        }
        this.value = value;
    }

    static synchronized Singleton getInstance(String value){
        if (instance == null) {
            instance = new Singleton(value);
        }
        return instance;
    }
}
