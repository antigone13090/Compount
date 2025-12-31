package headfirst.designpatterns.compound.mvc;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class BeatModel implements BeatModelInterface, Runnable {

    private final List<BeatObserver> beatObservers = new CopyOnWriteArrayList<>();
    private final List<BPMObserver> bpmObservers = new CopyOnWriteArrayList<>();

    private volatile boolean running = false;
    private Thread worker;
    private volatile int bpm = 90;

    @Override
    public void initialize() {
        // no-op (placeholder comme dans le livre)
    }

    @Override
    public void on() {
        if (running) return;
        running = true;
        worker = new Thread(this, "BeatModelThread");
        worker.setDaemon(true);
        worker.start();
        notifyBPMObservers();
    }

    @Override
    public void off() {
        running = false;
        notifyBPMObservers();
    }

    @Override
    public void setBPM(int bpm) {
        if (bpm < 0) bpm = 0;
        this.bpm = bpm;
        notifyBPMObservers();
    }

    @Override
    public int getBPM() {
        return bpm;
    }

    @Override
    public void registerBeatObserver(BeatObserver o) {
        if (o != null) beatObservers.add(o);
    }

    @Override
    public void removeBeatObserver(BeatObserver o) {
        beatObservers.remove(o);
    }

    @Override
    public void registerBPMObserver(BPMObserver o) {
        if (o != null) bpmObservers.add(o);
    }

    @Override
    public void removeBPMObserver(BPMObserver o) {
        bpmObservers.remove(o);
    }

    private void notifyBeatObservers() {
        for (BeatObserver o : beatObservers) o.updateBeat();
    }

    private void notifyBPMObservers() {
        for (BPMObserver o : bpmObservers) o.updateBPM(bpm);
    }

    @Override
    public void run() {
        while (running) {
            if (bpm <= 0) {
                // BPM 0 => pause
                sleepQuietly(250);
                continue;
            }
            notifyBeatObservers();
            long delayMs = Math.max(1, 60000L / bpm);
            sleepQuietly(delayMs);
        }
    }

    private static void sleepQuietly(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }
}
