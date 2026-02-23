package CompoundPattern.Model;

import java.util.List;
import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;

import CompoundPattern.View.BPMObserver;
import CompoundPattern.View.BeatObserver;

public class BeatModel implements BeatModelInterface, Runnable {
    
    List<BeatObserver> beatObservers;
    List<BPMObserver> bpmObservers;
    int bpm = 90;
    boolean stop = false;
    Thread thread;
    Clip clip;

    @Override
    public void initialize() {
        beatObservers = new ArrayList<>();
        bpmObservers = new ArrayList<>();
        thread = new Thread(this);
        try {
            File resource = new File("Patterns/CompoundPattern/clap.wav");
            clip = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
            clip.open(AudioSystem.getAudioInputStream(resource));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void on() {
        bpm = 90;
        notifyBPMObservers();
        stop = false;
        thread.start();
    }

    @Override
    public void off() {
        stopBeat();
        stop = true;
    }

    @Override
    public void setBPM(int bpm) {
        this.bpm = bpm;
        notifyBPMObservers();
    }

    @Override
    public int getBPM() {
        return bpm;
    }

    @Override
    public void run() {
        while (!stop) {
            playBeat();
            notifyBeatObservers();
            try {
                Thread.sleep(60000 / bpm);
            } catch (InterruptedException e) {}
        }
    }

    @Override
    public void registerObserver(BeatObserver o) {
        beatObservers.add(o);
    }

    @Override
    public void removeObserver(BeatObserver o) {
        beatObservers.remove(o);
    }

    public void notifyBeatObservers() {
        for (BeatObserver o : beatObservers) {
            o.updateBeat();
        }
    }

    @Override
    public void registerObserver(BPMObserver o) {
        bpmObservers.add(o);
    }

    @Override
    public void removeObserver(BPMObserver o) {
        bpmObservers.remove(o);
    }

    public void notifyBPMObservers() {
        for (BPMObserver o : bpmObservers) {
            o.updateBPM();
        }
    }

    private void playBeat() {
        if (clip != null) {
            clip.setFramePosition(0);
            clip.start();
        }
    }

    private void stopBeat() {
        if (clip != null) {
            clip.setFramePosition(0);
            clip.stop();
        }
    }
    
}
