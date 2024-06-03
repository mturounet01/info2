/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.projetinfo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**s
 *
 * @author maxt
 */
public class Lecture {
    private double a = 1.1;
    private String re;

    public double recupprix(int rev) {
        re = String.valueOf(rev);
        double prix = a; // Prix par défaut

        try (BufferedReader flux = new BufferedReader(new FileReader("C:\\Users\\turou\\OneDrive\\Documents\\NetBeansProjects\\info2\\src\\main\\java\\Ressources\\Revetement.txt"))) {
            String ligne;

            while ((ligne = flux.readLine()) != null) {
                String[] mots = ligne.split(";");

                // Vérifier si le numéro de revêtement correspond à celui recherché
                if (mots[0].equals(re)) {
                    // Récupérer les détails du revêtement
                    String idRevetement = mots[0];
                    String designation = mots[1];
                    int pourMur = Integer.parseInt(mots[2]);
                    int pourSol = Integer.parseInt(mots[3]);
                    int pourPlafond = Integer.parseInt(mots[4]);
                    prix = Double.parseDouble(mots[5]); // Prix du revêtement

                    // Afficher les informations du revêtement (vous pouvez les afficher ou les utiliser comme vous le souhaitez)
                    System.out.println("ID: " + idRevetement);
                    System.out.println("Designation: " + designation);
                    System.out.println("Applicable pour Mur: " + (pourMur == 1 ? "Oui" : "Non"));
                    System.out.println("Applicable pour Sol: " + (pourSol == 1 ? "Oui" : "Non"));
                    System.out.println("Applicable pour Plafond: " + (pourPlafond == 1 ? "Oui" : "Non"));
                    System.out.println("Prix: " + prix);

                    // Arrête la recherche une fois que le revêtement est trouvé
                    break;
                }
            }
        } catch (FileNotFoundException err) {
            System.out.println("Erreur : le fichier n'existe pas!\n " + err);
        } catch (IOException err) {
            System.out.println("Erreur :\n" + err);
        }

        return prix;
    }
}
