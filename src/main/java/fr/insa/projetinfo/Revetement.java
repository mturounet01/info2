/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.projetinfo;


/**
 *
 * @author Justin PRADIE
 */
public abstract class Revetement {
    public int idRevetement;
    public double prixunitaire;

    public Revetement(int idRevetement, double prixunitaire) {
        this.idRevetement = idRevetement;
        this.prixunitaire = prixunitaire;
    }
    public abstract double montant(Mur m);
    }
