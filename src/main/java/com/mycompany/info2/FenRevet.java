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
/**
 *
 * @author Emilien
 */
public class FenRevet {
    
    private ArrayList<Piece> pieces = new ArrayList();
    private ArrayList<Mur> Mur = new ArrayList();
    private ArrayList<Sol> soltot = new ArrayList();
    private ArrayList<Plafond> plafondtot = new ArrayList();
    private ArrayList<ComboBox<String>> combo= new ArrayList();
    private ArrayList<ComboBox<String>> combop= new ArrayList();
    private ArrayList<ComboBox<String>> combos= new ArrayList();
    private ArrayList<Mur> Murtot = new ArrayList();
    private Mur mur;
    private Sol sol;
    private Plafond plafond;
    public CheckBox CheckMur;
    public CheckBox CheckSol;
    public CheckBox CheckPlafond;
    private Button valider;
    private Button close;
    private Button valider1;
    private Button valider2;
    
    
   
    
    public FenRevet (Appartement appart){
        Stage FenRevet = new Stage();
        pieces=appart.getPieces();
        
        CheckBox CheckMur = new CheckBox("Mur");
        this.CheckMur = CheckMur;
        CheckBox CheckSol = new CheckBox("Sol");
        this.CheckSol = CheckSol;
        CheckBox CheckPlafond = new CheckBox("Plafond");
        this.CheckPlafond = CheckPlafond;
        Button valider = new Button("Valider");
        this.valider=valider;
        Button valider1 = new Button("Valider");
        this.valider1=valider;
        Button valider2 = new Button("Valider");
        this.valider2=valider;
        Button close = new Button("Close");
        this.close=close;
        
        BorderPane revett = new BorderPane();
        HBox revet = new HBox();
        VBox revet1 = new VBox();
        revett.setTop(revet);
        revett.setLeft(revet1);
        revet.setSpacing(20);
        
        revet.getChildren().addAll(CheckMur,CheckSol,CheckPlafond,close);
        
        Scene revete = new Scene(revett,500,500);
    
        FenRevet.setScene(revete);
        FenRevet.show();
        
       CheckMur.setOnAction(event -> {
          CheckSol.setSelected(false);
          CheckPlafond.setSelected(false);
          revet1.getChildren().clear();
          Murtot.clear();
          for (Piece pieceE : pieces){
          Mur=pieceE.getMur();
         
           for (Mur Mur : Mur){
               Murtot.add(Mur);
               Label label=new Label("Pieces"+" "+pieceE.getIdPiece()+" "+"Mur"+" "+Mur.getIdMur());
               ComboBox<String> MurComboBox = new ComboBox<>();
               combo.add(MurComboBox);
               MurComboBox.setPromptText("Revetement");
               MurComboBox.getItems().addAll("Peinture bas de Gamme","Peinture moyen de Gamme","Peinture haut de Gamme","Carrelage bas de Gamme","Carrelage haut de Gamme","Lambris bas de Gamme","Lambris Haut de Gamme","Marbre","Crepi","Papier Peint","Plaquettes de parement","Liege");
               revet1.getChildren().addAll(label,MurComboBox);
                } 
           }
          revet1.getChildren().addAll(valider);
      }); 
       
      valider.setOnAction(event -> {
          int i=0;
        for (ComboBox<String> Combo : combo){
            
            if (Combo.getValue()==null){
                Combo.setValue("Peinture bas de Gamme");
            }
            
            switch (Combo.getValue()){
              case "Peinture bas de Gamme":
                  Murtot.get(i).AddRev(1);
              break;
              case "Peinture moyen de Gamme":
                   Murtot.get(i).AddRev(9);
              break;
               case "Peinture haut de Gamme":
                   Murtot.get(i).AddRev(8);
              break;
              case "Carrelage bas de Gamme":
                   Murtot.get(i).AddRev(2);
              break;
              case "Carrelage haut de Gamme":
                   Murtot.get(i).AddRev(19);
              break;
              case "Lambris bas de Gamme":
                  Murtot.get(i).AddRev(11);
              break;
              case "Lambris Haut de Gamme":
                  Murtot.get(i).AddRev(3);
              break;
              case "Marbre":
                  Murtot.get(i).AddRev(4);
              break;
              case "Crepi":
                  Murtot.get(i).AddRev(5);
              break;
              case "Papier Peint":
                   Murtot.get(i).AddRev(6);
              break;
              case "Plaquettes de parement":
                  Murtot.get(i).AddRev(7);
              break;
              case "Liege":
                  Murtot.get(i).AddRev(12);
              break;
             }i=i+1;
        
      }
      });
      CheckSol.setOnAction(event -> {
          CheckPlafond.setSelected(false);
          CheckMur.setSelected(false);
          revet1.getChildren().clear();
          soltot.clear();
          for (Piece pieceE : pieces){
          soltot.add(pieceE.Getsol());   
          }
          
         for (Sol sol : soltot){
              Label label=new Label("Sol de la Pieces"+" "+sol.getIdSol());
              ComboBox<String> SolComboBox = new ComboBox<>();
              combos.add(SolComboBox);
              SolComboBox.setPromptText("Revetement");
              SolComboBox.getItems().addAll("Carrelage bas de Gamme","Carrelage haut de Gamme","Lambris bas de Gamme","Lambris Haut de Gamme","Marbre","Liege bas de Gamme","Liege Haut de Gamme","Parquet","Vinyle Lino","Moquette","Stratifié","Gazon");
              revet1.getChildren().addAll(label,SolComboBox);
         }
          revet1.getChildren().addAll(valider1);
      }); 
      
      valider1.setOnAction(event -> {
      int i=0;
      for (ComboBox<String> Combo : combos){
            if (Combo.getValue()==null){
                Combo.setValue("Carrelage bas de Gamme");
            }
            switch (Combo.getValue()){
              case "Carrelage bas de Gamme":
                   soltot.get(i).AddRev(2);
              break;
              case "Carrelage haut de Gamme":
                   soltot.get(i).AddRev(19);
              break;
              case "Lambris bas de Gamme":
                  soltot.get(i).AddRev(11);
              break;
              case "Lambris Haut de Gamme":
                  soltot.get(i).AddRev(3);
              break;
              case "Marbre":
                  soltot.get(i).AddRev(4);
              break;
              case "Liege bas de Gamme":
                  soltot.get(i).AddRev(12);
              break;
              case "Liege Haut de Gamme":
                   soltot.get(i).AddRev(18);
              break;
              case "Parquet":
                   soltot.get(i).AddRev(13);
              break;
              case "Vinyle Lino":
                   soltot.get(i).AddRev(14);
              break;
              case "Moquette":
                  soltot.get(i).AddRev(15);
              break;
              case "Stratifié":
                   soltot.get(i).AddRev(16);
              break;
               case "Gazon":
                   soltot.get(i).AddRev(17);
              break;
              }
            i=i+1;
        }
      });
      
      CheckPlafond.setOnAction(event -> {
          
          CheckSol.setSelected(false);
          CheckMur.setSelected(false);
           
          revet1.getChildren().clear();
          plafondtot.clear();
          for (Piece pieceE : pieces){
          plafondtot.add(pieceE.GetPlafond());   
         }
          
         for (Plafond plafond : plafondtot){
              Label label=new Label("Plafond de la Piece"+" "+plafond.getIdPlafond());
              ComboBox<String> PlafondComboBox = new ComboBox<>();
              combop.add(PlafondComboBox);
              PlafondComboBox.setPromptText("Revetement");
              PlafondComboBox.getItems().addAll("Peinture bas de Gamme","Peinture moyen de Gamme","Peinture haut de Gamme","Papier Peint");
              revet1.getChildren().addAll(label,PlafondComboBox);
         }
          revet1.getChildren().addAll(valider2);
      }); 
      
      valider2.setOnAction(event -> {
      int i=0;
      for (ComboBox<String> Combo : combop){
            if (Combo.getValue()==null){
                Combo.setValue("Peinture bas de Gamme");
            }
             switch (Combo.getValue()){
              case "Peinture bas de Gamme":
                  plafondtot.get(i).AddRev(1);
              break;
              case "Peinture moyen de Gamme":
                   plafondtot.get(i).AddRev(9);
              break;
               case "Peinture haut de Gamme":
                   plafondtot.get(i).AddRev(8);
              break;
              case "Papier Peint":
                   plafondtot.get(i).AddRev(6);
              break;
        }
            i=i+1;
      }
      });
      
      
      
      close.setOnAction(event -> {
      FenRevet.close();
      });      
       
    }
    public CheckBox getCheckMur() {
        return this.CheckMur;
    }
    public CheckBox getCheckSol() {
        return this.CheckSol;
    }
    public CheckBox getCheckPlafond() {
        return this.CheckPlafond;
    }
    
}
