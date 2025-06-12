package controllers;
import model.*;
import model.AppModel;
import model.Client;
import view.LouerScooterView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class LouerScooterController implements ActionListener {
    private AppModel appModel;
    private Client user;
    private LouerScooterView view;

    public LouerScooterController(AppModel model, Client user, LouerScooterView view) {
        this.appModel = model;
        this.user = user;
        this.view = view;
        this.view.addLouerListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int scooterId = view.getScooterId();
            String result = user.LouerScooter(scooterId);
            JOptionPane.showMessageDialog(view, result, "Résultat de la location", JOptionPane.INFORMATION_MESSAGE);
            appModel.saveAllData();
            view.dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Entrée invalide. Veuillez entrer un identifiant valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Erreur : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}
