package headfirst.designpatterns.compound.mvc;

public class ConsoleView implements BeatObserver, BPMObserver {
    private final BeatModelInterface model;

    public ConsoleView(BeatModelInterface model) {
        this.model = model;
        model.registerBeatObserver(this);
        model.registerBPMObserver(this);
    }

    @Override
    public void updateBeat() {
        System.out.println("Beat!");
    }

    @Override
    public void updateBPM(int bpm) {
        System.out.println("BPM = " + bpm);
    }
}
