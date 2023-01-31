import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MainFrame extends JFrame{

    private static final long serialVersionUID = 1L;
    private Controller controller;


    public MainFrame(Controller controller){
        this.controller = controller;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel clockP1 = new ClockView(new Controller("P1"));
        JPanel clockP2 = new ClockView(new Controller("P2"));
        JPanel panelClocks = new JPanel(new GridLayout(1,2));
        panelClocks.add(clockP1);
        panelClocks.add(clockP2);

        JPanel panelButtons = new JPanel(new GridLayout(1, 3));
        JButton start = new JButton("Start Game");
        JButton stop = new JButton("Stop Game");
        JButton reset = new JButton("Reset Game");
        panelButtons.add(start);
        panelButtons.add(stop);
        panelButtons.add(reset);
        start.addActionListener(e -> {controller.startGame();});
        stop.addActionListener(e -> {controller.stopGame();});
        reset.addActionListener(e -> {controller.resetGame();});

        JPanel mainPanel = new JPanel(new GridLayout(2,1));
        mainPanel.add(panelClocks);
        mainPanel.add(panelButtons);
        add(mainPanel);

        setVisible(true);
        setSize(500, 500);
    }




}
