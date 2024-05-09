/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.info2;

import fr.insa.projetinfo.*;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.HBox;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import java.io.*;
import java.util.*;
/**
 *
 * @author Emilien
 */
public class Devis extends BorderPane{
    private Label tot;
    private Button close ;
    private double a;
    private ArrayList<Appartement> apparts;
    private ArrayList<Piece> pieces;
    private Sol sol;
    private Plafond plaf;
    private ArrayList<Mur> Murs;
    
    public Devis (ArrayList<Niveau> niveaux){
          Stage FenDevis = new Stage();
          Lecture lec =new Lecture();
          a=0;
          for (Niveau NV : niveaux){
              apparts=NV.getAppart();
              for (Appartement appart: apparts){
                  pieces=appart.getPieces();
                  for (Piece piece : pieces){
                    sol=piece.Getsol();
                    a=a+(lec.recupprix(sol.Rev())*sol.surface());
                    plaf=piece.GetPlafond();
                    a=a+(lec.recupprix(plaf.getRev())*plaf.surface());
                    Murs=piece.getMur();
                    for (Mur mur: Murs){
                        a=a+(lec.recupprix(mur.getRev())*mur.surface(NV.geth()));//Voir pour la hauteur
                    }
                  }
              }
          }
          
          Label Tot = new Label("Le devis Global est "+a+" euros");
          Button close = new Button("close");
          this.close=close;
          
           BorderPane Deviss = new BorderPane();
           VBox total = new VBox();
           total.getChildren().addAll(Tot,close);
           Deviss.setTop(total);
           
           
        Scene Devis = new Scene(Deviss,200,200);
        FenDevis.setScene(Devis);
        FenDevis.show();
        close.setOnAction(event-> {
            FenDevis.close();
        });
    }
    
}
