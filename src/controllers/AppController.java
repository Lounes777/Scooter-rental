package controllers;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.RetournerScooterView;
import model.*;
import view.LouerScooterView;
import view.EtatScooterView;
import view.AppView;
import view.EtatParcView;
import view.SaisieParcView;

public class AppController {
    private AppModel model;
    private AppView view;
    private Client user;

    public AppController(AppModel model, AppView view) {
        this.model = model;
        this.view = view;
        user = initializeUser();

        view.getRentScooterButton().addActionListener(e -> {
            LouerScooterView louerView = new LouerScooterView(view);
            new LouerScooterController(model, user, louerView);
            louerView.setVisible(true);
        });
        view.getReturnScooterButton().addActionListener(e -> {
            RetournerScooterView retourView = new RetournerScooterView(view);
            new RetournerScooterController(model, user, retourView);
            retourView.setVisible(true);
        });
        view.getCheckScooterStatusButton().addActionListener(e -> {
            EtatScooterView etatView = new EtatScooterView(view);
            new EtatScooterController(user, etatView);
            etatView.setVisible(true);
        });
        view.getViewParcStatusButton().addActionListener(e -> {
            EtatParcView parcView = new EtatParcView(view);
            new EtatParcController(user, parcView);
            parcView.setVisible(true);
        });
        view.getSaisieParcButton().addActionListener(e -> {
            SaisieParcView saisieView = new SaisieParcView(view);
            new SaisieParcController(user, saisieView);
            saisieView.setVisible(true);
        });
        view.getExitButton().addActionListener(e -> {
            model.saveAllData();
            JOptionPane.showMessageDialog(view, "Données sauvegardées. Fermeture du programme.", "Quitter", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        });
    }

    private Client initializeUser() {
        while (true) {
            String input = JOptionPane.showInputDialog(view, "Entrez votre identifiant client :");
            try {
                int id = Integer.parseInt(input);
                for (Object obj : model.getAllObjects()) {
                    if (obj instanceof Client) {
                        Client client = (Client) obj;
                        if (client.getId() == id) {
                            view.getWelcomeLabel().setText("Bonjour, " + client.getNom() + " " + client.getPrenom() + "!");
                            return client;
                        }
                    }
                }
                JOptionPane.showMessageDialog(view, "Identifiant client introuvable. Réessayez.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(view, "Entrée invalide. Veuillez entrer un identifiant valide.");
            }
        }
    }
}