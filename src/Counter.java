public class Counter extends SettableCounter{

    public Counter() {
        this(null);
    }

    public Counter(CounterType next) {
        super(60, next);
    }
}
