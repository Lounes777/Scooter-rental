package controllers;
import model.Client;
import model.*;
import model.Parc_Scooter;
import view.EtatParcView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class EtatParcController implements ActionListener {
    private Client user;
    private EtatParcView view;

    public EtatParcController(Client user, EtatParcView view) {
        this.user = user;
        this.view = view;
        this.view.addEtatParcListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String parcStatus = user.getParc().EtatParc();
        JOptionPane.showMessageDialog(view, parcStatus, "État du parc", JOptionPane.INFORMATION_MESSAGE);
        view.dispose();
    }
}
