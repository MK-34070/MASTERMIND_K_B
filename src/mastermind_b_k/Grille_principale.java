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
    String[] tabOrdi = new String[4];
    Random pions = new Random();
    //String[][] Joueur_combi= new String[12][4];
    // création du tableau de 6 couleur:
    String[] tabCouleur = new String[6];
    ArrayList<String> Jeu_Joueur = new ArrayList<>();
    ArrayList<Boolean> Verif = new ArrayList<>();
    ArrayList<Integer> Indice = new ArrayList<>();
    String[] tabCoul2 = new String[6];

    // création du constructeur de tout le tableau
    //avec différentes cellules qu'on aura besoin de déterminer pour les différents indices des colonnes
    public Grille_principale() {
        tabCouleur[0] = "R";// affection de la couleur rouge
        tabCouleur[1] = "P";// rose/pink
        tabCouleur[2] = "G";//green 
        tabCouleur[3] = "Y";// jaune
        tabCouleur[4] = "O";// orange
        tabCouleur[5] = "B";// blue
        
         
        
        for (int i = 0; i < 42; i++) {

            Verif.add(false);
            Indice.add(-1);
        }

    }

    /**
     * cette méthode permet de créer la combinaison aléatoire de l'ordinateur
     * avec 4 couleurs aléatoires parmi les 6 proposées
     *
     * @return *on retourne le tableau aléatoire qui a été généré
     */
    public String[] combinaisonaléatoire() {
        for (int i = 0; i < 4; i++) {
            int couleur = pions.nextInt(6);
            tabOrdi[i] = tabCouleur[couleur];
        }
        System.out.println(Arrays.toString(tabOrdi));
        

        return tabOrdi;
    }

    public String creation_Jeu_Joueur(int nbrecolor) {

        Jeu_Joueur.add(tabCouleur[nbrecolor]);
        return tabCouleur[nbrecolor];

    }

    public void affichage_Jeu_Joueur(String tabJoueur) {
        //for (int k=0;)
        System.out.println("||");

    }

    /**
     *
     * @param line@return
     */
    public boolean analyse_Jeu_Joueur(int line) {//String[] tabJoueur ,
        // premiere boucle d'analyse concernant si bonne couleur + bon emplacement
        // a chaque passage de niveau(nouvel ligne) clear le tableau d'indice et même tout les autres ArrayList: --> l'affichage restera;
        // on n'a pas besoin de stocker les valeurs des ArrayList(sauf pour réafficher a chaque fois les niveaux du joueur
        //clear ArrayLists

        int col = line * 4;
        int compteur = 0;
        for (int i = 0; i < 4; i++ ) {

            if (Jeu_Joueur.get(col+i)==tabOrdi[i]){
                if (Verif.get(col+i) != true) {
                    Verif.set(col+i, true);
                    Indice.set(col+i, 0);
                    compteur += 1;
                    //compteur pour savoir si 4 indices sont == a 4
                }
            }
        //System.out.println("1"+Verif.subList(col,col+4));
        //System.out.println(Indice.subList(col,col+4));
        }
        if (compteur == 4) {
            System.out.println("Vous avez Gagné!!!");
            //System.out.println("Le tableau indice de la forme/n" + Indice);
            //System.out.println(Verif);
            return true;
        }
        //deuxième boucle pour déterminer si on place des pions si seulement présence d'une bonne couleur
        tabCoul2[0] = "R";// affection de la couleur rouge
        tabCoul2[1] = "P";// rose/pink
        tabCoul2[2] = "G";//green 
        tabCoul2[3] = "Y";// jaune
        tabCoul2[4] = "O";// orange
        tabCoul2[5] = "B";// blue
        
        
        for (int k = col; k < col + 4; k++) {
            if (Verif.get(k) != true) {
                for (int j = 0; j < 4; j++) {
                    if (Jeu_Joueur.get(k) == tabOrdi[j]) {  // si on fait ca cela analyse tout le tableau array --> donc pas possible
                        
                        if(Verif.get(col+j) != true) {
                            for (int i = 0; i < 6; i++) {
                                if (tabCoul2[i] == tabOrdi[j]) {// && tabCoul2[i] != "NOP") {
                                    tabCoul2[i] = "NOP";
                                    Indice.set(k, 1);// sinon on rentre juste un 1// si identique boom on rajoute un 1 u tableau des indices                               
                                    Verif.set(k, true);

                                    break;
                                }
                            }
                        }
                    }
                    Verif.set(k, true);
                }
            }
        }
        //System.out.println("2"+Verif.subList(col, col+4));
        System.out.println(Indice.subList(col, col+4));
        return false;
    }
}

      
            
