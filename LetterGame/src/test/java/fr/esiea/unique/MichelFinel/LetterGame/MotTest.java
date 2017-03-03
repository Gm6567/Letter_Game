package fr.esiea.unique.MichelFinel.LetterGame;

import junit.framework.TestCase;

public class MotTest extends TestCase {
Mot m = new Mot();

	public void testVerification() {
		// les fonctions vérifications de dictionnaire et Pot commun sont déja testés 
	}

public void testAjouter_1_lettrebis() {
	int i = m.verification_sac_commun("a");
	if(i == 1) { assertTrue(false); } else { assertFalse(false); } 
	m.ajouter_1_lettrebis(0); //A
	i = m.verification_sac_commun("a");
	if(i == 1) { assertTrue(true); } else { assertTrue(false); } 
	}

	public void testVerification_sac_commun() {
		// on ajoute les lettres du mot "attention" au pot
	m.ajouter_1_lettrebis(0); //A
	m.ajouter_1_lettrebis(19);//T
	m.ajouter_1_lettrebis(19);//T
	m.ajouter_1_lettrebis(4); //E	
	m.ajouter_1_lettrebis(13); //N
	m.ajouter_1_lettrebis(19); //T
	m.ajouter_1_lettrebis(8); //I
	m.ajouter_1_lettrebis(14); //O
	m.ajouter_1_lettrebis(13); //N
	
	int i = m.verification_sac_commun("attention");
	if(i == 1) { assertTrue(true); } else { assertTrue(false); } 
	// on teste ensuite avec un mot qui n'est pas dans le pot
	i = m.verification_sac_commun("bonjour");
	if(i == 1) { assertTrue(false); } else { assertFalse(false); } 
		
	}
	
	public void testVerificationDictionnaire() {
		// on fait des test sur le dictionnaire
		
		int i = m.verificationDictionnaire("coucou"); // test avec un mot présent dans le dictionnaire 
		// i est mis à 1 si le mot est présent et à 0 sinon
		if (i == 1) { assertTrue(true); } else { assertTrue(false); } 
	    i = m.verificationDictionnaire("hello"); // test avec un mot non présent dans le dictionnaire
	 // i est mis à 1 si le mot est présent et à 0 sinon
		if (i == 1) { assertTrue(false); } else { assertFalse(false); }  
	// Le test devrait fonctionner mais bizarrement la classe Mot ne reconnait pas le fichier dictionnaire pourtant bien présent
		
	}

	public void testOrdinateur_cherche_mot() {
		int i = m.Ordinateur_cherche_mot(0);
		if( i == 1) { assertTrue(false); } else { assertFalse(false); }
		m.ajouter_1_lettrebis(0); //A
		m.ajouter_1_lettrebis(19);//T
		m.ajouter_1_lettrebis(19);//T
		m.ajouter_1_lettrebis(4); //E	
		m.ajouter_1_lettrebis(13); //N
		m.ajouter_1_lettrebis(19); //T
		m.ajouter_1_lettrebis(8); //I
		m.ajouter_1_lettrebis(14); //O
		m.ajouter_1_lettrebis(13); //N
		i = m.Ordinateur_cherche_mot(0);
		if( i == 1) { assertTrue(true); } else { assertTrue(false); }
	}

	public void testEffacer_sac_commun() {
		m.ajouter_1_lettrebis(0); //A
		m.ajouter_1_lettrebis(19);//T
		m.ajouter_1_lettrebis(19);//T
		m.ajouter_1_lettrebis(4); //E	
		m.ajouter_1_lettrebis(13); //N
		m.ajouter_1_lettrebis(19); //T
		m.ajouter_1_lettrebis(8); //I
		m.ajouter_1_lettrebis(14); //O
		m.ajouter_1_lettrebis(13); //N
		int i = m.verification_sac_commun("attention");
		if( i == 1) { assertTrue(true); } else { assertTrue(false); }
		m.effacer_sac_commun();
		i = m.verification_sac_commun("attention");
		if( i == 1) { assertTrue(false); } else { assertFalse(false); }
		
	}

}
