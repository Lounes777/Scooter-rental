package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import model.*;
public class SaisieParcView extends JDialog {
    private JButton saisieParcButton;

    public SaisieParcView(JFrame parent) {
        super(parent, "Saisie du parc", true);
        setLayout(new BorderLayout());
        JPanel panel = new JPanel(new GridLayout(1, 1, 10, 10));
        saisieParcButton = new JButton("Afficher le résumé du parc");
        panel.add(saisieParcButton);
        add(panel, BorderLayout.CENTER);
        setSize(350, 80);
        setLocationRelativeTo(parent);
    }

    public void addSaisieParcListener(ActionListener listener) {
        saisieParcButton.addActionListener(listener);
    }
}
