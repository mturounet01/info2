/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.projetinfo;

import java.io.IOException;
import java.io.Writer;
import java.lang.Math;

/**
 *
 * @author antoinez
 */
import java.io.IOException;
import java.io.Writer;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class Mur {
    private int idMur;
    private Coin debut;
    private Coin fin;
    private int idRev;
    private ArrayList<Revetement> revetements;

    public Mur(int idMur, Coin debut, Coin fin) {
        this.idMur = idMur;
        this.debut = debut;
        this.fin = fin;
        revetements = new ArrayList<>();
    }
    
    public double longueur(){
        return Math.sqrt(Math.pow(debut.getX()-fin.getX(), 2) + Math.pow(debut.getY()-fin.getY(),2))/100;
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
    
    public int Revet(){
        System.out.println("Veuillez choisir le revetement associé à ce mur :");
        // Cette partie va être à modifier lors du passage en JavaFX
        int a = Lire.i(); // Je suppose que Lire.i() lit un entier depuis l'entrée standard
        return a;
    }
    
    public void save (Writer w) throws IOException {
        w.append("Mur;" + idMur + ";" + this.debut.getIdCoin() + ";" + this.fin.getIdCoin() + ";" + this.idRev + ";\n");
    }
    
    public int getIdCoinDebut() {
        return this.debut.getIdCoin();
    }
    
    public int getIdCoinFin() {
        return this.fin.getIdCoin();
    }
}
