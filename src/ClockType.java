public interface ClockType {
    public void tickTack();
    public void setTime(TimeType time);
    public TimeType getTime();
    public String toString();
    //public void change(TimeType larm);
    //void switchTurn();
    //void reset();
    //void freeze();
    //void startGame();
    //public void addAlarm(AlarmType larm);
    //public void removeAlarm(AlarmType alarm);
    //public void removeAllAlarms();
    //public Collection<AlarmType> getAlarms();
}
