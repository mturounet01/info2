/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.projetinfo;

import java.io.IOException;
import java.io.Writer;
import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author antoine
 */
public class Appartement {
    public int idAppartement;
     ArrayList<Piece> pieces = new ArrayList();
    private int idNiveau;
    
    public Appartement (int id,int n){
        this.idAppartement=id;
        this.idNiveau=n;
    }
    
    public double surface(){
        double surfaceTotale=0.0;
        for (Piece piece : pieces){
            surfaceTotale += piece.surface();
           }
        return surfaceTotale;
    }

    public void addPiece (Piece piece){
        this.pieces.add(piece);
    }
    public int getIdAppartement (){
     return this.idAppartement;
    }
    public ArrayList<Piece> getPieces(){
    return this.pieces;
    }
    
    
    
    
}
    