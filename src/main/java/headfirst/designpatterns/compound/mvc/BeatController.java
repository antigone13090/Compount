package headfirst.designpatterns.compound.mvc;

public class BeatController {
    private final BeatModelInterface model;

    public BeatController(BeatModelInterface model) {
        this.model = model;
        this.model.initialize();
    }

    public void start() { model.on(); }
    public void stop() { model.off(); }

    public void setBPM(int bpm) { model.setBPM(bpm); }
    public void increaseBPM() { model.setBPM(model.getBPM() + 5); }
    public void decreaseBPM() { model.setBPM(Math.max(0, model.getBPM() - 5)); }
}
