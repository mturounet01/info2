/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.info2;

import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Justin PRADIE
 */
public class Choix extends VBox {
    public Button boutonvalide;
    public CheckBox maisonCheckBox;
    public ComboBox niveauComboBox;
    public ComboBox appartComboBox;
    public ComboBox PieceComboBox;
    public TextField Titre;
    public CheckBox ImmeubleCheckBox;
    private TextField hauteur ;
    
    public Choix(){
        // Création des éléments graphiques
        Label titleLabel = new Label("Veuillez saisir le titre de votre projet:");
        TextField Titre = new TextField();
        this.Titre = Titre;
        
      
        
        CheckBox maisonCheckBox = new CheckBox("Maison");
        this.maisonCheckBox = maisonCheckBox;
        
        CheckBox immeubleCheckBox = new CheckBox("Immeuble");
        this.ImmeubleCheckBox = immeubleCheckBox; 
                
        ComboBox<Integer> niveauxComboBox = new ComboBox<>();
        this.niveauComboBox= niveauxComboBox;
        
        ComboBox<Integer> appartComboBox = new ComboBox<>();
        this.appartComboBox= appartComboBox;
        
        
        Button boutonvalide = new Button("Valider");
        this.boutonvalide = boutonvalide;
        boutonvalide.setPrefWidth(120);

        // Configuration de la ComboBox pour le choix du nombre de niveaux
        niveauxComboBox.getItems().addAll(1, 2, 3, 4); // Exemple : 4 niveaux possibles
        niveauxComboBox.setPromptText("Sélectionnez le nombre de niveaux");
        
        //Configuration de la ComboBox pour le choix du nombre d'appartement par niveau
        appartComboBox.getItems().addAll(1, 2, 3, 4); // Exemple : 4 appart possibles
        appartComboBox.setPromptText("Sélectionnez le nombre d'appartements");
        
        // Création du conteneur principal et configuration de la mise en page
         setSpacing(20);
       setAlignment(Pos.CENTER);
       getChildren().addAll(titleLabel, Titre, maisonCheckBox, immeubleCheckBox, niveauxComboBox);
       
        

      
    }
    
    public CheckBox getmaisonCheckBox() {
        return maisonCheckBox;
        
    }
    public CheckBox getImmeubleCheckBox() {
        return ImmeubleCheckBox;
    }
    public Button getboutonvalide() {
        return boutonvalide;
    }
    public String getniveauComboBox(){
        String val= niveauComboBox.getSelectionModel().getSelectedItem().toString();
    return val;
    }
    public String getTitre(){
    return Titre.getText();
    }
    public String getappartComboBox(){
        String val="0";
        if (appartComboBox.getSelectionModel().getSelectedItem()!=null){
          val= appartComboBox.getSelectionModel().getSelectedItem().toString();
        }
          
      return val;
    }
  
    
    
    
}
