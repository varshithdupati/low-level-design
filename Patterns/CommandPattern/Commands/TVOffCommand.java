package CommandPattern.Commands;

import CommandPattern.Command;
import CommandPattern.Objects.TV;

public class TVOffCommand implements Command {
    
    TV tv;

    public TVOffCommand(TV tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.off();
    }

    public void undo() {
        tv.on();
    }
    
}
