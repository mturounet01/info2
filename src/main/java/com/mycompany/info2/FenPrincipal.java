/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.info2;



import fr.insa.projetinfo.Appartement;
import fr.insa.projetinfo.Batiment;
import fr.insa.projetinfo.Coin;
import fr.insa.projetinfo.Mur;
import fr.insa.projetinfo.Niveau;
import fr.insa.projetinfo.Piece;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import java.util.ArrayList;
/**
 *
 * @author maxt
 */

public class FenPrincipal extends BorderPane {

    private Label label;
    private Button addPieceButton, supprButton, saveButton, devisButton, revetButton, actualiserButton;
    private Button appartsuivButton, appartprecButton, niveausuivButton, niveauprecButton, valideButton;
    private Button addPorteButton, addFenetreButton; // Nouveaux boutons
    private TextField hauteurField;
    private Canvas canvas;
    private GraphicsContext gc;

    private ArrayList<Niveau> niveaux;
    private Batiment bat;
    private Niveau niveau;
    private ArrayList<Appartement> appartements;
    private Appartement appart;
    private ArrayList<Piece> pieces;
    private int nv = 0, a = 0, p, am, nvm;

    public FenPrincipal(ArrayList<Niveau> niveaux, Batiment bat) {
        this.niveaux = niveaux;
        this.bat = bat;

        initializeComponents();
        configureLayout();
        addEventHandlers();
        updateState();
    }

    private void initializeComponents() {
        label = new Label();
        addPieceButton = new Button("Ajouter une pièce");
        supprButton = new Button("Supprimer la dernière pièce");
        saveButton = new Button("Enregistrer");
        devisButton = new Button("Devis");
        revetButton = new Button("Revetement");
        actualiserButton = new Button("Actualiser");
        appartsuivButton = new Button("Appart suivant");
        appartprecButton = new Button("Appart précédent");
        niveausuivButton = new Button("Niveau suivant");
        niveauprecButton = new Button("Niveau précédent");
        hauteurField = new TextField("Donnez hauteur");
        valideButton = new Button("Valide hauteur");

        // Initialisation des nouveaux boutons
        addPorteButton = new Button("Ajouter une porte");
        addFenetreButton = new Button("Ajouter une fenêtre");

        canvas = new Canvas(700, 550);
        gc = canvas.getGraphicsContext2D();
    }

    private void configureLayout() {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));

        // Ajout des boutons et autres éléments au VBox
        vbox.getChildren().addAll(
                label, addPieceButton, supprButton, saveButton, revetButton,
                devisButton, actualiserButton, niveausuivButton, appartsuivButton,
                appartprecButton, niveauprecButton, hauteurField, valideButton,
                addPorteButton, addFenetreButton // Ajout des nouveaux boutons
        );

        // Positionnement du VBox sur le côté droit
        setRight(vbox);

        // Positionnement du canvas au centre
        setCenter(canvas);

        // Ajout d'un label en bas
        setBottom(new Label("Echelle: 100p = 1m"));

        // Dessin d'un rectangle sur le canvas pour délimiter une zone spécifique
        gc.strokeRect(0, 0, 700, 550);
    }

    private void addEventHandlers() {
        addPieceButton.setOnAction(event -> addPiece());
        supprButton.setOnAction(event -> suppr());
        actualiserButton.setOnAction(event -> actualiser());
        appartsuivButton.setOnAction(event -> nextAppart());
        appartprecButton.setOnAction(event -> prevAppart());
        niveausuivButton.setOnAction(event -> nextNiveau());
        niveauprecButton.setOnAction(event -> prevNiveau());
        revetButton.setOnAction(event -> openRevetement());
        devisButton.setOnAction(event -> openDevis());
        saveButton.setOnAction(event -> saveProject());
        valideButton.setOnAction(event -> validateHeight());

        // Gestionnaires d'événements pour les nouveaux boutons
        addPorteButton.setOnAction(event -> addPorte());
        addFenetreButton.setOnAction(event -> addFenetre());
    }

    private void updateState() {
        niveau = niveaux.get(nv);
        appartements = niveau.getAppart();
        appart = appartements.get(a);
        pieces = appart.getPieces();
        p = pieces.size() + 1;
        am = appartements.size();
        nvm = niveaux.size();
        updateLabel();
    }

    private void updateLabel() {
        label.setText("Niveau " + nv + " Appart " + (a + 1));
    }

    private void addPiece() {
        new FenCreerPiece(nv, a, appart, p);
    }

    private void actualiser() {
        gc.clearRect(1, 1, 699, 549);
        gc.strokeRect(0, 0, 700, 550);
        for (Piece piece : pieces) {
            drawPiece(piece);
        }
    }

    private void drawPiece(Piece piece) {
        ArrayList<Coin> coins = piece.getCoin();
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
        }
    }

    private void nextAppart() {
        if (a < am - 1) {
            a++;
            updateState();
        }
    }

    private void prevAppart() {
        if (a > 0) {
            a--;
            updateState();
        }
    }

    private void nextNiveau() {
        if (nv < nvm - 1) {
            nv++;
            a = 0;
            updateState();
        }
    }

    private void prevNiveau() {
        if (nv > 0) {
            nv--;
            a = 0;
            updateState();
        }
    }

    private void openRevetement() {
        new FenDevisrevet(appart);
    }

    private void openDevis() {
        new CoutTot(niveaux, "Ressources/Revetement.txt");
    }

    private void saveProject() {
        App main = new App();
        main.save(bat);
    }

    private void validateHeight() {
        niveau.addHauteurSousPlafond(Double.parseDouble(hauteurField.getText()));
        actualiser();
    }

    private void suppr() {
        // Vérifier s'il y a des pièces à supprimer
        if (!pieces.isEmpty()) {
            // Supprimer la dernière pièce de la liste
            pieces.remove(pieces.size() - 1);

            // Actualiser l'affichage lors de la suppression de pièce
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
            }
        }
    }

    private void addPorte() {
        
        if (!pieces.isEmpty()) {
            Piece piece = pieces.get(pieces.size() - 1); 
            if (!piece.getMur().isEmpty()) {
                Mur mur = piece.getMur().get(0); 
                mur.setNbPortes(mur.getNbPortes() + 1);
            }
        }
        actualiser();
    }

    private void addFenetre() {
        
        if (!pieces.isEmpty()) {
            Piece piece = pieces.get(pieces.size() - 1); 
            if (!piece.getMur().isEmpty()) {
                Mur mur = piece.getMur().get(0); 
                mur.setNbFenetres(mur.getNbFenetres() + 1);
            }
        }
        actualiser();
    }

    public Canvas getCanvas() {
        return canvas;
    }
}
