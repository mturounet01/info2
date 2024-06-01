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
 * @author antoine
 */
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.IOException;
import java.util.ArrayList;

public class CoutTot extends BorderPane {
    private double coutTotal;
    private ArrayList<Appartement> appartements;
    private Lecture lecteur;
    private Button boutonFermer;

    public CoutTot(ArrayList<Niveau> niveaux, String fichierRevetements) {
        coutTotal = 0;
        lecteur = new Lecture();

        try {
            // Charger les revêtements à partir du fichier spécifié
            List<Revetement> revetements = Revetement.chargerRevetements(fichierRevetements);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Calculer le coût total en parcourant les niveaux et les pièces
        for (Niveau niveau : niveaux) {
            appartements = niveau.getAppart();
            for (Appartement appartement : appartements) {
                ArrayList<Piece> pieces = appartement.getPieces();
                for (Piece piece : pieces) {
                    // Calculer le coût pour le sol
                    Sol sol = piece.getsol();
                    coutTotal += lecteur.recupprix(sol.getRev()) * sol.surface();

                    // Calculer le coût pour le plafond
                    Plafond plafond = piece.getPlafond();
                    coutTotal += lecteur.recupprix(plafond.getRev()) * plafond.surface();

                    // Calculer le coût pour chaque mur
                    ArrayList<Mur> murs = piece.getMur();
                    for (Mur mur : murs) {
                        coutTotal += lecteur.recupprix(mur.getRev()) * mur.surface(niveau.getHauteurSousPlafond());
                    }
                }
            }
        }

        // Créer les composants d'interface utilisateur
        Label labelTotal = new Label("Le devis global est de " + coutTotal + " euros");
        Button boutonFermer = new Button("Fermer");
        this.boutonFermer = boutonFermer;

        // Disposer les composants dans le conteneur BorderPane
        VBox vboxTotal = new VBox();
        vboxTotal.getChildren().addAll(labelTotal, boutonFermer);
        setTop(vboxTotal);

        // Configurer la scène et la fenêtre
        Scene sceneDevis = new Scene(this, 200, 200);
        Stage fenetreDevis = new Stage();
        fenetreDevis.setScene(sceneDevis);
        fenetreDevis.show();

        // Définir l'action du bouton Fermer
        boutonFermer.setOnAction(event -> {
            fenetreDevis.close();
        });
    }
}
