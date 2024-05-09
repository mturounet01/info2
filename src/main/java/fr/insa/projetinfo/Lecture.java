/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.projetinfo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Emilien
 */
public class Lecture {
    private double a=1.1;
    private String re;
    public double recupprix (int rev){
    re=String.valueOf(rev);
    String idRevetement, designation , pourMur, pourSol, pourPlafond, PrixUnitaire;
    String[] mots;
    
try
{
BufferedReader flux=new BufferedReader(new FileReader("C:\\Users\\Emilien\\Documents\\NetBeansProjects\\Info\\src\\main\\java\\Ressources\\Revetement.txt"));
String lignelue;

   while((lignelue=flux.readLine())!=null)
   {
 
   //* -Décomposer une chaine de caratères avec la méthode split de la classe String
    mots = lignelue.split(";");
    if (mots[0].equals(re)){
        return Double.parseDouble(mots[5]);
    }
        

   }

flux.close();
 
}

catch(FileNotFoundException err){
System.out.println("Erreur :le fichier n’existe pas!\n "+err);}

catch(IOException err){
System.out.println("Erreur :\n"+err);}

return a;
    }
}
