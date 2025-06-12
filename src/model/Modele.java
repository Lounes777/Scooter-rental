package model;
import java.io.*;
import java.util.*;
import java.io.Serializable;
public class Modele implements Serializable {
    private static int inc = 1;
    private int idModele;
    private String modeleNom;
    private String cylinder;
    private float vitesseMax;
    private Marque marque;
    private List<Scooter> scooters = new ArrayList<Scooter>();
    private List<Permis> permisses = new ArrayList<Permis>();

    public Modele(String modelName, String cylinder, float vitesseMax, Marque marque) {
        this.idModele = inc++;
        this.modeleNom = modelName;
        this.cylinder = cylinder;
        this.vitesseMax = vitesseMax;
        this.marque = marque;
    }

    public int getId() {
        return idModele;
    }

    public void setIdModele(int idModele) {
        this.idModele = idModele;
    }

    public String getModeleNom() {
        return modeleNom;
    }

    public void setModeleNom(String modeleNom) {
        this.modeleNom = modeleNom;
    }

    public String getCylinder() {
        return cylinder;
    }

    public void setCylinder(String cylinder) {
        this.cylinder = cylinder;
    }

    public float getVitesseMax() {
        return vitesseMax;
    }

    public void setVitesseMax(float vitesseMax) {
        this.vitesseMax = vitesseMax;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public List<Scooter> getScooters() {
        return scooters;
    }

    public void setScooters(List<Scooter> scooters) {
        this.scooters = scooters;
    }

    public List<Permis> getPermises() {
        return permisses;
    }
    public void setPermises(List<Permis> permises) {
        this.permisses = permises;
    }

    public void addScooter(Scooter scooter) {
        if (scooter != null) {
            scooters.add(scooter);
        } else {
            System.err.println("Le scooter que tu as ajouté est null");
        }
    }

    public void addPermis(Permis permis) {
        if (permis != null) {
            permisses.add(permis);
        } else {
            System.err.println("Le permis que tu as ajouté est null");
        }
    }
    public String printData() {
        StringBuilder result = new StringBuilder();
        result.append("Modele [id: ").append(idModele)
              .append(", nom: ").append(modeleNom)
              .append(", cylindre: ").append(cylinder)
              .append(", vitesse max: ").append(vitesseMax)
              .append(", marque: ").append(marque.getNomMark()).append("]\n");

        result.append("Scooters: ");
        for (int i = 0; i < scooters.size(); i++) {
            result.append(scooters.get(i).getId());
            if (i < scooters.size() - 1) result.append(", ");
        }
        result.append("\n");

        result.append("Permis: ");
        for (int i = 0; i < permisses.size(); i++) {
            result.append(permisses.get(i).getType_permis());
            if (i < permisses.size() - 1) result.append(", ");
        }
        result.append("\n");

        return result.toString();
    }
    
}
