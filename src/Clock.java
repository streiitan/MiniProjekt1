public class Clock implements IClock {
    private ITime t1;
    private ITime t2;
    private boolean isT1Turn = true;

    public Clock(int time) {
        t1 = new Time(time);
        t2 = new Time(time);
    }

    @Override
    public void switchTurn() {
        if (isT1Turn) {
            t1.stop();
            t2.start();
            isT1Turn = false;
        } else {
            t2.stop();
            t1.start();
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
        t1.stop();
        t2.stop();
    }

    @Override
    public void startGame() {
        t1.start();
    }
}
