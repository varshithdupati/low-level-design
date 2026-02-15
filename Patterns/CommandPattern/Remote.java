package CommandPattern;

public class Remote {
    
    Command[] onCommands;
    Command[] offCommands;
    Command undoCommand;

    Remote() {
        onCommands = new Command[5];
        offCommands = new Command[5];
        init();
    }

    private void init() {
        for(int i=0; i<5; i++) {
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
        undoCommand = new NoCommand();
    }

    public void set(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onPressed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void offPressed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void undoPressed() {
        undoCommand.undo();
    }

    public void show() {
        for(int i=0; i<5; i++) {
            System.out.println(i + " - " + onCommands[i] + " " + offCommands[i]);
        }
        System.out.println(undoCommand);
    }

}
