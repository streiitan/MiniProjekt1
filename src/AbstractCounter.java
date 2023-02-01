import javax.swing.*;

public class AbstractCounter implements CounterType {

    protected CounterType nextCounter;
    protected int currentCount;
    protected final int MAX_NR_OF_COUNTS;
    protected boolean isPaused;

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
        isPaused = true;
    }

    @Override
    public void resume() {
        isPaused = false;
    }

    @Override
    public void count() {
        System.out.println(isPaused);
        if (!isPaused) {
            currentCount--;
            if (currentCount < 0) {
                currentCount = MAX_NR_OF_COUNTS - 1;
                if (nextCounter != null) {
                    nextCounter.count();
                } else {
                    pause();
                    System.out.println(isPaused); 
                    JOptionPane.showMessageDialog(null, "Tiden är slut");
                }
            }
        }
    }
}
