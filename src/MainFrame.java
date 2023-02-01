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
    private Controller contP1;
    private Controller contP2;
    private JPanel clockP1;
    private JPanel clockP2;

    public MainFrame(Controller controller){
        this.controller = controller;
        this.contP1 = new Controller("P1");
        this.contP2 = new Controller("P2");

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        clockP1 = new ClockView(contP1);
        clockP2 = new ClockView(contP2);
        JButton endTurnP1 = new JButton("End Turn");
        JButton endTurnP2 = new JButton("End Turn");
        JPanel panelClocks = new JPanel(new GridLayout(2,2));
        panelClocks.add(clockP1);
        panelClocks.add(clockP2);
        panelClocks.add(endTurnP1);
        panelClocks.add(endTurnP2);
        endTurnP1.addActionListener(e -> {updateControllerEndTurnP1();});
        endTurnP2.addActionListener(e -> {updateControllerEndTurnP2();});

        JPanel panelButtons = new JPanel(new GridLayout(1, 3));
        JButton start = new JButton("Start Game");
        JButton stop = new JButton("Stop Game");
        JButton reset = new JButton("Reset Game");
        panelButtons.add(start);
        panelButtons.add(stop);
        panelButtons.add(reset);
        start.addActionListener(e -> {updateControllerStart();});
        stop.addActionListener(e -> {updateControllerStop();});
        reset.addActionListener(e -> {updateControllerReset();});

        JPanel mainPanel = new JPanel(new GridLayout(2,1));
        mainPanel.add(panelClocks);
        mainPanel.add(panelButtons);
        add(mainPanel);

        setVisible(true);
        setSize(500, 500);
    }

    private void updateControllerReset() {
        this.contP1.resetGame();
        this.contP2.resetGame();
        this.clockP1.updateUI();
        this.clockP2.updateUI();
    }

    private void updateControllerStop() {
        this.contP1.stopGame();
        this.contP2.stopGame();
        this.clockP1.updateUI();
        this.clockP2.updateUI();
    }

    private void updateControllerStart() {
        this.contP1.startGame();
        this.clockP1.updateUI();

    }

    private void updateControllerEndTurnP1(){
        this.contP1.setTurn(true);
        this.contP2.setTurn(false);
        this.contP1.switchTurn();
        this.contP2.switchTurn();
        this.clockP1.updateUI();
        this.clockP2.updateUI();
    }

    private void updateControllerEndTurnP2(){
        this.contP1.setTurn(false);
        this.contP2.setTurn(true);
        this.contP1.switchTurn();
        this.contP2.switchTurn();
        this.clockP1.updateUI();
        this.clockP2.updateUI();
    }


}
