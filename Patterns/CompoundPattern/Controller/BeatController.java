package CompoundPattern.Controller;

import CompoundPattern.Model.BeatModelInterface;
import CompoundPattern.View.DJView;

public class BeatController implements ControllerInterface {
	BeatModelInterface model;
	DJView view;
   
	public BeatController(BeatModelInterface model) {
		this.model = model;
        model.initialize();
		view = new DJView(this, model);
	}

    public void initialize() {
        view.createView();
        view.createControls();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
    }
  
	public void start() {
		model.on();
		view.disableStartMenuItem();
		view.enableStopMenuItem();
	}
  
	public void stop() {
		model.off();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
	}
    
	public void increaseBPM() {
        int bpm = model.getBPM();
        model.setBPM(bpm + 1);
	}
    
	public void decreaseBPM() {
        int bpm = model.getBPM();
        model.setBPM(bpm - 1);
  	}
  
 	public void setBPM(int bpm) {
		model.setBPM(bpm);
	}
}
