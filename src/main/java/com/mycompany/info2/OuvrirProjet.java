/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.info2;

/**
 *
 * @author maxt
 */
import fr.insa.projetinfo.Batiment;
import fr.insa.projetinfo.Niveau;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.lang.String;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class OuvrirProjet {
    private String nomBat;

    public void ouvrir(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Ouvrir un projet");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Fichiers texte", "*.txt"),
                new FileChooser.ExtensionFilter("Tous les fichiers", "*.*")
        );

        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            try {
                Batiment bat = loadProjectFromFile(file);
                // Afficher un message de succès et les détails du projet
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Projet ouvert");
                alert.setHeaderText("Le projet a été ouvert avec succès !");
                alert.setContentText("Nom du projet : " + bat.getNomBat(nomBat));
                alert.showAndWait();
            } catch (IOException e) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Problème durant l'ouverture du projet");
                alert.setContentText(e.getLocalizedMessage());
                alert.showAndWait();
            }
        }
    }

    private Batiment loadProjectFromFile(File file) throws IOException {
        Batiment batiment = new Batiment();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if (data[0].equals("batiment")) {
                    batiment.setNomBat(data[1]);
                    for (int i = 2; i < data.length; i++) {
                        Niveau niveau = new Niveau(Integer.parseInt(data[i]), 2.30); // ou la hauteur appropriée
                        batiment.addNiveau(niveau);
                    }
                }
            }
        }
        return batiment;
    }
}
