package model;
import java.io.*;
import java.util.*;
import java.io.Serializable;
public class Client implements Serializable {
    private static int inc = 1;
    private int id;
    private String nom;
    private int tel;
    private String prenom;
    private Date date_naissance;

    private List<Location> locations = new ArrayList<Location>();
    private List<Permis> permisses = new ArrayList<Permis>();
    private Parc_Scooter parc;

    public Client(String nom, int tel, String prenom, Date date_naissance, Parc_Scooter parc) {
        this.id = inc++;
        this.nom = nom;
        this.tel = tel;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.parc = parc;
    }

    public void addLocations(Location location){
        if (location == null) {
            System.err.println("La location que vous avez ajouté est null !");
        }
        
        locations.add(location);}



        public void addPermisses(Permis permis){
            if (permis == null) {
                System.err.println("Le permis que vous avez ajouté est null !");
            }
            
            permisses.add(permis);}


    public int getId() { return this.id; }
    public String getNom() { return this.nom; }
    public int getTel() { return this.tel; }
    public String getPrenom() { return this.prenom; }
    public Date getDate_naissance() { return this.date_naissance; }
    public Parc_Scooter getParc() { return this.parc; }



    public void setId(int id) { this.id = id; }
    public void setNom(String nom) { this.nom = nom; }
    public void setTel(int tel) { this.tel = tel; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public void setDate_naissance(Date date_naissance) { this.date_naissance = date_naissance; }
    public void setParc(Parc_Scooter parc) {  this.parc=parc; }

    public String printData() {
        StringBuilder result = new StringBuilder();
        result.append("Client [id: ").append(id)
              .append(", nom: ").append(nom)
              .append(", prenom: ").append(prenom)
              .append(", tel: ").append(tel)
              .append(", date_naissance: ").append(date_naissance).append("]\n");

        result.append("Permis: ");
        for (int i = 0; i < permisses.size(); i++) {
            result.append(permisses.get(i).getType_permis());
            if (i < permisses.size() - 1) result.append(", ");
        }
        result.append("\n");

        result.append("Locations: ");
        for (int i = 0; i < locations.size(); i++) {
            result.append(locations.get(i).getId());
            if (i < locations.size() - 1) result.append(", ");
        }
        result.append("\n");

        return result.toString();
    }
    public String LouerScooter(int idScoot) {
        if (!parc.ScooterExist(idScoot)) {
            return "Erreur : Le scooter n'existe pas !\n";
        }

        // Check if the user already has an active rental
        if (!locations.isEmpty() && locations.get(locations.size() - 1).getDate_fin() == null) {
            return "Erreur : Vous avez déjà loué un scooter !\n";
        }

        for (Scooter scooter : parc.getScooters()) {
            if (scooter.getId() == idScoot) {
                if (!scooter.isAvailable()) {
                    return "Erreur : Le scooter est déjà en location.\n";
                } else {
                    Location location = new Location(new Date(), scooter, this);
                    this.addLocations(location);
                    scooter.addLocations(location);
                    return "Succès : La location est effectuée avec succès.\n";
                }
            }
        }
        return "Erreur : Scooter non trouvé.\n";
    }

    public String RetournerScooter(int idScoot, double kilometrage) {
        if (!parc.ScooterExist(idScoot)) {
            return "Erreur : Le scooter n'existe pas !\n";
        }

        for (Scooter scooter : parc.getScooters()) {
            if (scooter.getId() == idScoot) {
                if (scooter.isAvailable()) {
                    return "Erreur : Le scooter n'était pas en location.\n";
                }

                if (!scooter.getLocations().isEmpty() && this != scooter.getLocations().get(scooter.getLocations().size() - 1).getClient()) {
                    return "Erreur : Ce scooter a été loué par un autre utilisateur. Vous ne pouvez pas le retourner.\n";
                }

                Date date_de_fin = new Date();
                scooter.getLocations().get(scooter.getLocations().size() - 1).setDate_fin(date_de_fin);
                scooter.getLocations().get(scooter.getLocations().size() - 1).setKilometrage(kilometrage);
                this.locations.get(this.locations.size() - 1).setDate_fin(date_de_fin);
                this.locations.get(this.locations.size() - 1).setKilometrage(kilometrage);

                return "Succès : Le retour est effectué avec succès.\nLe scooter est maintenant disponible pour la location.\n";
            }
        }
        return "Erreur : Scooter non trouvé.\n";
    }

    public boolean isAvailable() {
        if (locations.isEmpty()) {
            return true;
        }

        Location lastLocation = locations.get(locations.size() - 1);
        return lastLocation.getDate_fin() != null;
    }
    }

