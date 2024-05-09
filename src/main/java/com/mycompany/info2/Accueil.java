/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.info2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 *
 * @author Justin PRADIE
 */
public class Accueil extends VBox {
    
    private Button createProjectButton;
    private Button openProjectButton;
    
    public Accueil (){
        
        Text titleText = new Text("Batichoc");
        titleText.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        
        Text descriptionText = new Text("Faire le devis de votre bâtiment");
        descriptionText.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
        
        Button createProjectButton = new Button("Créer projet");
        this .createProjectButton = createProjectButton;
        createProjectButton.setPrefWidth(120);
        
         Button openProjectButton = new Button("Ouvrir un projet");
         this.openProjectButton = openProjectButton;
        openProjectButton.setPrefWidth(120);
       
     
       setSpacing(20);
       setAlignment(Pos.CENTER);
       getChildren().addAll(titleText, descriptionText, createProjectButton, openProjectButton);
      
       
    }

    
public Button getCreateProjectButton() {
        return createProjectButton;
    }
public Button getopenProjectButton() {
        return openProjectButton;
    }
}

       
      
      

