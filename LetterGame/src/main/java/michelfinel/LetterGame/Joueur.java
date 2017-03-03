package michelfinel.LetterGame;

public class Joueur {
Mot m = new Mot();
int joueur;
int tour = 1;
int lettre1, lettre2;
int verification;

public void partieOrdinateur() {
     
     joueur = m.tirage();
     m.affichage_Lettres_Ordi();
     
  if(joueur == 1) { System.out.printf("Le joueur commence en premier\n");  } else 
   { System.out.printf("L'ordi commence en premier\n");  }
    m.initialiser_pot_commun();
    m.actualiser_pot_commun();
   }

 public void partie() {
      
       joueur = m.tirage();
       m.affichage_Lettres();
     
  if(joueur == 1) { System.out.printf("Le joueur numéro 1 commence en premier\n");  } else 
   { System.out.printf("Le joueur numéro 2 commence en premier\n");  }
    m.initialiser_pot_commun();
    m.actualiser_pot_commun();  
   }
      
  public void afficher_pot() {
      
       m.afficher_pot_commun();  
   }

    public void actualiser_pot() {
      
       m.actualiser_pot_commun();  
   }

      public void verification_pot(String mot) {
      
      verification = m.verification(mot);  
   }

        public int getVerification() {
      
      return verification; 
   }
     
      public int verification_ordinateur(int nb) {
      int verification = m.Ordinateur_cherche_mot(nb);
      return verification; 
      }


       public int nouveautour() {
       tour = tour + 1;
       return tour;
                                }

       public int getjoueurtour() {
       if(tour%2 == 1) { return joueur;}
       if(joueur == 1) { return 2; } else {return 1; }
       }

        
         public void Ajout(int joueur_tour, String mot, int nb) {
                    m.ajout(joueur_tour,mot,nb);
       }

        public void ajout_pot() {
                    m.ajouter_1_lettre();
       }

         public void afficher_mots(int nb1, int nb2) {
              m.affichage_mots(nb1,nb2);
       }

        public int finir_la_partie(int nb1, int nb2) {
        if(nb1 == 10) { System.out.println("Le joueur numéro 1 a gagné la partie\n"); return 1; }
        if(nb2 == 10) { System.out.println("Le joueur numéro 2 a gagné la partie\n"); return 2; }
        return 0;
       }

 }
 