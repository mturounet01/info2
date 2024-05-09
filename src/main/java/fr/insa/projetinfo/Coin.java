/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.projetinfo;

import java.io.IOException;
import java.io.Writer;
/**
 *
 * @author Justin PRADIE
 */
public class Coin {
    public int idCoin;      //privé par défaut (on peut pas les utliser en dehors de cette classe)
    public double x;        //peut-être enlever les public du coup
    public double y;
    
    public Coin (int idCoin, double x, double y){
        this.idCoin=idCoin;
        this.x=x;
        this.y=y;
    }

    public int getIdCoin() {
        return idCoin;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setIdCoin(int idCoin) {   //mettre à jour les valeurs
        this.idCoin = idCoin;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
    public void dessiner(){}   

    
    @Override
    public String toString() {
        return "Coin{" + "idCoin=" + idCoin + ", x=" + x + ", y=" + y + '}';
    }
    public void save (Writer w) throws IOException {
        w.append("Coin;"+idCoin+";"+this.x+";"+this.y+";"+ "\n");

    }

}
