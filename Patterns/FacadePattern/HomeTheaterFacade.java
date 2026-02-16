package FacadePattern;

import FacadePattern.HomeTheater.Amplifier;
import FacadePattern.HomeTheater.Lights;
import FacadePattern.HomeTheater.PopcornPopper;
import FacadePattern.HomeTheater.Projector;
import FacadePattern.HomeTheater.Screen;

public class HomeTheaterFacade {
    
    Amplifier amplifier;
    Lights lights;
    PopcornPopper popcornPopper;
    Projector projector;
    Screen screen;

    public HomeTheaterFacade(Amplifier amplifier, Lights lights, PopcornPopper popcornPopper, Projector projector, Screen screen) {
        this.amplifier = amplifier;
        this.lights = lights;
        this.popcornPopper = popcornPopper;
        this.projector = projector;
        this.screen = screen;
    }

    public void playMovie(String movie) {
        System.out.println("Get ready for " + movie);
        popcornPopper.on();
        screen.down();
        amplifier.on();
        lights.dim();
        projector.on(movie);
    }

    public void endMovie(String movie) {
        projector.off();
        lights.on();
        amplifier.off();
        screen.up();
        popcornPopper.off();
        System.out.println("Closed movie " + movie);
    }
}
