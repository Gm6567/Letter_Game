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

            case 1 : jo.partie(); afficher_menu_jeu();
            break;

            case 2 :  jo.partieOrdinateur();
            break;

            case 3 : System.exit(0);
            break;
            
        }

       }

   public void  afficher_menu_jeu() {
        int choix;
        String mot;
        int verification;
        int fin;
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
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

            case 1 : System.out.println("\n");
                     mot = sc1.nextLine(); jo.verification_pot(mot); 
                     verification = jo.getVerification();   
                     if(verification == 1) { tour = jo.nouveautour(); System.out.println("Félicitations, vous venez de trouver un mot !\n");
                 
                     if(joueur_tour == 1) { nb_mots1++; jo.Ajout(joueur_tour,mot,nb_mots1); } else { nb_mots2++; jo.Ajout(joueur_tour,mot,nb_mots2); }
                                           }
                     if(verification == 2) { System.out.println("Veuillez rejouer s'il vous plait\n");  }
                     jo.afficher_mots(nb_mots1,nb_mots2);
                     fin = jo.finir_la_partie(nb_mots1,nb_mots2);
                     if(fin == 1 || fin == 2) { affichage_menu_accueil(); }
                     afficher_menu_jeu();
            break;

            case 2 : jo.actualiser_pot();  tour = jo.nouveautour();  jo.afficher_mots(nb_mots1,nb_mots2); afficher_menu_jeu();
            break;

            case 3 : System.exit(0);
            break;
            
        }
            
       } 


 }
