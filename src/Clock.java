public class Clock implements ClockType{
    private SettableCounterType minute, second;

    public Clock(int mm, int ss){
        TimeType clock = new Time(mm,ss);
        this.minute = new Counter();
        this.second = new Counter(minute);
        setTime(clock);
    }
    @Override
    public void tickTack() {
        second.count();
    }

    @Override
    public void restart() {
        second.resume();
        minute.resume();
    }

    @Override
    public void setTime(TimeType time) {
        this.minute.setCount(time.getMinute());
        this.second.setCount(time.getSecond());
    }

    @Override
    public TimeType getTime() {
        TimeType clockFace;
        clockFace = new Time(minute.getCount(), second.getCount());
        return clockFace;
    }

    @Override
    public String toString() {
        return getTime().toString();
    }
}
