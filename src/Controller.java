import java.time.LocalDateTime;
import java.util.Observable;
import javax.swing.Timer;


public class Controller extends Observable {
    private ClockType clock;
    private LocalDateTime localTime;
    private Timer timer;

    private String player;

    public Controller(){
        localTime = LocalDateTime.now();
        clock = new Clock(localTime.getMinute(), localTime.getSecond());
        timer = new Timer(1000, e -> tickTack());
        timer.start();
    }
    public Controller(String player){
        this.player = player;
        localTime = LocalDateTime.now();
        clock = new Clock(localTime.getMinute(), localTime.getSecond());
        timer = new Timer(1000, e -> tickTack());
        timer.start();
    }

    private void tickTack() {
        clock.tickTack();
        this.setChanged();
        this.notifyObservers();
    }

    public int getSecond() {
        return clock.getTime().getSecond();
    }

    public int getMinute() {
        return clock.getTime().getMinute();
    }
    public String getPlayer(){
       return player;
    }

    public void startGame(){

    }
    public void stopGame(){

    }
    public void resetGame(){

    }

    public void changeTime(int min, int sec) {
        TimeType time = new Time(min, sec);
        clock.setTime(time);
    }

}
