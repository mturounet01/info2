/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.projetinfo;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

/**
 *
 * @author antoinez
 */
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class Niveau {
    public int idNiveau;
    private double hauteurSousPlafond;
    ArrayList<Appartement> appartements = new ArrayList();

    public Niveau(int idNiveau, double hauteur) {
        this.idNiveau = idNiveau;
        this.hauteurSousPlafond = hauteur;
    }

    public void addAppartement(Appartement appart) {
        this.appartements.add(appart);
    }

    public int getIdNiveau() {
        return this.idNiveau;
    }

    public ArrayList<Appartement> getAppart() {
        return this.appartements;
    }

    public double getHauteurSousPlafond() {
        return this.hauteurSousPlafond;
    }

    

    public void addHauteurSousPlafond(double hauteur) {
        this.hauteurSousPlafond = hauteur;
    }
}
