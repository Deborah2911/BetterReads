package Views;

import javax.swing.*;
import java.awt.*;

import static java.awt.GridBagConstraints.FIRST_LINE_START;

public class GridBagLayoutReviews {
    public static JPanel createPanel(JLabel l1, JLabel l2, JLabel l3, JLabel l4) {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        gbc.weighty = 0.0;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(10, 5, 5, 0);
        gbc.ipady = 0;
        panel.add(l1, gbc);

        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = FIRST_LINE_START;
        gbc.weighty = 1.0;
        gbc.weightx = 1.0;
        gbc.ipady = 0;
        gbc.ipadx = 10;
        gbc.gridheight = 2;
        panel.add(l2, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = FIRST_LINE_START;
        gbc.gridheight = 1;
        panel.add(l3, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        gbc.weighty = 0.0;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(0, 0, 30, 10);
        gbc.ipady = 10;
        gbc.ipadx = 10;
        panel.add(l4, gbc);

        panel.setPreferredSize(new Dimension(500, 150));
        return panel;
    }
}
