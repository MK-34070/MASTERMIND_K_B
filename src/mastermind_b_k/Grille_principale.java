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
    ArrayList<String> JJ = new ArrayList<>();
    String[] tabCoul2 = new String[5];
    int line;

    // création du constructeur de tout le tableau
    //avec différentes cellules qu'on aura besoin de déterminer pour les différents indices des colonnes
    public Grille_principale() {
        tabCouleur[0] = "R";// affection de la couleur rouge
        tabCouleur[1] = "P";// rose/pink
        tabCouleur[2] = "G";//green 
        tabCouleur[3] = "Y";// jaune
        tabCouleur[4] = "O";// orange
        tabCouleur[5] = "B";// blue
        tabCoul2 = tabCouleur;
        /* for (int i = 0; i < 41; i++) {

            Verif.add(false);
            Indice.add(null);
        }
         */

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
        System.out.println("rentre les mêmes couleur que le tableau ordi -->test");

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
        /*
            int col = line * 4;
            int compteur = 0;
            for (int i = 0; i < 4; i++) {

                if (Jeu_Joueur.get(col) == null ? tabOrdi[i] == null : Jeu_Joueur.get(col).equals(tabOrdi[i])) {
                    if (Verif.get(col) != true) {
                        // attention où on se situe dnas le tableau
                        // on prend line*4
                        // exemple : si line=0 --> 0*4=0 donc Jeu_Joueur.get(0)==tabOrdi[0]
                        //           si line=1 --> 1*4=4 donc Jeu_Joueur.get(4)==tabOrdi[0]
                        // jusqu'à la 12 ieme ligne
                        Verif.set(col, true);
                        Indice.set(col, 0);
                        compteur += 1;
                    }
                }

                col++;
            }
            if (compteur == 4) {
                System.out.println("Vous avez Gagné!!!");
                System.out.println("Le tableau indice de la forme/n" + Indice);
                System.out.println(Verif);
                return Indice;
            }
            //deuxième boucle pour déterminer si on place des pions si seulement présence d'une bonne couleur
            for (int j = 0; j < 4; j++) {
                if (compteur == 0) {
                    JJ = (ArrayList<String>) Jeu_Joueur.subList(col, col + 4);
                    if (JJ.contains(tabOrdi[j])) {
                        Verif.set(col, true);
                        Indice.set(col, 1);
                        col++;
                    }
                }
                /*
            for 
             JJ=(ArrayList<String>) Jeu_Joueur.subList(col,col+4);
              if (JJ.contains(tabOrdi[j])){
                  Verif.set(col, Boolean.TRUE)
              }

              }

        }
       
        /*
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
        }
         */
        //utilisation sublist
        /* LinkedList<Integer> num=new LinkedList<Integer>();
      for (int i=0 ;i<10;i++){
       num.add(i);   
      }
      num.subList(3, 7);
      System.out.print(num.subList(3, 7));
         */

        //   return Indice;
        // test 1 : si tabOrdi=[R,Y,B,G]
        // pour k=0 , line =0
        // Verif.get(0)==false
        // Dans  
        //  return null;
        // idée pour les boucles
        int colencours = 0; // on enregistre la ligne finale dans une variable pour ensuite reparcourir a +4
        for (int indtab = 0; indtab < colencours + 4; indtab++) { // on parcourt de 0 à +4 // double boucle imbriquée 1) qui parcourt chaque case de la liste alétoire de l'ordi 
            //     for(int indjou=0 ; indjou < colencours+4 ; indjou++){
            if (Jeu_Joueur.contains(tabOrdi[indtab])) {  ///2) on verifie si il y a une couleur similaire
                int indjoueur = Jeu_Joueur.indexOf(tabOrdi[indtab]);// index of prend le premier indice ouu il y a l'element qu'on veut 
                if (indtab == indjoueur) {// si couleur similaire on verif l'indice / on compare les indices (indice de la case en cours de l'ordi et indice en cours du joueur 
                    for (int i = 0; i < 6; i++) {
                        if (tabCoul2[i] == tabOrdi[indtab] && tabCoul2[i] != "NOP") {
                            tabCoul2[i] = "NOP";
                            System.out.print(tabCoul2);
                            Indice.add(0); // si indice le même on rentre un 0 dans l'array des indices 
                            break;
                        }
                    }
                } else {
                    for (int i = 0; i < 6; i++) {
                        if (tabCoul2[i] == tabOrdi[indtab] && tabCoul2[i] != "NOP") {
                            tabCoul2[i] = "NOP";
                            System.out.print(tabCoul2);
                            Indice.add(1);// sinon on rentre juste un 1// si identique boom on rajoute un 1 u tableau des indices
                            break;
                        }
                    }
                }
            } else {
                
                //continue;// si pas même couleur on passe à la case d'apres 
                // et tableau d'indice reste null
                //  }

            }
            Verif.add(true);// une fois la verif de la première case faite la valeur passe à true
            colencours += 4;
            
            System.out.println("Le tableau indice de la forme/n" + Indice);
            System.out.println(Verif);
            return Indice;// on renvoit le tableau des indices 
            // on peut rajouter une boucle qui verifie que toutes les cases de l'ordi on bien été comparée        

        }
        
        return null;

    }
}
