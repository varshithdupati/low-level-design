package CommandPattern.Commands;

import CommandPattern.Command;
import CommandPattern.Objects.Light;

public class LightOffCommand implements Command {
    
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.off();
    }

    public void undo() {
        light.on();
    }
    
}
