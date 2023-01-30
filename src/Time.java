import javax.swing.*;

public class Time implements ITime{
    private final int SECONDS_PER_MINUTE = 60;
    private final int START_TIME;
    private int minute;
    private int second;
    private int time;
    private Timer timer;
    public Time(int minute, int second) {
        this.minute = minute;
        this.second = second;
        this.START_TIME = SECONDS_PER_MINUTE * minute + second;
        this.time = this.START_TIME;
        this.timer = new Timer(1000, e -> count());
    }

    @Override
    public void pause() {
        timer.stop();
    }

    @Override
    public void resume() {
        timer.start();
        System.out.println("Så skönt att vara naken");
    }

    @Override
    public void reset() {
        time = START_TIME;
    }

    @Override
    public void count() {
        System.out.println(time);
        if (time > 0) {
            time--;
        } else {
            System.out.println("Tiden är slut");
        }
    }
}
