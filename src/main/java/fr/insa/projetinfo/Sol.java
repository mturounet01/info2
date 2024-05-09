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
 * @author Justin PRADIE
 */
public class Sol {
    public int idSol;
    public ArrayList<Mur> Mur;
    public ArrayList<Coin> Coin;
    private int Rev;
    
    public Sol(int idSol,ArrayList<Mur> Mur , ArrayList<Coin> Coin){
        this.idSol=idSol;
        this.Mur=Mur;
        this.Coin=Coin;
    }
    
    public double surface (){
        Mur M1 = Mur.get(0);
        Mur M2 = Mur.get(1);
        return M1.longueur()*M2.longueur();
    }
    public int getIdSol(){
    return this.idSol;
    }
    public void AddRev (int i){
     this.Rev=i;   
    }
    public int Rev (){
       return Rev;
    }
    
    public void save (Writer w) throws IOException {
        w.append("Sol;"+idSol+";"+this.Coin.get(0).getIdCoin()+";"+this.Coin.get(1).getIdCoin()+";"+this.Coin.get(2).getIdCoin()+";"+this.Coin.get(3).getIdCoin()+";"+this.Rev+";"+ "\n");
    }
}