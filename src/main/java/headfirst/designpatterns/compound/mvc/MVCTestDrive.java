package headfirst.designpatterns.compound.mvc;

public class MVCTestDrive {

    public static void main(String[] args) {
        BeatModelInterface model = new BeatModel();
        ConsoleView view = new ConsoleView(model);
        BeatController controller = new BeatController(model);

        controller.start();
        controller.setBPM(120);
        sleep(1500);

        controller.setBPM(90);
        sleep(1500);

        controller.stop();
        sleep(300);
        System.out.println("Stopped.");
    }

    private static void sleep(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }
}
