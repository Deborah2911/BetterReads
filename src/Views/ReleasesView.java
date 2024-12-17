package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ReleasesView extends JFrame {

    private final JLabel title;
    private final JButton accountButton;

    public ReleasesView(){
        title=new JLabel("This months releases");
        accountButton=new JButton("My Account");

        setTitle("BetterReads");
        setLayout(new GridLayout(8, 1));
        setLocationRelativeTo(null);
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(title);
        add(accountButton);
    }

    public void setAccountButtonActionListener(ActionListener actionListener){
        accountButton.addActionListener(actionListener);
    }
}
