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
 * @author maxt
 */
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Accueil extends VBox {

    private Button createProjectButton;
    private Button openProjectButton;

    public Accueil(Stage primaryStage) {

        Text titleText = new Text("DeviBat");
        titleText.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        Text descriptionText = new Text("Faire le devis de votre bâtiment");
        descriptionText.setFont(Font.font("Arial", FontWeight.NORMAL, 12));

        createProjectButton = new Button("Créer projet");
        createProjectButton.setPrefWidth(120);

        openProjectButton = new Button("Ouvrir un projet");
        openProjectButton.setPrefWidth(120);
        openProjectButton.setOnAction(event -> {
            OuvrirProjet ouvrirProjet = new OuvrirProjet();
            ouvrirProjet.ouvrir(primaryStage);
        });

        setSpacing(20);
        setAlignment(Pos.CENTER);
        getChildren().addAll(titleText, descriptionText, createProjectButton, openProjectButton);
    }

    public Button getCreateProjectButton() {
        return createProjectButton;
    }

    public Button getOpenProjectButton() {
        return openProjectButton;
    }
}
