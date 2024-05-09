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
public class Niveau {
    public int idNiveau;
    private double h ;
     ArrayList<Appartement> Appartement = new ArrayList();
    
    public Niveau(int idNiveau,double hauteur){
        this.idNiveau = idNiveau;
        this.h=hauteur;
    }
   
    public void addAppartement(Appartement appart){
        this.Appartement.add(appart);
    }
   public void addh (double h ){
     this.h=h;
   }
   public int getIdNiveau (){
    return this.idNiveau;
   }
   public ArrayList<Appartement> getAppart(){
   return this.Appartement;
   }
   
    public void save (Writer w) throws IOException {
        h=2.30;
        w.append("Niveau;"+idNiveau+";"+h+";");
        for (Appartement appartement : Appartement){
             w.append(appartement.getIdAppartement()+";");
        }
        w.append(""+"\n");
    }
    public double geth (){
        return h;
    }
    public void addH (double h ){
    this.h=h;
    }
    
}
