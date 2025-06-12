package model;
import java.io.*;
import java.util.*;
import java.io.Serializable;

public class Marque implements Serializable {
    private static int inc = 1;
    private int idMark;

    private String nomMark;

    private List<Parc_Scooter> parcs_Scooters = new ArrayList<Parc_Scooter>();
    private List<Modele> modeles = new ArrayList<Modele>();


    public Marque(String nomMark) {
        this.idMark = inc++;
        this.nomMark = nomMark;
    }


    public void addParc_scooter(Parc_Scooter parc){
        if (parc == null) {
            System.err.println("La parc que vous avez ajouté est null !");
        }
        parcs_Scooters.add(parc);
    }
    
    public void addModels(Modele modele){
        if (modele == null) {
            System.err.println("Le modele que vous avez ajouté est null !");
        }
        modeles.add(modele);}


    public int getId (){ return this.idMark;}
    public String getNomMark (){ return this.nomMark;}

    public void setNomMark(int mark){this.idMark = mark;}
    public void setIdMark(String nomMark){this.nomMark = nomMark;}

    public String printData() {
        StringBuilder result = new StringBuilder();
        result.append("Marque [id: ").append(idMark)
              .append(", nom: ").append(nomMark).append("]\n");

        result.append("Modèles: ");
        for (int i = 0; i < modeles.size(); i++) {
            result.append(modeles.get(i).getModeleNom());
            if (i < modeles.size() - 1) result.append(", ");
        }
        result.append("\n");

        result.append("Parcs: ");
        for (int i = 0; i < parcs_Scooters.size(); i++) {
            result.append(parcs_Scooters.get(i).getNom());
            if (i < parcs_Scooters.size() - 1) result.append(", ");
        }
        result.append("\n");

        return result.toString();
    }
    



}