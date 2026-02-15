package CommandPattern;

import CommandPattern.Commands.TVOnCommand;
import CommandPattern.Commands.TVOffCommand;
import CommandPattern.Commands.LightOnCommand;
import CommandPattern.Commands.LightOffCommand;
import CommandPattern.Commands.FanOnCommand;
import CommandPattern.Commands.FanOffCommand;
import CommandPattern.Objects.TV;
import CommandPattern.Objects.Light;
import CommandPattern.Objects.Fan;

public class RemoteDemo {
    
    public static void main(String[] args) {
        
        Remote remote = new Remote();
        
        TV tv = new TV();
        TVOnCommand tvon = new TVOnCommand(tv);
        TVOffCommand tvoff = new TVOffCommand(tv);
        remote.set(0, tvon, tvoff);

        Light light = new Light("Living room");
        LightOnCommand lon = new LightOnCommand(light);
        LightOffCommand loff = new LightOffCommand(light);
        remote.set(1, lon, loff);

        Light light1 = new Light("Bedroom");
        LightOnCommand lon1 = new LightOnCommand(light1);
        LightOffCommand loff1 = new LightOffCommand(light1);
        remote.set(2, lon1, loff1);

        Fan fan = new Fan("Living room");
        FanOnCommand fon = new FanOnCommand(fan);
        FanOffCommand foff = new FanOffCommand(fan);
        remote.set(3, fon, foff);

        Fan fan1 = new Fan("Bedroom");
        FanOnCommand fon1 = new FanOnCommand(fan1);
        FanOffCommand foff1 = new FanOffCommand(fan1);
        remote.set(4, fon1, foff1);

        remote.show();

        remote.onPressed(0);
        remote.offPressed(0);

        remote.onPressed(1);
        remote.offPressed(1);

        remote.onPressed(2);
        remote.offPressed(2);

        remote.onPressed(3);
        remote.offPressed(3);

        remote.onPressed(4);
        remote.offPressed(4);

        remote.onPressed(3);
        remote.show();
        remote.undoPressed();
        
    }

}
