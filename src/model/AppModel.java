package model;
import java.io.*;
import java.util.*;

public class AppModel {
    private List<Object> allObjects;

    public AppModel() {
        File dataFile = new File("Data.txt");
        if (dataFile.exists()) {
            loadAllData();
        } else {
            allObjects = new ArrayList<>();
        }
    }

    public List<Object> getAllObjects() {
        return allObjects;
    }

    public void saveAllData() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Data.txt"))) {
            out.writeObject(allObjects);
            System.out.println("données sauvgaradées avec succès.");
        } catch (IOException e) {
            System.err.println("Error dans le sauvgarde données: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadAllData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Data.txt"))) {
            allObjects = (List<Object>) in.readObject();
            System.out.println("données chargées avec succès.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error dans le loading des données: " + e.getMessage());
        }
    }

    public <T> T findOrCreate(T newObject, int id) {
        for (Object obj : allObjects) {
            if (obj.getClass() == newObject.getClass()) {
                try {
                    int existingId = (int) obj.getClass().getMethod("getId").invoke(obj);
                    if (existingId == id) {
                        return (T) obj;
                    }
                } catch (Exception e) {
                    System.err.println("Error comparing objects: " + e.getMessage());
                }
            }
        }
        allObjects.add(newObject);
        return newObject;
    }

    public void initializeData() {
        //crée ou mettre a jour les objets
        Marque BMW = findOrCreate(new Marque("BMW"), 1);
        Modele MP40 = findOrCreate(new Modele("MP40", "v_twin", 150, BMW), 1);
        Parc_Scooter parc1 = findOrCreate(new Parc_Scooter("Louvre", 200), 1);
        Scooter Scot1 = findOrCreate(new Scooter(MP40, parc1), 1);

        Marque Yamaha = findOrCreate(new Marque("Yamaha"), 2);
        Modele XMax = findOrCreate(new Modele("XMax", "parallel_twin", 180, Yamaha), 2);
        Parc_Scooter parc2 = findOrCreate(new Parc_Scooter("Montparnasse", 150), 2);
        Scooter Scot2 = findOrCreate(new Scooter(XMax, parc1), 2);

        Marque Honda = findOrCreate(new Marque("Honda"), 3);
        Modele PCX = findOrCreate(new Modele("PCX", "single", 125, Honda), 3);
        Parc_Scooter parc3 = findOrCreate(new Parc_Scooter("Châtelet", 100), 3);
        Scooter Scot3 = findOrCreate(new Scooter(PCX, parc1), 3);

        Marque Ducati = findOrCreate(new Marque("Ducati"), 4);
        Modele Monster = findOrCreate(new Modele("Monster", "v_twin", 200, Ducati), 4);
        Parc_Scooter parc4 = findOrCreate(new Parc_Scooter("La Défense", 250), 4);
        Scooter Scot4 = findOrCreate(new Scooter(Monster, parc1), 4);

        Permis permisA = findOrCreate(new Permis("A"), 1);
        Permis permisB = findOrCreate(new Permis("B"), 2);

        Client client1 = findOrCreate(new Client("Djellab", 123456789, "Hamou", new Date(1995 - 1900, Calendar.JANUARY, 10), parc1), 1);
        Client client2 = findOrCreate(new Client("Medjbour", 987654321, "Lounes", new Date(1990 - 1900, Calendar.MARCH, 25), parc1), 2);

        //populé les collections
        parc1.addMarque(BMW);
        parc1.addScooter(Scot1);
        parc1.addClient(client1);

        parc2.addMarque(Yamaha);
        parc1.addScooter(Scot2);
        parc1.addClient(client2);

        parc3.addMarque(Honda);
        parc1.addScooter(Scot3);

        parc4.addMarque(Ducati);
        parc1.addScooter(Scot4);

        BMW.addModels(MP40);
        Yamaha.addModels(XMax);
        Honda.addModels(PCX);
        Ducati.addModels(Monster);

        MP40.addScooter(Scot1);
        XMax.addScooter(Scot2);
        PCX.addScooter(Scot3);
        Monster.addScooter(Scot4);

        permisA.addClient(client1);
        permisB.addClient(client2);

        permisA.addMarque(MP40);
        permisB.addMarque(XMax);
    }
}
