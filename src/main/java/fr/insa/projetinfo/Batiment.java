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
 * @author antoine
 */
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class Batiment {
    private String nomBat;
    private ArrayList<Niveau> niveaux;

    public Batiment() {
        niveaux = new ArrayList<>();
    }

    public String getNomBat(String nomBat) {
        return nomBat;
    }

    public void setNomBat(String nomBat) {
        this.nomBat = nomBat;
    }

    public ArrayList<Niveau> getNiveau() {
        return niveaux;
    }

    public void addNiveau(Niveau niveau) {
        niveaux.add(niveau);
    }
    

   
    }
