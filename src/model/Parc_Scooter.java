package model;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
public class Parc_Scooter implements Serializable {

    private static int inc = 1;
    private int idPark;
    private String nom;
    private int capacite;
    private List<Scooter> scooters = new ArrayList<Scooter>();
    private List<Marque> marques = new ArrayList<Marque>();
    private List<Client> clients = new ArrayList<Client>();

    public Parc_Scooter(String nom, int capacite) {
        this.idPark = inc++;
        this.nom = nom;
        this.capacite = capacite;
    }

    public int getId() {
        return idPark;
    }

    public void setIdPark(int idPark) {
        this.idPark = idPark;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public List<Scooter> getScooters() {
        return scooters;
    }

    public void setScooters(List<Scooter> scooters) {
        this.scooters = scooters;
    }

    public List<Marque> getMarques() {
        return marques;
    }

    public void setMarques(List<Marque> marques) {
        this.marques = marques;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public void addScooter(Scooter scooter) {
        if (scooter != null) {
            scooters.add(scooter);
        } else {
            System.err.println("Le scooter que tu as ajouté est null");
        }
    }

    public void addMarque(Marque marque) {
        if (marque != null) {
            marques.add(marque);
        } else {
            System.err.println("La marque que tu as ajoutée est null");
        }
    }

    public void addClient(Client client) {
        if (client != null) {
            clients.add(client);
        } else {
            System.err.println("Le client que tu as ajouté est null");
        }
    }
    public boolean ScooterExist(int idScoot){
        for(Scooter scooter : scooters){
            if(scooter.getId() == idScoot)
                return true;
        }
        return false;
    }
        public String printData() {
            StringBuilder result = new StringBuilder();
            result.append("Parc_Scooter [id: ").append(idPark)
                  .append(", nom: ").append(nom)
                  .append(", capacite: ").append(capacite).append("]\n");
    
            result.append("Marques: ");
            for (int i = 0; i < marques.size(); i++) {
                result.append(marques.get(i).getNomMark());
                if (i < marques.size() - 1) result.append(", ");
            }
            result.append("\n");
    
            result.append("Scooters: ");
            for (int i = 0; i < scooters.size(); i++) {
                result.append(scooters.get(i).getId());
                if (i < scooters.size() - 1) result.append(", ");
            }
            result.append("\n");
    
            result.append("Clients: ");
            for (int i = 0; i < clients.size(); i++) {
                result.append(clients.get(i).getNom()).append(" ").append(clients.get(i).getPrenom());
                if (i < clients.size() - 1) result.append(", ");
            }
            result.append("\n");
    
            return result.toString();
        }
    
        public String EtatScooter(int idScoot) {
            StringBuilder result = new StringBuilder();
            if (!ScooterExist(idScoot)) {
                return "Erreur : Le scooter n'existe pas !\n";
            }
    
            for (Scooter scooter : scooters) {
                if (scooter.getId() == idScoot) {
                    result.append("Modele : ").append(scooter.getModele().getModeleNom()).append("\n")
                          .append("Numéro d'identification : ").append(scooter.getId()).append("\n")
                          .append("Kilométrage : ").append(scooter.getKilometrage()).append(" km\n")
                          .append("État de disponibilité : ")
                          .append(scooter.isAvailable() ? "Disponible" : "Deja en location").append("\n");
                    return result.toString();
                }
            }
            return result.toString();
        }
    
        public String EtatParc() {
            StringBuilder result = new StringBuilder();
            for (Scooter scooter : scooters) {
                result.append("Id du scooter: ").append(scooter.getId())
                      .append(", Modèle: ").append(scooter.getModele().getModeleNom())
                      .append(", Kilométrage: ").append(scooter.getKilometrage()).append(" km")
                      .append(", État de disponibilité: ").append(scooter.isAvailable() ? "Disponible" : "Non disponible")
                      .append("\n");
            }
            return result.toString();
        }
    
        public String SaisiParc() {
            StringBuilder result = new StringBuilder();
            int NbrScoots = scooters.size();
            int NbrScootsinLoc = 0;
            int NbrScootsinDisp = 0;
            float KilMoyen = 0;
    
            result.append("Le nombre total de scooters : ").append(NbrScoots).append("\n");
            result.append("Identifiants du scooters en location : ");
            for (Scooter scooter : scooters) {
                if (!scooter.isAvailable()) {
                    NbrScootsinLoc++;
                    result.append(scooter.getId()).append(", ");
                }
            }
            result.append("\n");
            result.append("Le nombre total de scooters en location : ").append(NbrScootsinLoc).append("\n");
            result.append("Identifiants du scooters disponible : ");
            for (Scooter scooter : scooters) {
                if (scooter.isAvailable()) {
                    result.append(scooter.getId()).append(", ");
                }
                KilMoyen += scooter.getKilometrage();
            }
            result.append("\n");
            NbrScootsinDisp = NbrScoots - NbrScootsinLoc;
            result.append("Le nombre total de scooters disponibles pour la location : ").append(NbrScootsinDisp).append("\n");
    
            if (NbrScoots > 0) {
                KilMoyen /= NbrScoots;
                result.append("Le kilométrage moyen des scooters de ce parc est : ").append(KilMoyen).append(" km\n");
            } else {
                result.append("Aucun scooter dans ce parc pour calculer le kilométrage.\n");
            }
    
            return result.toString();
        }
    }