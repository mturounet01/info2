/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.projetinfo;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author antoinez
 */

public class Revetement {
    private final int id;
    private final String nom;
    private final boolean mur;
    private final boolean sol;
    private final boolean plafond;
    private final double prix;
    private final String type;

    public Revetement(int id, String nom, boolean mur, boolean sol, boolean plafond, double prix, String type) {
        this.id = id;
        this.nom = nom;
        this.mur = mur;
        this.sol = sol;
        this.plafond = plafond;
        this.prix = prix;
        this.type = type;
    }

    public static List<Revetement> chargerRevetements(String fichierRevetements) throws IOException {
        List<Revetement> revetements = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fichierRevetements))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                try {
                    String[] parts = ligne.split(";");
                    if (parts.length < 6) {
                        throw new IllegalArgumentException("Ligne incorrecte : " + ligne);
                    }
                    int id = Integer.parseInt(parts[0]);
                    String nom = parts[1];
                    boolean mur = parts[2].equals("1");
                    boolean sol = parts[3].equals("1");
                    boolean plafond = parts[4].equals("1");
                    double prix = Double.parseDouble(parts[5]);
                    String type = parts.length > 6 ? parts[6] : "inconnu"; // Ajouter un type par défaut
                    Revetement revetement = new Revetement(id, nom, mur, sol, plafond, prix, type);
                    revetements.add(revetement);
                } catch (NumberFormatException e) {
                    System.err.println("Erreur de format numérique dans la ligne : " + ligne);
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    System.err.println("Erreur de parsing de la ligne : " + ligne);
                    e.printStackTrace();
                }
            }
        }
        return revetements;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }
    public String getType() {
        return type;
    }
}
