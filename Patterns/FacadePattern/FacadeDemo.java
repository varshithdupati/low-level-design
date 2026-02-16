package FacadePattern;

import FacadePattern.HomeTheater.Amplifier;
import FacadePattern.HomeTheater.Lights;
import FacadePattern.HomeTheater.PopcornPopper;
import FacadePattern.HomeTheater.Projector;
import FacadePattern.HomeTheater.Screen;

public class FacadeDemo {
    
    public static void main(String[] args) {
        
        Amplifier amplifier = new Amplifier();
        Lights lights = new Lights();
        PopcornPopper popcornPopper = new PopcornPopper();
        Projector projector = new Projector();
        Screen screen = new Screen();

        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(amplifier, lights, popcornPopper, projector, screen);

        homeTheaterFacade.playMovie("Raiders of the lost ark");
        homeTheaterFacade.endMovie("Raiders of the lost ark");
        
    }

}
