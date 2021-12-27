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
            Indice.add(null);
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
    public ArrayList<Integer> analyse_Jeu_Joueur(int line) {//String[] tabJoueur ,
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
            
        }
        if (compteur == 4) {
            System.out.println("Vous avez Gagné!!!");
            System.out.println("Le tableau indice de la forme/n" + Indice);
            System.out.println(Verif);
            return Indice;
        }
        //deuxième boucle pour déterminer si on place des pions si seulement présence d'une bonne couleur
        tabCoul2[0] = "R";// affection de la couleur rouge
        tabCoul2[1] = "P";// rose/pink
        tabCoul2[2] = "G";//green 
        tabCoul2[3] = "Y";// jaune
        tabCoul2[4] = "O";// orange
        tabCoul2[5] = "B";// blue
        
        System.out.println("tabCOul2"+ Arrays.toString(tabCoul2));
        System.out.println("tabCouleur"+ Arrays.toString(tabCouleur));
        for (int k = col; k < col + 4; k++) {
            if (Verif.get(k) != true) {
                for (int j = 0; j < 4; j++) {
                    if (Jeu_Joueur.get(k) == tabOrdi[j]) {  // si on fait ca cela analyse tout le tableau array --> donc pas possible
                        //test: si col=line*4=4
                        //Jeu_Joueur.get(4)==(tabOrdi[0])
                        for (int i = 0; i < 6; i++) {
                            if (tabCoul2[i] == tabOrdi[j]) {// && tabCoul2[i] != "NOP") {
                                tabCoul2[i] = "NOP";
                                Indice.set(k, 1);// sinon on rentre juste un 1// si identique boom on rajoute un 1 u tableau des indices                               
                                Verif.set(k, true);

                                break;
                            }
                        }
                    }
                    Verif.set(k, true);
                }
            }
        }
        System.out.println(Verif.subList(col, col+4));
        return Indice;
    }
}

                /*
        // idée pour les boucles
        int col = line * 4;// on enregistre la ligne finale dans une variable pour ensuite reparcourir a +4
        for (int indtabOrdi = 0; indtabOrdi < 4; indtabOrdi++) { // on parcourt de 0 à +4 // double boucle imbriquée 1) qui parcourt chaque case de la liste alétoire de l'ordi 
            //     for(int indjou=0 ; indjou < colencours+4 ; indjou++){
            if (Jeu_Joueur.contains(tabOrdi[indtabOrdi])) {  ///2) on verifie si il y a une couleur similaire
                int indjoueur = Jeu_Joueur.indexOf(tabOrdi[indtabOrdi]);// index of prend le premier indice ouu il y a l'element qu'on veut 
                if (indtabOrdi == indjoueur) {// si couleur similaire on verif l'indice / on compare les indices (indice de la case en cours de l'ordi et indice en cours du joueur 
                    Indice.add(0); // si indice le même on rentre un 0 dans l'array des indices 
                    int tour = Jeu_Joueur.indexOf(false);
                    Verif.set(tour, true);
                    //Verif.add(true);// une fois la verif de la première case faite la valeur passe à true
                } else {
                    for (int i = 0; i < 6; i++) {
                        if (tabCoul2[i] == tabOrdi[indtabOrdi] && tabCoul2[i] != "NOP") {
                            tabCoul2[i] = "NOP";
                            Indice.add(1);// sinon on rentre juste un 1// si identique boom on rajoute un 1 u tableau des indices
                             int tours = Jeu_Joueur.indexOf(false);
                            Verif.set(tours, true);
            
                            break;
                        }

                    }
                    System.out.println(Arrays.toString(tabCoul2));
                }
            } else {

                Verif.add(true);

                continue;// si pas même couleur on passe à la case d'apres 
                // et tableau d'indice reste null
                //  }

            }

        }
        col += 4;
        System.out.println("Le tableau indice de la forme\n" + Indice);
        System.out.println(Verif);
                
    return Indice;// on renvoit le tableau des indices 
   // on peut rajouter une boucle qui verifie que toutes les cases de l'ordi on bien été comparée        
                 */
            
            