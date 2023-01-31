import javax.swing.*;

public class Time implements TimeType {
    private int second, minute;
    public Time(int minute, int second) {
        setMinute(minute);
        setSecond(second);
    }

    @Override
    public int getSecond() {
        return this.second;
    }

    @Override
    public void setSecond(int second) {
        this.second = second%60;
    }

    @Override
    public int getMinute() {
        return this.minute;
    }

    @Override
    public void setMinute(int minute) {
        this.minute = minute%60;
    }
    public String toString() {
        char[] array;
        array = new char[3];
        array[0] = (char)('0' + minute/10);
        array[1] = (char)('0' + minute%10);
        array[2] = ':';
        array[3]= (char)('0' + second/10);
        array[4]= (char)('0' + second%10);

        return new String(array);
    }
}

