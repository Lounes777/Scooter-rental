import javax.swing.*;
import model.*;
import controllers.AppController;
import model.AppModel;
import view.AppView;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppModel model = new AppModel();

            File dataFile = new File("Data.txt");
            if (dataFile.exists()) {
                model.loadAllData();
            } else {
                model.initializeData();
                model.saveAllData();
            }

            AppView view = new AppView();
            new AppController(model, view);
            view.setVisible(true);
        });
    }
}
