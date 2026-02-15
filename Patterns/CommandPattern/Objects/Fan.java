package CommandPattern.Objects;

public class Fan {
    
    String location;

    public Fan(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " fan is on.");
    }

    public void off() {
        System.out.println(location + " fan is off.");
    }

}
