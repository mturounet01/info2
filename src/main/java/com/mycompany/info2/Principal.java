/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.info2;

import fr.insa.projetinfo.*;
import java.util.ArrayList;
import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Slider;
import javafx.scene.control.ScrollBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;

public class Principal extends BorderPane {
    
    private Button AddPiece;
    private Button save;
    private Button Devis;
    private Button Revet;
    private Button Actualiser;
    private Button Appartsuiv;
    private Button Appartprec;
    private Button Niveausuiv;
    private Button Niveauprec;
    private Button suppr; // Bouton pour supprimer la dernière pièce
    public Canvas canvas;
    private TextField hauteur;
    private Button valide;
    private Niveau niveau;
    private ArrayList<Appartement> Appartement;
    private Appartement appart;
    private ArrayList<Piece> pieces;
    private ArrayList<Mur> mur;
    private ArrayList<Niveau> niveaux;
    private Coin Cn1;
    private Coin Cn2;
    private int nv=0;
    private int a=0;
    private int nvm;
    private int am;
    private Label label;
    private int p;

    
    public Principal (ArrayList<Niveau> niveaux, Batiment bat) {
        Label label = new Label("Niveau" + " " + nv + " " + "Appart" + " " + (a+1));
        this.label = label;
        
        Button AddPiece = new Button("Ajouter une pièce");
        this.AddPiece = AddPiece;
        
        Button save = new Button("Enregistrer");
        this.save = save;
        
        Button Devis = new Button("Devis");
        this.Devis = Devis;
        
        Button Revet = new Button("Revetement");
        this.Revet = Revet;
        
        Button actualiser = new Button("Actualiser");
        this.Actualiser = actualiser;
        
        Button Appartsuiv = new Button("Appart suivant");
        this.Appartsuiv = Appartsuiv;
        
        Button Appartprec = new Button("Appart précedent");
        this.Appartprec = Appartprec;
        
        Button Niveausuiv = new Button("Niveau suivant");
        this.Niveausuiv = Niveausuiv;
        
        Button Niveauprec = new Button("Niveau precedent");
        this.Niveauprec = Niveauprec;
        
        TextField hauteur = new TextField("Donnez hauteur");
        this.hauteur = hauteur;
        
        Button valide = new Button("Valide hauteur");
        this.valide = valide;
        
        Button suppr = new Button("Supprimer la dernière pièce");
        suppr.setOnAction(event -> suppr());
        this.suppr = suppr;

        Label echelle = new Label("Echelle:100p=1m");

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(this.suppr, this.label, this.AddPiece, this.save, this.Revet, this.Devis,
                this.Actualiser, this.Niveausuiv, this.Appartsuiv, this.Appartprec, this.Niveauprec, this.hauteur, this.valide);
        setRight(vbox);
        
        Canvas canvas = new Canvas(700, 550);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        this.canvas = canvas; 
        setCenter(canvas);
        setBottom(echelle);
        gc.strokeRect(0, 0, 700, 550);
        this.niveau = niveaux.get(nv);
            this.Appartement = niveau.getAppart();
            this.appart = Appartement.get(a);
            pieces = this.appart.getPieces();
            p = pieces.size() + 1;
        this.am = Appartement.size();
        nvm = niveaux.size();

        AddPiece.setOnAction(event -> {
            CreerPiece CreerPiece = new CreerPiece(nv, a, this.appart, p);
        });

        Actualiser.setOnAction(event -> {
            gc.clearRect(1, 1, 699, 549);
            gc.strokeRect(0, 0, 700, 550);

            this.niveau = niveaux.get(nv);
            this.Appartement = niveau.getAppart();
            this.appart = Appartement.get(a);
            pieces = this.appart.getPieces();
            p = pieces.size() + 1;

            for (Piece pieceE : pieces) {
                //Permet d'obtenir les coins de la pièce
                ArrayList<Coin> coins = pieceE.getCoin();
                int numCoins = coins.size();
                if (numCoins > 1) {
                    for (int i = 0; i < numCoins - 1; i++) {
                        Coin coin1 = coins.get(i);
                        Coin coin2 = coins.get(i + 1);
                        gc.strokeLine(coin1.getX(), coin1.getY(), coin2.getX(), coin2.getY());
                    }
                    // Dessiner une ligne pour fermer la pièce
                    Coin firstCoin = coins.get(0);
                    Coin lastCoin = coins.get(numCoins - 1);
                    gc.strokeLine(firstCoin.getX(), firstCoin.getY(), lastCoin.getX(), lastCoin.getY());
                }
            }
        });

        Appartsuiv.setOnAction(event -> {
            if (a != am - 1) {
                a = a + 1;
                this.label.setText("Niveau" + " " + nv + " " + "Appart" + " " + (a + 1));
            }
        });

        Appartprec.setOnAction(event -> {
            if (a != 0) {
                a = a - 1;
                this.label.setText("Niveau" + " " + nv + " " + "Appart" + " " + (a + 1));
            }
        });

        Niveausuiv.setOnAction(event -> {
            if (nv != nvm) {
                nv = nv + 1;
                this.a = 0;
                this.label.setText("Niveau" + " " + nv + " " + "Appart" + " " + (a + 1));

            }
        });

        Niveauprec.setOnAction(event -> {
            if (nv != 0) {
                nv = nv - 1;
                this.a = 0;
                this.label.setText("Niveau" + " " + nv + " " + "Appart" + " " + (a + 1));
            }
        });

        Revet.setOnAction(event -> {
            FenRevet fenrevet = new FenRevet(appart);
        });

        Devis.setOnAction(event -> {
            Devis Deviss = new Devis(niveaux);
        });

        save.setOnAction(event -> {
            App main = new App();
            main.save(bat);
        });

        valide.setOnAction(event -> {
            this.niveau.addH(Double.parseDouble(hauteur.getText()));

            // Actualiser l'affichage
            gc.clearRect(1, 1, 699, 549);
            gc.strokeRect(0, 0, 700, 550);

            for (Piece pieceE : pieces) {
                ArrayList<Coin> coins = pieceE.getCoin();
                int numCoins = coins.size();
                if (numCoins > 1) {
                    for (int i = 0; i < numCoins - 1; i++) {
                        Coin coin1 = coins.get(i);
                        Coin coin2 = coins.get(i + 1);
                        gc.strokeLine(coin1.getX(), coin1.getY(), coin2.getX(), coin2.getY());
                    }
                    Coin firstCoin = coins.get(0);
                    Coin lastCoin = coins.get(numCoins - 1);
                    gc.strokeLine(firstCoin.getX(), firstCoin.getY(), lastCoin.getX(), lastCoin.getY());
                }           }
        });
    }
    

    public Canvas getCanvas() {
        return canvas;
    }    
   private void suppr() {
    // Vérifier s'il y a des pièces à supprimer
    if (!pieces.isEmpty()) {
        // Supprimer la dernière pièce de la liste
        pieces.remove(pieces.size() - 1);

        // Actualiser l'affichage lors de la suppression de pièce
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(1, 1, 699, 549);
        gc.strokeRect(0, 0, 700, 550);

        for (Piece pieceE : pieces) {
            // Obtenir les coins de la pièce
            ArrayList<Coin> coins = pieceE.getCoin();
            int numCoins = coins.size();
            if (numCoins > 1) {
                for (int i = 0; i < numCoins - 1; i++) {
                    Coin coin1 = coins.get(i);
                    Coin coin2 = coins.get(i + 1);
                    gc.strokeLine(coin1.getX(), coin1.getY(), coin2.getX(), coin2.getY());
                }
                // Dessiner une ligne pour fermer la pièce
                Coin firstCoin = coins.get(0);
                Coin lastCoin = coins.get(numCoins - 1);
                gc.strokeLine(firstCoin.getX(), firstCoin.getY(), lastCoin.getX(), lastCoin.getY());
            }
        }}}}