public interface ClockType {
    public void tickTack();
    public void restart();
    public void setTime(TimeType time);
    public TimeType getTime();
    public String toString();
}
