package fr.esiea.unique.MichelFinel.LetterGame;

import junit.framework.TestCase;

public class JoueurTest extends TestCase {

	Joueur jo = new Joueur();
	public void testFinir_la_partie() {
		
		// on teste les 3 cas possibles de cette fonction
		int i = jo.finir_la_partie(10,8);
		if(i == 1) { assertTrue(true); } // cas juste : le joueur numéro 1 a gagné
		if(i == 2) { assertTrue(false); }
		if(i == 0) { assertTrue(false); }
		
		 i = jo.finir_la_partie(8,10);
		if(i == 1) { assertTrue(false); } 
		if(i == 2) { assertTrue(true); } // cas juste : le joueur numéro 2 a gagné
		if(i == 0) { assertTrue(false); }
		
		 i = jo.finir_la_partie(9,9);
		if(i == 1) { assertTrue(false); } 
		if(i == 2) { assertTrue(false); }
		if(i == 0) { assertTrue(true); } // cas juste : la partie n'est pas terminée vu qu'aucun des joueurs n'a trouvé 10 mots
		
	}



}
