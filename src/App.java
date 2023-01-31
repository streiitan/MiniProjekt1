import javax.swing.*;

public class App {
    public static void main(String[] args) {
        Controller controller = new Controller();
        SwingUtilities.invokeLater(() -> new MainFrame(controller));
    }
}