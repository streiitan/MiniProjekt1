public class Clock implements IClock {
    private ITime t1;
    private ITime t2;
    private boolean isT1Turn = true;

    public Clock(int minutes, int seconds) {
        t1 = new Time(minutes, seconds);
        t2 = new Time(minutes, seconds);
    }


    @Override
    public void switchTurn() {
        if (isT1Turn) {
            t1.pause();
            t2.resume();
            isT1Turn = false;
        } else {
            t2.pause();
            t1.resume();
            isT1Turn = true;
        }
    }

    @Override
    public void reset() {
        t1.reset();
        t2.reset();
    }

    @Override
    public void freeze() {
        t1.pause();
        t2.pause();
    }

    @Override
    public void startGame() {
        t1.resume();
        System.out.println("Yo fuckers");
    }
}
