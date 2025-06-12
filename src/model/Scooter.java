package model;
import java.io.*;
import java.util.*;
import java.io.Serializable;

public class Scooter implements Serializable {

    private static int inc = 1;
    private int idScoot;
 
    private Modele modele;
    private Parc_Scooter parc;

    private List<Location> locations = new ArrayList<Location>();
    
    public Scooter(Modele modele, Parc_Scooter parc) {
        this.idScoot = inc++;
        this.modele = modele;
        this.parc = parc;
    }

    public void addLocations(Location location){
        if (location == null) {
            System.err.println("La location que vous avez ajouté est null !");
        }
        else{
            locations.add(location);
        }
        }
        


    public int getId() { return this.idScoot; }
    public Parc_Scooter getParc(){return this.parc;} 
    public Modele getModele(){return this.modele;}

    
    public void setIdScoot(int idScoot) { this.idScoot = idScoot; }
    public void setModele(Modele modele){this.modele = modele;}
    public void setParc(Parc_Scooter parc){this.parc = parc;}
    public void printData() {
        System.out.println("Scooter [id: " + idScoot + ", Parc: " + parc.getNom() +", modele: " + modele.getModeleNom() + "]");
        System.out.print("Locations: ");
        for (int i = 0; i < locations.size(); i++) {
            System.out.print(locations.get(i).getId());
            if (i < locations.size() - 1) System.out.print(", ");
        }
        System.out.println(); 
    }
    public boolean isAvailable() {
        if (locations.isEmpty()) {
            return true; // jamais louer = available
        }
    
        Location lastLocation = locations.get(locations.size() - 1);
        return lastLocation.getDate_fin() != null; // si date_fin n'est pas null, alors il est disponible
    }
    
    public int getKilometrage() {
        int totalKilometrage = 0;
        for (Location location : locations) {
            totalKilometrage += location.getKilometrage();
        }
        return totalKilometrage;
    }
    public List<Location> getLocations() {
        return locations;
    }
}
