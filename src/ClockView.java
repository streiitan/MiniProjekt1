import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.Observable;
import java.util.Observer;

public class ClockView extends JPanel implements Observer {
    private static final long serialVersionUID = 1L;
    private String second;
    private String minute;
    private Controller controller;

    public ClockView(Controller controller){
        this.controller = controller;
        setBackground(Color.WHITE);
        this.controller.addObserver(this);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int xCenter = getWidth()/2;
        int yCenter = getHeight()/2;
        setTime();
        String time = minute + ":" + second;

        g.drawString(controller.getPlayer(),xCenter, yCenter + 10);
        g.setFont(new Font("sans-serif", Font.PLAIN, 40));
        int stringWidth = xCenter-g.getFontMetrics().stringWidth(time)/2;
        int stringHeight = yCenter-g.getFontMetrics().getHeight()/2;
        g.drawString(time, stringWidth, stringHeight);


    }

    private void setTime() {
        DecimalFormat digits = new DecimalFormat("00"); 	// Bestämmer formatet på siffrorna. Är det endast ett ental läggs en nolla till
        second = digits.format(controller.getSecond());
        minute = digits.format(controller.getMinute());

    }

    private void updateControllerSwitch() {
        this.controller.switchTurn();
    }

    @Override
    public void update(Observable o, Object arg) {
        setTime();
        repaint();
    }
}
