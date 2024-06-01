/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.info2;



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
public class DessinBat extends BorderPane {
    
    public  double rayonPoint = 5;
    public  double epaisseurTrait = 2;
    
    private  double pixelsParMetre = 25;
    private Point2D origine;//coos de l'origine reelle en coos ecran 
    private Point2D initPos;
    private Point2D origineInitPos;
    private Point2D prevPos;
    
    private double maxX = 512;
    private double maxY = 512;
    private ObservableList<Node> children;
    //private HashMap<Node, Piece> pieces;
    private Object pieces;
    private DessinBat CeDevis;
  
      
     public DessinBat(){
       
        
        // Création du Canvas
        Canvas canvas = new Canvas(600, 550);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Polygon r = new Polygon(0,0 ,400, 450);
        r.setFill(Color.YELLOW);
        r.setStroke(Color.BLACK);
       //canvas.setStyle("-fx-background-color: yellow;");
         gc.fillRect(0, 0, 800, 500);
        
         
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        
        
     }
}