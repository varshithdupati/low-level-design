package CompoundPattern;

import CompoundPattern.Controller.BeatController;
import CompoundPattern.Controller.ControllerInterface;
import CompoundPattern.Model.BeatModel;
import CompoundPattern.Model.BeatModelInterface;

public class JavaDJDemo {
    public static void main(String[] args) {
        BeatModelInterface model = new BeatModel();
        ControllerInterface controller = new BeatController(model);
        controller.initialize();
    }
}
