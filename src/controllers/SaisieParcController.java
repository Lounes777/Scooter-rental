package controllers;
import model.*;
import model.Client;
import view.SaisieParcView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class SaisieParcController implements ActionListener {
    private Client user;
    private SaisieParcView view;

    public SaisieParcController(Client user, SaisieParcView view) {
        this.user = user;
        this.view = view;
        this.view.addSaisieParcListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String saisieParc = user.getParc().SaisiParc();
        JOptionPane.showMessageDialog(view, saisieParc, "Résumé du parc", JOptionPane.INFORMATION_MESSAGE);
        view.dispose();
    }
}
