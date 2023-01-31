public class SettableCounter extends AbstractCounter implements SettableCounterType {

    public SettableCounter(int maxNrOfCounts, CounterType nextCounter) {
        super(maxNrOfCounts, nextCounter);
    }

    @Override
    public void setCount(int value) {
        this.currentCount = value;
    }
}
