public abstract class AbstractCounter implements CounterType{

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
        currentCount = MAX_NR_OF_COUNTS -1;
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
        if (!isPaused) {
                currentCount--;
                if (currentCount <= 0) {
                    currentCount = MAX_NR_OF_COUNTS;
                    if (nextCounter != null) {
                        nextCounter.count();
                    }
                }
        }
    }


    @Override
    public String toString() {
        return "Räknaren står nu på " + Integer.toString(currentCount);
    }

}
