package fr.esiea.unique.MichelFinel.LetterGame;
public class Joueur {
Mot m = new Mot();
int joueur;
int tour = 1;
int lettre1, lettre2;
int verification;

/*Lance la partie contre l'ordinateur */
public void partieOrdinateur() {
     
     joueur = m.tirage();
     m.affichage_Lettres_Ordi();
     
  if(joueur == 1) { System.out.printf("Le joueur commence en premier\n");  } else 
   { System.out.printf("L'ordi commence en premier\n");  }
    m.initialiser_pot_commun();
    m.actualiser_pot_commun();
   }

/*Lance la partie contre un autre joueur */

 public void partie() {
      
       joueur = m.tirage();
       m.affichage_Lettres();
     
  if(joueur == 1) { System.out.printf("Le joueur numéro 1 commence en premier\n");  } else 
   { System.out.printf("Le joueur numéro 2 commence en premier\n");  }
    m.initialiser_pot_commun();
    m.actualiser_pot_commun();  
   }
      
 /*appelle la fonction de la classe "Mot" qui affiche le pot commun */
 
  public void afficher_pot() {
      
       m.afficher_pot_commun();  
   }

  /*appelle la fonction de la classe "Mot" qui actualise le pot commun*/
  
    public void actualiser_pot() {
      
       m.actualiser_pot_commun();  
   }
    /*appelle la fonction de la classe "Mot" vérifie que le mot peut bien être composé*/
    
      public void verification_pot(String mot) {
      
      verification = m.verification(mot);  
   }

      /*fonction qui permet à la classe affichage d'obtenir la valeur entrée dans la variable "verification"*/
      
        public int getVerification() {
      
      return verification; 
   }
        /*fonction identique à la précédente mais dans le cas d'une partie contre l'ordinateur */
        
      public int verification_ordinateur(int nb) {
      int verification = m.Ordinateur_cherche_mot(nb);
      return verification; 
      }

      /*incrémente le nombre de tour joué dans la partie*/
      
       public int nouveautour() {
       tour = tour + 1;
       return tour;
                                }
       /* fonction qui permet de récupérer le numéro du joueur dont c'est le tour */
       
       public int getjoueurtour() {
       if(tour%2 == 1) { return joueur;}
       if(joueur == 1) { return 2; } else {return 1; }
       }

       /*fonction qui appelle la fonction d'ajout de mots présente dans la classe "Mot" */
         public void Ajout(int joueur_tour, String mot, int nb) {
                    m.ajout(joueur_tour,mot,nb);
       }
         /*fonction qui appelle la fonction d'ajout de lettres présente dans la classe "Mot"*/
        public void ajout_pot() {
                    m.ajouter_1_lettre();
       }
        /*fonction qui appelle la fonction d'affichage des mots des 2 joueurs présente dans la classe "Mot" */
         public void afficher_mots(int nb1, int nb2) {
              m.affichage_mots(nb1,nb2);
       }
         /*fonction appelé depuis la classe "Affichage" */
         /*teste si la partie est terminée, elle renvoie 0 si ce n'est pas le cas, 1 si le joueur 1 a gagné, 2 si le joueur 2 a gagné */
        public int finir_la_partie(int nb1, int nb2) {
        if(nb1 == 10) { System.out.println("Le joueur numéro 1 a gagné la partie\n"); return 1; }
        if(nb2 == 10) { System.out.println("Le joueur numéro 2 a gagné la partie\n"); return 2; }
        return 0;
       }
         /*fonction appelé par la classe "Affichage" aprés la fin d'une partie, efface les lettres du pot commun en vue d'une 2éme partie */ 
       public void reinitialisation() { 
        m.effacer_sac_commun();
       }

 }