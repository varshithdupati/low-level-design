package FacadePattern.HomeTheater;

public class Projector {
    
    public void on(String movie) {
        System.out.println("Playing movie " + movie);
    }

    public void off() {
        System.out.println("Turning projector off");
    }

}
