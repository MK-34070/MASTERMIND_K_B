/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mastermind_b_k;

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
        for (int i=0; i<3 ; i++){
            System.out.println("Choississez une couleur a placer"); 
            System.out.println(" 1 = Red \n 2 = Green \n 3 = Pink \n 4= Blue \n 5 = Yellow \n 6= Orange");
            int choixcolor = sc.nextInt()-1;
            while ( choixcolor<1 || choixcolor>6 ){
                System.out.println("Ressaisissez une couleur a placer"); 
                System.out.println(" 1 = Red \n 2 = Green \n 3 = Pink \n 4= Blue \n 5 = Yellow \n 6= Orange");
                choixcolor = sc.nextInt()-1;
            }
            obj1.creation_Jeu_Joueur(choixcolor);
        }
        // a cet emplacement nécessaire de rajouter une fonction qui peremet de modifier l'emplacement des pions( aprés la boucle for)
        
        
        //lancement de la grille indice --> analyse de nos différents pions qu'on a placé
        //créer un compteur qui permet de savoir a quelle niveau/ligne ou on se situe
        //appel de la méthode analyse de Jeu_Joueur
        
       
       
    
    }
}
