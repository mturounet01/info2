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
import java.util.ArrayList;
import java.io.IOException;
import java.io.Writer;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class Plafond {
    private int idPlafond;
    private ArrayList<Mur> murs;
    private ArrayList<Coin> coins;
    private int rev;
    private ArrayList<Revetement> revetements;

    public Plafond(int idPlafond, ArrayList<Mur> murs, ArrayList<Coin> coins){
        this.idPlafond = idPlafond;
        this.murs = murs;
        this.coins = coins;
        revetements = new ArrayList<>();
    }

    public double surface(){
        Mur mur1 = murs.get(0);
        Mur mur2 = murs.get(1);
        return mur1.longueur() * mur2.longueur();
    }

    public int getIdPlafond(){
        return idPlafond;
    }

    public void addRev(int rev) {
        this.rev = rev;   
    }

    public int getRev() {
        return rev;
    }

    public void addRevetement(Revetement revetement) {
        revetements.add(revetement);
    }

    public ArrayList<Revetement> getRevetements() {
        return revetements;
    }

    public ArrayList<Coin> getCoins() {
        return coins;
    }

    
}
