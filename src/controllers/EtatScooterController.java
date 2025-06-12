package controllers;
import model.*;
import model.Client;
import view.EtatScooterView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class EtatScooterController implements ActionListener {
    private Client user;
    private EtatScooterView view;

    public EtatScooterController(Client user, EtatScooterView view) {
        this.user = user;
        this.view = view;
        this.view.addEtatListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int scooterId = view.getScooterId();
            String status = user.getParc().EtatScooter(scooterId);
            JOptionPane.showMessageDialog(view, status, "État du scooter", JOptionPane.INFORMATION_MESSAGE);
            view.dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Entrée invalide. Veuillez entrer un identifiant valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Erreur : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}
