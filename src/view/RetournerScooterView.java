// Vue Swing dédiée au retour d'un scooter
package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import model.*;
public class RetournerScooterView extends JDialog {
    private JTextField idField;
    private JTextField kmField;
    private JButton retournerButton;

    public RetournerScooterView(JFrame parent) {
        super(parent, "Retourner un scooter", true);
        setLayout(new BorderLayout());
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.add(new JLabel("ID du scooter : "));
        idField = new JTextField();
        panel.add(idField);
        panel.add(new JLabel("Kilométrage effectué : "));
        kmField = new JTextField();
        panel.add(kmField);
        panel.add(new JLabel());
        retournerButton = new JButton("Retourner");
        panel.add(retournerButton);
        add(panel, BorderLayout.CENTER);
        setSize(350, 150);
        setLocationRelativeTo(parent);
    }

    public int getScooterId() throws NumberFormatException {
        return Integer.parseInt(idField.getText().trim());
    }
    public double getKilometrage() throws NumberFormatException {
        return Double.parseDouble(kmField.getText().trim());
    }
    public void addRetournerListener(ActionListener listener) {
        retournerButton.addActionListener(listener);
    }
}
