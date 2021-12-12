/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mastermind_b_k;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mario
 */
public class Partie {
    
    Grille_principale obj1=new Grille_principale();
   
    
    Partie(){
       
    }
    
    
    public void choixcoul(){
        Scanner sc= new Scanner(System.in);
        obj1.combinaisonaléatoire();
        
        ArrayList<String> Jeu_Joueur=new ArrayList<String>();
        for (int i=0; i<4 ; i++){
            System.out.println("Choississez une couleur a placer"); 
            System.out.println(" 1) Red \n 2) Pink \n 3) Green \n 4) Yellow \n 5) Orange \n 6) Blue");
            int choixcolor = sc.nextInt()-1;
            while ( choixcolor<0 || choixcolor>6 ){
                System.out.println("Ressaisissez une couleur a placer"); 
                System.out.println(" 1) Red \n 2) Pink \n 3) Green \n 4) Yellow \n 5) Orange \n 6) Blue");
                choixcolor = sc.nextInt()-1;
            }
            
            Jeu_Joueur.add(obj1.creation_Jeu_Joueur(choixcolor));
        }
        System.out.print(Jeu_Joueur);

        obj1.analyse_Jeu_Joueur();
        // a cet emplacement nécessaire de rajouter une fonction qui peremet de modifier l'emplacement des pions( aprés la boucle for)
        
        //lancement de la grille indice --> analyse de nos différents pions qu'on a placé
        //créer un compteur qui permet de savoir a quelle niveau/ligne ou on se situe
        //appel de la méthode analyse de Jeu_Joueur
           
    
    }
}
