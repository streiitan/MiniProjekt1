import javax.swing.*;

public abstract class AbstractCounter implements CounterType {

    protected CounterType nextCounter;
    protected int currentCount;
    protected final int MAX_NR_OF_COUNTS;
    protected boolean isFinished;

    public AbstractCounter(int maxNrOfCounts, CounterType nextCounter) {
        this.nextCounter = nextCounter;
        if (maxNrOfCounts < 2) {
            this.MAX_NR_OF_COUNTS = 0;
        } else {
            this.MAX_NR_OF_COUNTS = maxNrOfCounts;
        }
        currentCount = MAX_NR_OF_COUNTS - 1;
    }

    @Override
    public int getCount() {
        return currentCount;
    }

    @Override
    public void reset() {
        currentCount = MAX_NR_OF_COUNTS - 1;
    }

    @Override
    public void pause() {
        isFinished = true;
    }

    @Override
    public void resume() {
        isFinished = false;
    }

    @Override
    public void count() {
        if (!isFinished) {
            currentCount--;
            if (currentCount < 0) {
                currentCount = MAX_NR_OF_COUNTS - 1;
                if (nextCounter != null) {
                    if (nextCounter.getCount() < 1) {
                        isFinished = true;
                        Thread t = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                JOptionPane.showMessageDialog(null, "Tiden är slut");
                            }
                        });
                        t.start();
                    } else {
                        nextCounter.count();
                    }
                }
            }
        }
    }
}
