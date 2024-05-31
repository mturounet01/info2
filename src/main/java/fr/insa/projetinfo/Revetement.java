/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.projetinfo;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Revetement {
    private int id;
    private String nom;
    private boolean mur;
    private boolean sol;
    private boolean plafond;
    private double prix;
    private String type;
    public Revetement(int id, String nom, boolean mur, boolean sol, boolean plafond, double prix) {
        this.id = id;
        this.nom = nom;
        this.mur = mur;
        this.sol = sol;
        this.plafond = plafond;
        this.prix = prix;
        this.type= type;
    }

    public static ArrayList<Revetement> chargerRevetements(String fichierRevetements) throws IOException {
        ArrayList<Revetement> revetements = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fichierRevetements));
        String ligne;
        while ((ligne = reader.readLine()) != null) {
            String[] parts = ligne.split(";");
            int id = Integer.parseInt(parts[0]);
            String nom = parts[1];
            boolean mur = parts[2].equals("1");
            boolean sol = parts[3].equals("1");
            boolean plafond = parts[4].equals("1");
            double prix = Double.parseDouble(parts[5]);
            Revetement revetement = new Revetement(id, nom, mur, sol, plafond, prix);
            revetements.add(revetement);
        }
        reader.close();
        return revetements;
    }
    public int getId() {
        return id;
    }
    public String getType() {
        return type;
    }
    public double getPrix() {
        return prix;
    }

    public boolean isApplicableMur() {
        return mur;
    }

    public boolean isApplicableSol() {
        return sol;
    }

    public boolean isApplicablePlafond() {
        return plafond;
    }
}
