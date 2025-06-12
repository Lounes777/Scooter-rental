package view;
import model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EtatParcView extends JDialog {
    private JButton etatParcButton;

    public EtatParcView(JFrame parent) {
        super(parent, "État du parc", true);
        setLayout(new BorderLayout());
        JPanel panel = new JPanel(new GridLayout(1, 1, 10, 10));
        etatParcButton = new JButton("Afficher l'état du parc");
        panel.add(etatParcButton);
        add(panel, BorderLayout.CENTER);
        setSize(350, 80);
        setLocationRelativeTo(parent);
    }

    public void addEtatParcListener(ActionListener listener) {
        etatParcButton.addActionListener(listener);
    }
}
