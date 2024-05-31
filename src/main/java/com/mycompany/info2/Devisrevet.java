/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.info2;
import fr.insa.projetinfo.*;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Devisrevet {

    private ArrayList<Piece> pieces;
    private ArrayList<Mur> murs;
    private ArrayList<Sol> sols;
    private ArrayList<Plafond> plafonds;
    private ArrayList<ComboBox<String>> comboMurs;
    private ArrayList<ComboBox<String>> comboSols;
    private ArrayList<ComboBox<String>> comboPlafonds;

    private CheckBox checkMur, checkSol, checkPlafond;
    private Button validerMur, validerSol, validerPlafond, closeButton;
    private VBox optionsContainer;

    public Devisrevet(Appartement appart) {
        Stage fenRevet = new Stage();

        pieces = appart.getPieces();
        murs = new ArrayList<>();
        sols = new ArrayList<>();
        plafonds = new ArrayList<>();
        comboMurs = new ArrayList<>();
        comboSols = new ArrayList<>();
        comboPlafonds = new ArrayList<>();

        checkMur = new CheckBox("Mur");
        checkSol = new CheckBox("Sol");
        checkPlafond = new CheckBox("Plafond");
        validerMur = new Button("Valider Murs");
        validerSol = new Button("Valider Sols");
        validerPlafond = new Button("Valider Plafonds");
        closeButton = new Button("Close");

        BorderPane rootPane = new BorderPane();
        HBox checkBoxContainer = new HBox(20);
        optionsContainer = new VBox(10);
        optionsContainer.setPadding(new Insets(10));

        checkBoxContainer.getChildren().addAll(checkMur, checkSol, checkPlafond, closeButton);
        rootPane.setTop(checkBoxContainer);
        rootPane.setCenter(optionsContainer);

        Scene scene = new Scene(rootPane, 500, 500);
        fenRevet.setScene(scene);
        fenRevet.show();

        GestionEvent();
    }

    private void GestionEvent() {
        checkMur.setOnAction(event -> handleCheckMur());
        checkSol.setOnAction(event -> handleCheckSol());
        checkPlafond.setOnAction(event -> handleCheckPlafond());

        validerMur.setOnAction(event -> handleValiderMur());
        validerSol.setOnAction(event -> handleValiderSol());
        validerPlafond.setOnAction(event -> handleValiderPlafond());

        closeButton.setOnAction(event -> ((Stage) closeButton.getScene().getWindow()).close());
    }

    private void handleCheckMur() {
        checkSol.setSelected(false);
        checkPlafond.setSelected(false);
        optionsContainer.getChildren().clear();
        comboMurs.clear();
        murs.clear();

        for (Piece piece : pieces) {
            ArrayList<Mur> pieceMurs = piece.getMur();
            murs.addAll(pieceMurs);

            for (Mur mur : pieceMurs) {
                Label label = new Label("Piece " + piece.getIdPiece() + " Mur " + mur.getIdMur());
                ComboBox<String> murComboBox = MurComboBox();
                comboMurs.add(murComboBox);
                optionsContainer.getChildren().addAll(label, murComboBox);
            }
        }

        optionsContainer.getChildren().add(validerMur);
    }

    private ComboBox<String> MurComboBox() {
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.setPromptText("Revetement");
        comboBox.getItems().addAll(
            "Peinture bas de Gamme", "Peinture moyen de Gamme", "Peinture haut de Gamme",
            "Carrelage bas de Gamme", "Carrelage moyen de Gamme", "Carrelage haut de Gamme",
            "Lambris bas de Gamme", "Lambris Haut de Gamme", "Marbre", "Crepi",
            "Papier Peint", "Plaquettes de parement", "Liege"
        );
        return comboBox;
    }

    private void handleValiderMur() {
        for (int i = 0; i < comboMurs.size(); i++) {
            ComboBox<String> comboBox = comboMurs.get(i);
            Mur mur = murs.get(i);

            if (comboBox.getValue() == null) {
                comboBox.setValue("Peinture bas de Gamme");
            }

            switch (comboBox.getValue()) {
                case "Peinture bas de Gamme":
                    mur.addRev(125);
                    break;
                case "Peinture moyen de Gamme":
                    mur.addRev(115);
                    break;
                case "Peinture haut de Gamme":
                    mur.addRev(8);
                    break;
                case "Carrelage bas de Gamme":
                    mur.addRev(23);
                    break;
                case "Carrelage moyen de Gamme":
                    mur.addRev(23);
                    break;
                case "Carrelage haut de Gamme":
                    mur.addRev(15);
                    break;
                case "Lambris bas de Gamme":
                    mur.addRev(110);
                    break;
                case "Lambris Haut de Gamme":
                    mur.addRev(43);
                    break;
                case "Marbre":
                    mur.addRev(48);
                    break;
                case "Crepi":
                    mur.addRev(105);
                    break;
                case "Papier Peint":
                    mur.addRev(60);
                    break;
                case "Plaquettes de parement":
                    mur.addRev(75);
                    break;
                case "Liege":
                    mur.addRev(102);
                    break;
            }
        }
    }

    private void handleCheckSol() {
        checkMur.setSelected(false);
        checkPlafond.setSelected(false);
        optionsContainer.getChildren().clear();
        comboSols.clear();
        sols.clear();

        for (Piece piece : pieces) {
            sols.add(piece.getsol());

            Label label = new Label("Sol de la Piece " + piece.getIdPiece());
            ComboBox<String> solComboBox = SolComboBox();
            comboSols.add(solComboBox);
            optionsContainer.getChildren().addAll(label, solComboBox);
        }

        optionsContainer.getChildren().add(validerSol);
    }

    private ComboBox<String> SolComboBox() {
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.setPromptText("Revetement");
        comboBox.getItems().addAll(
            "Carrelage bas de Gamme", "Carrelage moyen de Gamme", "Carrelage haut de Gamme",
            "Lambris bas de Gamme", "Lambris Haut de Gamme", "Marbre",
            "Liege bas de Gamme", "Liege Haut de Gamme", "Parquet",
            "Vinyle Lino", "Moquette", "Stratifié", "Gazon"
        );
        return comboBox;
    }

    private void handleValiderSol() {
        for (int i = 0; i < comboSols.size(); i++) {
            ComboBox<String> comboBox = comboSols.get(i);
            Sol sol = sols.get(i);

            if (comboBox.getValue() == null) {
                comboBox.setValue("Carrelage bas de Gamme");
            }

            switch (comboBox.getValue()) {
                case "Carrelage bas de Gamme":
                    sol.addRev(115);
                    break;
                case "Carrelage moyen de Gamme":
                    sol.addRev(23);
                    break;
                case "Carrelage haut de Gamme":
                    sol.addRev(15);
                    break;
                case "Lambris bas de Gamme":
                    sol.addRev(110);
                    break;
                case "Lambris Haut de Gamme":
                    sol.addRev(43);
                    break;
                case "Marbre":
                    sol.addRev(48);
                    break;
                case "Liege bas de Gamme":
                    sol.addRev(102);
                    break;
                case "Liege Haut de Gamme":
                    sol.addRev(180);
                    break;
                case "Parquet":
                    sol.addRev(132);
                    break;
                case "Vinyle Lino":
                    sol.addRev(114);
                    break;
                case "Moquette":
                    sol.addRev(156);
                    break;
                case "Stratifié":
                    sol.addRev(1126);
                    break;
                case "Gazon":
                    sol.addRev(174);
                    break;
            }
        }
    }

    private void handleCheckPlafond() {
        checkMur.setSelected(false);
        checkSol.setSelected(false);
        optionsContainer.getChildren().clear();
        comboPlafonds.clear();
        plafonds.clear();

        for (Piece piece : pieces) {
            plafonds.add(piece.getPlafond());

            Label label = new Label("Plafond de la Piece " + piece.getIdPiece());
            ComboBox<String> plafondComboBox = PlafondComboBox();
            comboPlafonds.add(plafondComboBox);
            optionsContainer.getChildren().addAll(label, plafondComboBox);
        }

        optionsContainer.getChildren().add(validerPlafond);
    }

    private ComboBox<String> PlafondComboBox() {
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.setPromptText("Revetement");
        comboBox.getItems().addAll(
            "Peinture bas de Gamme", "Peinture moyen de Gamme", "Peinture haut de Gamme", "Lambris"
        );
        return comboBox;
    }

    private void handleValiderPlafond() {
        for (int i = 0; i < comboPlafonds.size(); i++) {
            ComboBox<String> comboBox = comboPlafonds.get(i);
            Plafond plafond = plafonds.get(i);

            if (comboBox.getValue() == null) {
                comboBox.setValue("Peinture bas de Gamme");
            }

            switch (comboBox.getValue()) {
                case "Peinture bas de Gamme":
                    plafond.addRev(125);
                    break;
                case "Peinture moyen de Gamme":
                    plafond.addRev(19);
                    break;
                case "Peinture haut de Gamme":
                    plafond.addRev(8);
                    break;
                case "Lambris":
                    plafond.addRev(43);
                    break;
            }
        }
    }

    public CheckBox getCheckMur() {
        return checkMur;
    }

    public CheckBox getCheckSol() {
        return checkSol;
    }

    public CheckBox getCheckPlafond() {
        return checkPlafond;
    }
}
