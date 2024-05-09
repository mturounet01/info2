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
 * @author Justin PRADIE
 */
public class Mur {
    int idMur;       //privé par défaut (on peut pas les utliser en dehors de cette classe)
    Coin debut;
    Coin fin;
    int IdRev;

    public Mur(int idMur, Coin debut, Coin fin) {
        this.idMur = idMur;
        this.debut = debut;
        this.fin = fin;
    }
    
    public double longueur(){
       return Math.sqrt(Math.pow(debut.getX()-fin.getX(), 2) + Math.pow(debut.getY()-fin.getY(),2))/100;
       
    }

    public double surface(double h){
        return h*this.longueur(); 
    }
    
    public Coin getdebut (){
    return this.debut;
    
    }
    
    public Coin getfin (){
    return this.fin;
    }
    
    public int getIdMur (){
    return this.idMur;
    }
    public int getRev() {
    return this.IdRev;
    }
    
    
    public int Revet(){
        System.out.println("Veuillez choisir le revetements associé à ce mur");
        //Cette partie va être a modifer lors du passage en JavaFX
        int a=Lire.i();
        return a;
    }
    public void save (Writer w) throws IOException {
        w.append("Mur;"+idMur+";"+this.debut.getIdCoin()+";"+this.fin.getIdCoin()+";"+this.IdRev+";"+ "\n");
    }
    public void AddRev(int rev){
    this.IdRev=rev;
    }}

    
