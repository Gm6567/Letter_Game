package fr.esiea.unique.MichelFinel.LetterGame;
import java.util.Scanner;

public class Affichage {
	 Joueur jo = new Joueur();
	 int joueur_tour;
	 int tour = 1;
	 int nb_mots1 = 0;
	 int nb_mots2 = 0; 
	 
	 /*Menu d'accueil lors du lancement d'une nouvelle partie*/
	 public void affichage_menu_accueil() {
	        int choix;
	        Scanner sc = new Scanner(System.in);
	        System.out.println("*****************************************************\n");
	        System.out.println("Pour entamer une nouvelle partie contre un joueur tapez 1\n");
	        System.out.println("Pour entamer une nouvelle partie contre l'ordinateur tapez 2\n");
	        System.out.println("Pour quitter le jeu tapez 3\n");
	        System.out.println("*****************************************************\n");
	        choix = sc.nextInt(); 
	     
	        choix_lancement(choix);
	        
	         }
	 /*fonction qui prend en compte le choix de l'utilisateur : contre un joueur, contre l'ordinateur ou quitter la partie*/
	         public void choix_lancement(int choix) {
	        switch(choix) {

	            case 1 : jo.partie(); jeu_contre_joueur();
	            break;

	            case 2 :  jo.partieOrdinateur();  jeu_contre_ordinateur();
	            break;

	            case 3 : System.exit(0);
	            break;
	            
	        }
	         }
	       
	         /*fonction qui affiche le tour, le joueur qui doit jouer et qui propose un nouveau choix à l'utilisateur*/
                /*Le joueur peut en effet taper 1 pour entrer un nouveau mot, passer son tour en tapant 2 ou abandonner la partie en tapant 3*/
	   public void  jeu_contre_joueur() {
	        int choix;
	        Scanner sc = new Scanner(System.in);
	        System.out.println("*****************************************************\n");
	        joueur_tour = jo.getjoueurtour();
	        System.out.printf("Tour numéro %d  || Joueur numéro %d\n\n",tour,joueur_tour);
	        System.out.println("Pour Entrer un nouveau mot Tapez 1\n");
	        System.out.println("Pour passer votre tour tapez 2\n");
	        System.out.println("Pour abandonner la partie tapez 3\n");
	        jo.afficher_pot();
	        System.out.println("*****************************************************\n");
	        choix = sc.nextInt(); 
	         
	        choix_jeucontre_joueur(choix);
	        
	   }
	   /*Fonction qui prend en paramétre le choix du joueur*/
          /*Si le joueur a tapé 1 le mot qu'il rentre sera pris en compte par une autre fonction */
          /* Si le joueur a tapé 2 le mot on rajoute 2 lettres au pot, on commence un nouveau tour et on affiche le pot ainsi que les mots trouvés */
	   public void choix_jeucontre_joueur(int choix) { 
	        switch(choix) {

	            case 1 :  saisie_mot(0,0); jeu_contre_joueur(); 
	            break;

	            case 2 : jo.actualiser_pot();  tour = jo.nouveautour();  jo.afficher_mots(nb_mots1,nb_mots2); jeu_contre_joueur();
	            break;

	            case 3 : System.exit(0);
	            break;
	            
	        }
	   }
	       

	   /*fonction identique à la précédente mais dans le cas d'une partie contre l'ordinateur */
	    public void  jeu_contre_ordinateur() {
	        int choix,verification;
	        Scanner sc = new Scanner(System.in);
	        System.out.println("*****************************************************\n");
	        joueur_tour = jo.getjoueurtour();
	     if(joueur_tour == 1) { 
	    System.out.printf("Tour numéro %d  || C'est au joueur de jouer\n\n",tour,joueur_tour);
	    System.out.println("Pour Entrer un nouveau mot Tapez 1\n");
	        System.out.println("Pour passer votre tour tapez 2\n");
	        System.out.println("Pour abandonner la partie tapez 3\n");
	        jo.afficher_pot();
	        System.out.println("*****************************************************\n");
	        choix = sc.nextInt(); choice(choix);
	     } else { System.out.printf("Tour numéro %d  || C'est à l'ordinateur de jouer\n\n",tour,joueur_tour);  
	       verification = jo.verification_ordinateur(nb_mots2); check(verification,0); } }
	    
