package view;

import javax.swing.*;
import java.awt.*;

public class AppView extends JFrame {
    private JButton rentScooterButton;
    private JButton returnScooterButton;
    private JButton checkScooterStatusButton;
    private JButton viewParcStatusButton;
    private JButton saisieParcButton;
    private JButton exitButton;
    private JLabel welcomeLabel;
    public AppView() {
        setTitle("LOUSCOOT");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //ajouter l'arriere plan
        BackgroundPanel backgroundPanel = new BackgroundPanel("view/scooter.jpg");
        backgroundPanel.setLayout(new BorderLayout());

        welcomeLabel = new JLabel("Bonjour, [Nom du Client]!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        welcomeLabel.setForeground(Color.WHITE); 
        backgroundPanel.add(welcomeLabel, BorderLayout.NORTH);

        //crée les buttons
        rentScooterButton = new JButton("Louer un scooter");
        returnScooterButton = new JButton("Retour d'un scooter");
        checkScooterStatusButton = new JButton("État d'un scooter");
        viewParcStatusButton = new JButton("Affichage de l'état du parc");
        saisieParcButton = new JButton("Saisie du parc");
        exitButton = new JButton("Quitter");
        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        rentScooterButton.setFont(buttonFont);
        returnScooterButton.setFont(buttonFont);
        checkScooterStatusButton.setFont(buttonFont);
        viewParcStatusButton.setFont(buttonFont);
        saisieParcButton.setFont(buttonFont);
        exitButton.setFont(buttonFont);

        
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 20, 10, 20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonPanel.add(rentScooterButton, gbc);
        gbc.gridy++;
        buttonPanel.add(returnScooterButton, gbc);
        gbc.gridy++;
        buttonPanel.add(checkScooterStatusButton, gbc);
        gbc.gridy++;
        buttonPanel.add(viewParcStatusButton, gbc);
        gbc.gridy++;
        buttonPanel.add(saisieParcButton, gbc);
        gbc.gridy++;
        buttonPanel.add(exitButton, gbc);
        backgroundPanel.add(buttonPanel, BorderLayout.CENTER);
        add(backgroundPanel);
    }

    public JButton getRentScooterButton() {
        return rentScooterButton;
    }

    public JButton getReturnScooterButton() {
        return returnScooterButton;
    }

    public JButton getCheckScooterStatusButton() {
        return checkScooterStatusButton;
    }

    public JButton getViewParcStatusButton() {
        return viewParcStatusButton;
    }

    public JButton getSaisieParcButton() {
        return saisieParcButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public JLabel getWelcomeLabel() {
        return welcomeLabel;
    }
}

class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel(String imagePath) {
        try {
            backgroundImage = new ImageIcon(imagePath).getImage();
        } catch (Exception e) {
            System.err.println("Error dans le loadin d'arriere plan: " + e.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}