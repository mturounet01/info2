/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.projetinfo;

import java.io.IOException;
import java.io.Writer;
import java.lang.Math;

import java.io.IOException;
import java.io.Writer;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import java.util.ArrayList;

import java.util.ArrayList;
/**
 *
 * @author antoinez
 */

public class Mur {
    private int idMur;
    private Coin debut;
    private Coin fin;
    private int idRev;
    private ArrayList<Revetement> revetements;

    private int nbPortes;
    private int nbFenetres;

    private static final double SURFACE_PORTE = 2.0;  // Exemples de surfaces en mètres carrés
    private static final double SURFACE_FENETRE = 1.5;

    // Prix fixe des portes et des fenêtres
    public static final double PRIX_PORTE = 20.0; // Prix d'une porte en euros
    public static final double PRIX_FENETRE = 10.0; // Prix d'une fenêtre en euros

    public Mur(int idMur, Coin debut, Coin fin) {
        this.idMur = idMur;
        this.debut = debut;
        this.fin = fin;
        this.revetements = new ArrayList<>();
        this.nbPortes = 0;
        this.nbFenetres = 0;
    }
    
    public double longueur(){
        return Math.sqrt(Math.pow(debut.getX() - fin.getX(), 2) + Math.pow(debut.getY() - fin.getY(), 2)) / 100;
    }

    public double surface(double h){
        return h * this.longueur(); 
    }
    
    public Coin getDebut (){
        return this.debut;
    }
    
    public Coin getFin (){
        return this.fin;
    }
    
    public int getIdMur (){
        return this.idMur;
    }
    
    public int getRev() {
        return this.idRev;
    }
    
    public void addRev(int rev) {
        this.idRev = rev;
    }

    public ArrayList<Revetement> getRevetements() {
        return revetements;
    }

    public void addRevetement(Revetement revetement) {
        revetements.add(revetement);
    }

    public int getIdCoinDebut() {
        return this.debut.getIdCoin();
    }
    
    public int getIdCoinFin() {
        return this.fin.getIdCoin();
    }

    public int getNbPortes() {
        return nbPortes;
    }

    public void setNbPortes(int nbPortes) {
        this.nbPortes = nbPortes;
    }

    public int getNbFenetres() {
        return nbFenetres;
    }

    public void setNbFenetres(int nbFenetres) {
        this.nbFenetres = nbFenetres;
    }

    // Méthode pour calculer le coût total des portes
    public double coutPortes() {
        return nbPortes * PRIX_PORTE;
    }

    // Méthode pour calculer le coût total des fenêtres
    public double coutFenetres() {
        return nbFenetres * PRIX_FENETRE;
    }

    // Méthode pour calculer le coût total des ouvertures (portes + fenêtres)
    public double coutTotalOuvertures() {
        return coutPortes() + coutFenetres();
    }
}
