/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.projetinfo;

import java.lang.Math;
import java.util.ArrayList;
import java.io.*;
/**
 *
 * @author Justin PRADIE
 */
public class Piece {
    public int idPiece;
    ArrayList<Mur> Mur = new ArrayList();
    ArrayList<Coin> Coin = new ArrayList(); 
    public Sol sol =new Sol(idPiece,Mur,Coin);
    public Plafond plafond = new Plafond(idPiece,Mur,Coin);
    
    public Piece(int idPiece) {
        this.idPiece = idPiece;  
    }
    
    public void addCoin(Coin Coin){
        this.Coin.add(Coin);
    }
    
    public void addMur(Mur Mur){
        this.Mur.add(Mur);
    
    }
    public ArrayList<Mur> getMur (){
    return this.Mur;
    }
    public ArrayList<Coin> getCoin(){
    return this.Coin;
    }
   
    public double surface (){
           return sol.surface();
    } 
    public int getIdPiece(){
        return this.idPiece;
    }
    public void save (Writer w) throws IOException {
    w.append("Piece;"+idPiece+";"+this.sol.getIdSol()+";"+this.plafond.getIdPlafond()+";"+this.Mur.get(0).getIdMur()+";"+this.Mur.get(1).getIdMur()+";"+this.Mur.get(2).getIdMur()+";"+this.Mur.get(3).getIdMur()+";"+ "\n");
    }
    public Sol Getsol (){
    return this.sol;
    }
    public Plafond GetPlafond(){
    return this.plafond;
    }
}