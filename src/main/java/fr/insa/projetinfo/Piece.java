/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.projetinfo;

import java.lang.Math;
import java.util.ArrayList;
import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;
/**
 *
 * @author antoine
 */
public class Piece {
    private static final AtomicInteger idCounter = new AtomicInteger(0);
    public int idPiece;
    ArrayList<Mur> Mur = new ArrayList();
    ArrayList<Coin> Coin = new ArrayList(); 
    public Sol sol =new Sol(idPiece,Mur,Coin);
    public Plafond plafond = new Plafond(idPiece,Mur,Coin);
    
    public Piece(int idPiece) {
       this.idPiece = idCounter.incrementAndGet();
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
   
    public Sol getsol (){
    return this.sol;
    }
    public Plafond getPlafond(){
    return this.plafond;
    }
    
}