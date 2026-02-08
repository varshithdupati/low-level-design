package SingletonPattern;

public class Main {
    
    public static void main(String[] args) {
        ChocolateFactory instance1 = ChocolateFactory.getInstance();
        instance1.make();
        ChocolateFactory instance2 = ChocolateFactory.getInstance();
        instance2.make();
        ChocolateFactory instance3 = ChocolateFactory.getInstance();
        instance3.empty();
        ChocolateFactory instance4 = ChocolateFactory.getInstance();
        instance4.empty();
        ChocolateFactory instance5 = ChocolateFactory.getInstance();
        instance5.make();
    }

}
