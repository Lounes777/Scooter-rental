package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import model.*;
public class LouerScooterView extends JDialog {
    private JTextField idField;
    private JButton louerButton;

    public LouerScooterView(JFrame parent) {
        super(parent, "Louer un scooter", true);
        setLayout(new BorderLayout());
        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.add(new JLabel("ID du scooter : "));
        idField = new JTextField();
        panel.add(idField);
        panel.add(new JLabel());
        louerButton = new JButton("Louer");
        panel.add(louerButton);
        add(panel, BorderLayout.CENTER);
        setSize(350, 120);
        setLocationRelativeTo(parent);
    }

    public int getScooterId() throws NumberFormatException {
        return Integer.parseInt(idField.getText().trim());
    }
    public void addLouerListener(ActionListener listener) {
        louerButton.addActionListener(listener);
    }
}
