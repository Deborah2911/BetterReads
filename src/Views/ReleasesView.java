package Views;

import javax.swing.*;
import java.awt.*;

public class ReleasesView extends JFrame {

    private final JLabel title;

    public ReleasesView(){
        title=new JLabel("This months releases");

        setTitle("BetterReads");
        setLayout(new GridLayout(8, 1));
        setLocationRelativeTo(null);
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(title);
    }
}
