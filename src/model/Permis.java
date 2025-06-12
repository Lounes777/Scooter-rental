package model;
import java.io.*;
import java.util.*;
import java.io.Serializable;

public class Permis implements Serializable {

    private static int inc = 1;
    private int id_permis;
    private String type_permis;
    private List<Client> clients = new ArrayList<Client>();
    private List<Modele> modeles = new ArrayList<Modele>();

    public Permis(String type) {
        this.id_permis = inc++;
        this.type_permis = type;
    }

    public int getId() {
        return id_permis;
    }

    public void setId_permis(int id_permis) {
        this.id_permis = id_permis;
    }

    public String getType_permis() {
        return type_permis;
    }

    public void setType_permis(String type_permis) {
        this.type_permis = type_permis;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Modele> getModeles() {
        return modeles;
    }

    public void setModeles(List<Modele> modeles) {
        this.modeles = modeles;
    }

    public void addMarque(Modele modele) {
        if (modele != null) {
            modeles.add(modele);
        } else {
            System.err.println("Le modele que tu as ajoutée est null");
        }
    }

    public void addClient(Client client) {
        if (client != null) {
            clients.add(client);
        } else {
            System.err.println("Le client que tu as ajouté est null");
        }
    }

    public String printData() {
        StringBuilder result = new StringBuilder();
        result.append("Permis [id: ").append(id_permis)
              .append(", type: ").append(type_permis).append("]\n");

        result.append("Clients: ");
        for (int i = 0; i < clients.size(); i++) {
            result.append(clients.get(i).getNom()).append(" ").append(clients.get(i).getPrenom());
            if (i < clients.size() - 1) result.append(", ");
        }
        result.append("\n");

        result.append("Modèles: ");
        for (int i = 0; i < modeles.size(); i++) {
            result.append(modeles.get(i).getModeleNom());
            if (i < modeles.size() - 1) result.append(", ");
        }
        result.append("\n");

        return result.toString();
    }
}
