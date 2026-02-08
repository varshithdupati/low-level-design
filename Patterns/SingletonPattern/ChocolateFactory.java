package SingletonPattern;

public class ChocolateFactory {
    
    public static volatile ChocolateFactory instance;
    private boolean full = false;

    private ChocolateFactory() {}

    public static ChocolateFactory getInstance() {
        if(instance == null) {
            synchronized (ChocolateFactory.class) {
                if (instance == null) {
                    instance = new ChocolateFactory();
                }
            }
        }
        return instance;
    }

    public boolean make() {
        if(!full) {
            System.out.println("Filling container ...");
            full = true;
        }
        System.out.println("Boiling ...");
        System.out.println("Done.");
        return true;
    }

    public boolean empty() {
        if(!full) {
            return false;
        }
        System.out.println("Emptying container ...");
        full = false;
        return true;
    }
}
