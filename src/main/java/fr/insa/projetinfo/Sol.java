/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.projetinfo;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

/**s
 *
 * @author antoinez
 */
import java.util.ArrayList;
import java.io.IOException;
import java.io.Writer;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class Sol {
    private int idSol;
    private ArrayList<Mur> murs;
    private ArrayList<Coin> coins;
    private int rev;
    private ArrayList<Revetement> revetements;

    public Sol(int idSol, ArrayList<Mur> murs, ArrayList<Coin> coins){
        this.idSol = idSol;
        this.murs = murs;
        this.coins = coins;
        revetements = new ArrayList<>();
    }

    public double surface() {
        Mur mur1 = murs.get(0);
        Mur mur2 = murs.get(1);
        return mur1.longueur() * mur2.longueur();
    }

    public int getIdSol() {
        return idSol;
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

    public void save(Writer w) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("Sol;");
        sb.append(idSol).append(";");
        for (Coin coin : coins) {
            sb.append(coin.getIdCoin()).append(";");
        }
        sb.append(rev).append(";\n");
        w.append(sb.toString());
    }
}