	    /*fonction qui lance une verification du mot rentré et qui vérifie que la partie n'est pas terminée*/
	    public void check(int verification, int fin) { 
	         if(verification == 1) { 
	          tour = jo.nouveautour();
	          nb_mots2++; 
	          jo.afficher_mots(nb_mots1,nb_mots2);
	          fin = jo.finir_la_partie(nb_mots1,nb_mots2);
	          if(fin == 1 || fin == 2) { reinitialiser(); affichage_menu_accueil(); }
	          jeu_contre_ordinateur();
	 }
	         if(verification == 2) { 
	         jo.actualiser_pot();  tour = jo.nouveautour();  jo.afficher_mots(nb_mots1,nb_mots2); jeu_contre_ordinateur();
	 }
	        }
	            
	       
	    /*fonction qui prend en compte le choix du joueur lors d'une partie contre l'ordinateur */
	 void choice(int choix) { 

	switch(choix) {

	            case 1 :  saisie_mot_joueur(0,0); jeu_contre_ordinateur();
	            break;

	            case 2 : jo.actualiser_pot();  tour = jo.nouveautour();  jo.afficher_mots(nb_mots1,nb_mots2); jeu_contre_ordinateur();
	            break;

	            case 3 : System.exit(0);
	            break;
	            
	        }


	 }

	 /*fonction de saisie d'un mot par le joueur face à l'ordinateur*/
	  void saisie_mot_joueur(int verification,int fin) {
	                     String mot;
	                     Scanner word = new Scanner(System.in);
	                     System.out.println("\n");
	                     mot = word.nextLine(); jo.verification_pot(mot); 
	                     verification = jo.getVerification(); 
	                     
	                     check_saisie_motjoueur(verification,mot,fin);
	                     jo.afficher_mots(nb_mots1,nb_mots2);
	                     fin = jo.finir_la_partie(nb_mots1,nb_mots2);
	                     if(fin == 1 || fin == 2) { affichage_menu_accueil(); }

	                     jeu_contre_ordinateur();

	                     }
	                     
	  /*fonction qui vérifie que le mot saisi par le joueur est bien valide */                                       
	                  public void check_saisie_motjoueur(int verification,String mot, int fin) { 
	                    
	                	  switch(verification) {
	                	  case 1 : tour = jo.nouveautour(); System.out.println("Félicitations, vous venez de trouver un mot !\n");
	 	                 
	                               nb_mots1++; jo.Ajout(joueur_tour,mot,nb_mots1); jo.ajout_pot(); jo.actualiser_pot();
	                	  break;	  
	                	  case 2 : System.out.println("Veuillez rejouer s'il vous plait\n");
                                 break;
	                	  }
	                  }
	                	  
	                	  
	                	  
	                	  
	  /*fonction de saisie d'un mot par un des 2 joueurs*/                                   
	                    void saisie_mot (int verification,int fin) {
	                     String mot;
	                     System.out.println("\n");
	                     Scanner word = new Scanner(System.in);
	                     mot = word.nextLine(); jo.verification_pot(mot); 
	                     verification = jo.getVerification();
	                     check_saisie_mot(verification,mot,fin);
                        jo.afficher_mots(nb_mots1,nb_mots2);
	                     fin = jo.finir_la_partie(nb_mots1,nb_mots2);
	                     if(fin == 1 || fin == 2) { affichage_menu_accueil(); }
	                     jeu_contre_joueur();

	                     }
	  /*fonction qui vérifie que le mot saisie par l'un des 2 joueurs est bien valide */
	                    public void check_saisie_mot(int verification,String mot, int fin) { 
		                    
		                	  switch(verification) {
		                	  case 1 : tour = jo.nouveautour(); System.out.println("Félicitations, vous venez de trouver un mot !\n");
		 	                  
		                        if(joueur_tour == 1) { nb_mots1++; jo.Ajout(joueur_tour,mot,nb_mots1); jo.ajout_pot(); jo.actualiser_pot();
		                        } else { nb_mots2++; jo.Ajout(joueur_tour,mot,nb_mots2);jo.actualiser_pot();  jo.ajout_pot(); }
		                	  break;	  
		                	  case 2 : System.out.println("Veuillez rejouer s'il vous plait\n");
                                         break;
		                	  }
		                  }
         /*réinitialise le pot commun et les mots trouvés aprés la fin d'une partie */
                              public void reinitialiser() { 
                              nb_mots1 = 0; nb_mots2 = 0;
                              jo.reinitialisation();

                              }

	 }