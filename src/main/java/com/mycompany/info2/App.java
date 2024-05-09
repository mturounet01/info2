/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.info2;

import fr.insa.projetinfo.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class App extends Application {

    private Batiment batiment = new Batiment();
    private ArrayList<Niveau> niveaux = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        Accueil accueil = new Accueil();

        Scene scene = new Scene(accueil, 800, 200);
        primaryStage.setTitle("Principal");
        primaryStage.setScene(scene);
        primaryStage.show();

        accueil.getCreateProjectButton().setOnAction(event -> showChoix(primaryStage));
        accueil.getopenProjectButton().setOnAction(event -> {
            int a = 2;
            Lecture lect = new Lecture();
            double b = lect.recupprix(a);
            System.out.println(b);
        });
    }

    private void showChoix(Stage primaryStage) {
        Choix choix = new Choix();

        Scene scene2 = new Scene(choix, 800, 400);
        primaryStage.setScene(scene2);

        choix.getmaisonCheckBox().setOnAction(event -> {
            choix.ImmeubleCheckBox.setSelected(false);
            choix.getChildren().removeAll(choix.appartComboBox, choix.boutonvalide);
            choix.getChildren().addAll(choix.boutonvalide);
        });

        choix.getImmeubleCheckBox().setOnAction(event -> {
            choix.maisonCheckBox.setSelected(false);
            choix.getChildren().removeAll(choix.appartComboBox, choix.boutonvalide);
            choix.getChildren().addAll(choix.appartComboBox, choix.boutonvalide);
        });

        choix.getboutonvalide().setOnAction(event -> {
            Batiment batiment = new Batiment();
            batiment.addName(choix.getTitre());

            boolean immeubleSelected = choix.ImmeubleCheckBox.isSelected();
            boolean maisonSelected = choix.maisonCheckBox.isSelected();

            if (maisonSelected) {
                for (int i = 1; i <= Double.parseDouble(choix.getniveauComboBox()); i++) {
                    Niveau niveau = new Niveau(i, 2.5);
                    Appartement appart = new Appartement(i, i);
                    niveau.addAppartement(appart);
                    batiment.addNiveau(niveau);
                }
            } else if (immeubleSelected) {
                for (int i = 0; i < Double.parseDouble(choix.getniveauComboBox()); i++) {
                    Niveau niveau = new Niveau(i, 2.5);
                    for (int j = 0; j < Double.parseDouble(choix.getappartComboBox()); j++) {
                        Appartement appart = new Appartement(j, i);
                        niveau.addAppartement(appart);
                    }
                    batiment.addNiveau(niveau);
                }
            }

            ShowPrincipal(primaryStage, batiment);
        });
    }

    private void ShowPrincipal(Stage primaryStage, Batiment bat) {
        this.niveaux = bat.getNiveau();
        Principal principal = new Principal(this.niveaux, bat);
        Scene scene3 = new Scene(principal, 900, 650);
        primaryStage.setScene(scene3);
    }

    public void save(Batiment bat) {
        try (BufferedWriter w = new BufferedWriter(new FileWriter("chemin_vers_votre_fichier.txt"))) {
            // Écriture des données dans le fichier
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Problème durant la sauvegarde");
            alert.setContentText(ex.getLocalizedMessage());
            alert.showAndWait();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}


