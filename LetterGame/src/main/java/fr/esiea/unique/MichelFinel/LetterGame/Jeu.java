package fr.esiea.unique.MichelFinel.LetterGame;

public class Jeu {

static Jeu debut = new Jeu();
Affichage a = new Affichage();
public static void main (String[] args) 
		{
                  
           debut.menu();

             }
// lancement d'une partie en faisant appel à la classe "Affichage"
public void menu () {
 
 a.affichage_menu_accueil();
}


                 

 }
