/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mastermind_b_k;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author mario
 */
public class Grille_principale {
    
    //ne pas oublier de créer le constructeur
    // création du tableau de l'ordi
    String [] tabOrdi= new String[4];
     Random pions= new Random();
    //String[][] Joueur_combi= new String[12][4];
    // création du tableau de 6 couleur:
    String [] tabCouleur=new String[6];
    ArrayList<String> Jeu_Joueur = new ArrayList<String>();
    ArrayList<Boolean> Verif = new ArrayList<Boolean>();
    ArrayList<Integer> Indice = new ArrayList<Integer>();
    
    
    
    
    
    
    
   
    // création du constructeur de tout le tableau
    //avec différentes cellules qu'on aura besoin de déterminer pour les différents indices des colonnes
    public Grille_principale(){
        tabCouleur[0]="R";// affection de la couleur rouge
        tabCouleur[1]="P";// rose/pink
        tabCouleur[2]="G";//green 
        tabCouleur[3]="Y";// jaune
        tabCouleur[4]="O";// orange
        tabCouleur[5]="B";// blue
        
       for (int i =0; i<41; i++){
            
            Verif.add(false);
            Indice.add(null);
       }
            
        
    }

    /**
     *cette méthode permet de créer la combinaison aléatoire de l'ordinateur avec 4 couleurs aléatoires parmi les 6 proposées
     * @return    *on retourne le tableau aléatoire qui a été généré 
     */
    public String[]  combinaisonaléatoire(){
        for (int i=0; i<4; i++){
            int couleur=pions.nextInt(5);
            tabOrdi[i]=tabCouleur[couleur];
        }
        System.out.println(Arrays.toString(tabOrdi));
        return tabOrdi;
    }
    
    public String creation_Jeu_Joueur(int nbrecolor){
        
        Jeu_Joueur.add(tabCouleur[nbrecolor]);
        return tabCouleur[nbrecolor];
        
    }

    public void affichage_Jeu_Joueur(String tabJoueur){
        //for (int k=0;)
        System.out.println("||");
        
    }
    
    /**
     *
     * @param 
     * @return
     */
    public ArrayList<Integer> analyse_Jeu_Joueur ( ){//int line ){//String[] tabJoueur ,
        // premiere boucle d'analyse concernant si bonne couleur + bon emplacement
        // a chaque passage de niveau(nouvel ligne) clear le tableau d'indice et même tout les autres ArrayList: --> l'affichage restera;
        // on n'a pas besoin de stocker les valeurs des ArrayList(sauf pour réafficher a chaque fois les niveaux du joueur
        //clear ArrayLists
        //int col=line*4;
        int compteur=0;
        for (int i=0 ; i<4 ; i++ ){ 
            
            if (Jeu_Joueur.get(i)==tabOrdi[i]){  if (Verif.get(i)!=true ) {
                // attention où on se situe dnas le tableau
                // on prend line*4
                // exemple : si line=0 --> 0*4=0 donc Jeu_Joueur.get(0)==tabOrdi[0]
                //           si line=1 --> 1*4=4 donc Jeu_Joueur.get(4)==tabOrdi[0]
                // jusqu'à la 12 ieme ligne
                Verif.set(i,true);
                Indice.set(i,0);   
                compteur+=1;
                }
            }
            
            //col++;
        }
        if (compteur==4){
            System.out.println("Vous avez Gagné!!!");
            System.out.println(Indice);
            System.out.println(Verif);
            return Indice;
        }
        //deuxième boucle pour déterminer si on place des pions si seulement présence d'une bonne couleur
        
        for (int k=0 ; k<4 ; k++){
            if (Verif.get(k)!=true){
               for (int j=0;j<4;j++){
                if (Jeu_Joueur.get(k)==(tabOrdi[j])){  // si on fait ca cela analyse tout le tableau array --> donc pas possible
                    //test: si col=line*4=4
                    //Jeu_Joueur.get(4)==(tabOrdi[0])
                    if (Verif.get(k)!=true){
                        Indice.set(k,1);
                        Verif.set(k,true);
                    }
                    //col++;
                 } 
                }
            }
            //utilisation sublist
            /* LinkedList<Integer> num=new LinkedList<Integer>();
      for (int i=0 ;i<10;i++){
       num.add(i);   
      }
      num.subList(3, 7);
      System.out.print(num.subList(3, 7));
*/
            
        }

        
      return Indice;  
    }// test 1 : si tabOrdi=[R,Y,B,G]
       // pour k=0 , line =0
        // Verif.get(0)==false
        // Dans  
}