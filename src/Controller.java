import java.time.LocalDateTime;
import java.util.Observable;
import javax.swing.Timer;


public class Controller extends Observable {
    private ClockType clock;
    private Timer timer;

    private Boolean p1Turn;
    private String player;
    private int min = 01;
    private int sec = 05;

    public Controller(){
        clock = new Clock(min, sec);
        timer = new Timer(1000, e -> tickTack());

    }
    public Controller(String player){
        this.player = player;
        clock = new Clock(min, sec);
        timer = new Timer(1000, e -> tickTack());

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
        this.timer.start();
        this.clock.restart();
    }
    public void stopGame(){
        this.timer.stop();

    }
    public void resetGame(){
        this.stopGame();
        changeTime(min, sec);

    }

    public void changeTime(int min, int sec) {
        TimeType time = new Time(min, sec);
        clock.setTime(time);
    }

    public void switchTurn(){
        if(this.p1Turn){
            stopGame();
            this.p1Turn = false;
        }else
            startGame();
            this.p1Turn = true;
    }

    public void setTurn(Boolean b){
        this.p1Turn = b;
    }

}
