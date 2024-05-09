/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.projetinfo;

import java.util.ArrayList;

/**
 *
 * @author Justin PRADIE
 */
public class Maison {
    public int idMaison;
   

    public Maison(int idMaison) { //voir pour Array list
        this.idMaison = idMaison;
        
    }
   // private double surface(){
       // double hsp;
        //hsp = Lire.d();
        //return hsp*this.longueur();
    public double surface(){
        
        return 0;
        
    }
    public void afficher(){
        System.out.println("Maison" + idMaison );
      //for (Niveau niveau : niveau){
       // niveau.afficher();
    }
}

    
