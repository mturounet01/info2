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
/**
 *
 * @author maxt
 */
public class CreerPiece {
    public CreerPiece(int nv , int a ,Appartement appart,int p){
     
        Stage CreerPiece = new Stage();
        Label X = new Label("Coord X coin haut gauche");
        TextField CoordX =new TextField();
        TextField CoordY =new TextField();
        TextField CoordX2 =new TextField();
        TextField CoordY2 =new TextField();
        Label Y = new Label("Coord Y coin haut gauche");
        Label Y2 = new Label("Coord Y coin bas droite");
        Label X2 = new Label("Coord X coin bas droite");
        Button ok = new Button("Ok");
        
        VBox piece = new VBox();
        
        piece.getChildren().add(X);
        piece.getChildren().add(CoordX);
        piece.getChildren().add(Y);
        piece.getChildren().add(CoordY);
        piece.getChildren().add(X2);
        piece.getChildren().add(CoordX2);
        piece.getChildren().add(Y2);
        piece.getChildren().add(CoordY2);   
        piece.getChildren().add(ok);
        
        
        Scene piecesc = new Scene(piece,300,300);
    
        CreerPiece.setScene(piecesc);
        CreerPiece.show();
        
    
    
    ok.setOnAction(e-> {
        
        Double cx = Double.parseDouble(CoordX.getText());
        Double cy = Double.parseDouble(CoordY.getText());
        Double cx2 = Double.parseDouble(CoordX2.getText());
        Double cy2 = Double.parseDouble(CoordY2.getText());
        
        Coin Cn1 = new Coin(1,cx,cy);
        Coin Cn2 = new Coin(2,cx2,cy);
        Coin Cn3 = new Coin(3,cx2,cy2);
        Coin Cn4 = new Coin(4,cx,cy2);
        Mur Mur1 = new Mur(1,Cn1,Cn2);
        Mur Mur2 = new Mur(2,Cn2,Cn3);
        Mur Mur3 = new Mur(3,Cn3,Cn4);
        Mur Mur4 = new Mur(4,Cn4,Cn1);
        Piece pieces = new Piece(p);
        pieces.addCoin(Cn1);
        pieces.addCoin(Cn2);
        pieces.addCoin(Cn3);
        pieces.addCoin(Cn4);
        pieces.addMur(Mur1);
        pieces.addMur(Mur2);
        pieces.addMur(Mur3);
        pieces.addMur(Mur4);
        appart.addPiece(pieces);
        CreerPiece.close();
        
    });
    
    }
}
