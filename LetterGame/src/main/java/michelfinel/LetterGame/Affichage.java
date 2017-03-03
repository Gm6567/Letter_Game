package michelfinel.LetterGame;
import java.util.Scanner;

public class Affichage {
	 Joueur jo = new Joueur();
	 int joueur_tour;
	 int tour = 1;
	 int nb_mots1 = 0;
	 int nb_mots2 = 0; 
	 public void affichage_menu_accueil() {
	        int choix;
	        Scanner sc = new Scanner(System.in);
	        System.out.println("*****************************************************\n");
	        System.out.println("Pour entamer une nouvelle partie contre un joueur tapez 1\n");
	        System.out.println("Pour entamer une nouvelle partie contre l'ordinateur tapez 2\n");
	        System.out.println("Pour quitter le jeu tapez 3\n");
	        System.out.println("*****************************************************\n");
	        choix = sc.nextInt();
	     
	        switch(choix) {

	            case 1 : jo.partie(); jeu_contre_joueur();
	            break;

	            case 2 :  jo.partieOrdinateur();  jeu_contre_ordinateur();
	            break;

	            case 3 : System.exit(0);
	            break;
	            
	        }

	       }

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
	         
	        switch(choix) {

	            case 1 :  saisie_mot(0,0); jeu_contre_joueur();
	            break;

	            case 2 : jo.actualiser_pot();  tour = jo.nouveautour();  jo.afficher_mots(nb_mots1,nb_mots2); jeu_contre_joueur();
	            break;

	            case 3 : System.exit(0);
	            break;
	            
	        }
	            
	       } 


	    public void  jeu_contre_ordinateur() {
	        int choix,verification;
	        String mot;
	        int fin;
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
	       verification = jo.verification_ordinateur(nb_mots2);
	         
	         if(verification == 1) { 
	          tour = jo.nouveautour();
	          nb_mots2++; 
	          jo.afficher_mots(nb_mots1,nb_mots2);
	          fin = jo.finir_la_partie(nb_mots1,nb_mots2);
	          if(fin == 1 || fin == 2) { affichage_menu_accueil(); }
	          jeu_contre_ordinateur();
	 }
	         if(verification == 2) { 
	         jo.actualiser_pot();  tour = jo.nouveautour();  jo.afficher_mots(nb_mots1,nb_mots2); jeu_contre_ordinateur();
	 }
	        }
	            
	       } 

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


	  void saisie_mot_joueur(int verification,int fin) {
	                     String mot;
	                     Scanner word = new Scanner(System.in);
	                     System.out.println("\n");
	                     mot = word.nextLine(); jo.verification_pot(mot); 
	                     verification = jo.getVerification();   
	                     if(verification == 1) { 
	                                     
	                        tour = jo.nouveautour(); System.out.println("Félicitations, vous venez de trouver un mot !\n");
	                 
	                         nb_mots1++; jo.Ajout(joueur_tour,mot,nb_mots1); jo.ajout_pot(); jo.actualiser_pot();
	                       
	                                              
	                                           }


	                     if(verification == 2) { System.out.println("Veuillez rejouer s'il vous plait\n");  }

	                     jo.afficher_mots(nb_mots1,nb_mots2);
	                     fin = jo.finir_la_partie(nb_mots1,nb_mots2);
	                     if(fin == 1 || fin == 2) { affichage_menu_accueil(); }
	                     jeu_contre_ordinateur();

	                     }


	 

	   void saisie_mot (int verification,int fin) {
	                     String mot;
	                     System.out.println("\n");
	                     Scanner word = new Scanner(System.in);
	                     mot = word.nextLine(); jo.verification_pot(mot); 
	                     verification = jo.getVerification();   
	                     if(verification == 1) { 
	                                     
	                        tour = jo.nouveautour(); System.out.println("Félicitations, vous venez de trouver un mot !\n");
	                 
	                        if(joueur_tour == 1) { nb_mots1++; jo.Ajout(joueur_tour,mot,nb_mots1); jo.ajout_pot(); jo.actualiser_pot();
	                        } else { nb_mots2++; jo.Ajout(joueur_tour,mot,nb_mots2);jo.actualiser_pot();  jo.ajout_pot(); }
	                                              
	                                           }


	                     if(verification == 2) { System.out.println("Veuillez rejouer s'il vous plait\n");  }

	                     jo.afficher_mots(nb_mots1,nb_mots2);
	                     fin = jo.finir_la_partie(nb_mots1,nb_mots2);
	                     if(fin == 1 || fin == 2) { affichage_menu_accueil(); }
	                     jeu_contre_joueur();

	                     }


	 }