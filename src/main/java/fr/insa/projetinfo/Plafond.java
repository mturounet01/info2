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
 * @author Justin PRADIE
 */
public class Plafond {
    public int  idPlafond;
    public ArrayList<Mur> Mur;
    public ArrayList<Coin> Coin;
    private int Rev;
    
    public Plafond(int idPlafond, ArrayList<Mur> Mur ,ArrayList<Coin> Coin ){
        this.idPlafond=idPlafond;
        this.Mur=Mur;
        this.Coin=Coin;
         }
    
    public double surface(){
        Mur M1 = Mur.get(0);
        Mur M2 = Mur.get(1);
        return M1.longueur()*M2.longueur();
        
    }
    public int Revet(){
        System.out.println("Veuillez choisir le revetements associé à ce plafond");
        //Cette partie va être a modifer lors du passage en JavaFX
        int a=Lire.i();
        return a;
     }
     public int getIdPlafond(){
    return this.idPlafond;
    }
    public int getRev() {
        return Rev;
    }
     public void AddRev (int i){
     this.Rev=i;   
    }
    public void save (Writer w) throws IOException {
        w.append("Plafond;"+idPlafond+";"+this.Coin.get(0).getIdCoin()+";"+this.Coin.get(1).getIdCoin()+";"+this.Coin.get(2).getIdCoin()+";"+this.Coin.get(3).getIdCoin()+";"+this.Rev+";"+ "\n");
    }
}
