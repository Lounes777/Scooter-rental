// Contrôleur pour la fonctionnalité RetournerScooter
package controllers;

import model.AppModel;
import model.Client;
import view.RetournerScooterView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.*;
public class RetournerScooterController implements ActionListener {
    private AppModel model;
    private Client user;
    private RetournerScooterView view;

    public RetournerScooterController(AppModel model, Client user, RetournerScooterView view) {
        this.model = model;
        this.user = user;
        this.view = view;
        this.view.addRetournerListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int scooterId = view.getScooterId();
            double km = view.getKilometrage();
            String result = user.RetournerScooter(scooterId, km);
            JOptionPane.showMessageDialog(view, result, "Résultat du retour", JOptionPane.INFORMATION_MESSAGE);
            model.saveAllData();
            view.dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Entrée invalide. Veuillez entrer des valeurs valides.", "Erreur", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Erreur : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}
