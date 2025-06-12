package model;
import java.io.*;
import java.util.*;
import java.util.Date;
import java.io.Serializable;

public class Location implements Serializable {
    private static int inc = 1;
    private int idLoc;
    private Date date_debut;
    private Date date_fin;
    private double kilometrage = 0;
    private Scooter scooter;
    private Client client;

    public Location(Date date_debut, Scooter scooter, Client client) {
        this.kilometrage = 0;
        this.idLoc = inc++;
        this.date_debut = date_debut;
        this.scooter = scooter;
        this.client = client;
    }

    public Date getDate_debut() { return this.date_debut; }
    public Date getDate_fin() { return this.date_fin; }
    public double getKilometrage() { return this.kilometrage; } 
    public Scooter getScooter() { return this.scooter; }
    public Client getClient() { return this.client; }
    public int getId() { return this.idLoc; }

    public void setDate_debut(Date date_debut) { this.date_debut = date_debut; }
    public void setDate_fin(Date date_fin) { this.date_fin = date_fin; }
    public void setKilometrage(double kilometrage) { this.kilometrage = kilometrage; }
    public void setScooter(Scooter scooter) { this.scooter = scooter; }
    public void setClient(Client client) { this.client = client; }
    public void setIdLoc(int id) { this.idLoc = id; }

    public String printData() {
        StringBuilder result = new StringBuilder();
        result.append("Location [id: ").append(idLoc)
              .append(", date_debut: ").append(date_debut)
              .append(", date_fin: ").append(date_fin != null ? date_fin : "En cours")
              .append(", kilometrage: ").append(kilometrage).append(" km")
              .append(", scooter_id: ").append(scooter.getId())
              .append(", client: ").append(client.getNom()).append(" ").append(client.getPrenom())
              .append("]");
        return result.toString();
    }
}
