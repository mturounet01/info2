/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.projetinfo;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import javafx.scene.control.Alert;

/**
 *
 * @author Justin PRADIE
 */
public class Batiment {
    private String nomBat;
    public ArrayList<Niveau> niveaux=new ArrayList();
    
    
    public void addName (String name) {
        this.nomBat=name;
    }
    
    public void addNiveau (Niveau niveau){
        this.niveaux.add(niveau);
    }     
    
   
    
    public double surfaceRevetements(int idRevetement){
       //A faire
       return 0;
    }
    public double devisRevetement (int idRevetement){
        //a faire    
    return 0;
    }
    public  ArrayList<Niveau> getNiveau (){
        return this.niveaux;
    }
    
     public void save (Writer w) throws IOException {
        w.append("batiment;"+nomBat+";");
        for (Niveau Niveau : niveaux){
             w.append(Niveau.getIdNiveau()+";");
        }
        w.append(""+"\n");
    }
    
}