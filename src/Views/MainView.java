package Views;

import javax.swing.*;

public class MainView extends JFrame {
    private final JTabbedPane tabbedPane;

    public MainView() {
        super("BetterReads");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabbedPane = new JTabbedPane();
        getContentPane().add(tabbedPane);
    }

    public void addTab(String title, JComponent component) {
        tabbedPane.addTab(title, component);
    }
}
