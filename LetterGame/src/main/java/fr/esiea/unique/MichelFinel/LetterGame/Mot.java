package fr.esiea.unique.MichelFinel.LetterGame;
import java.util.Random;
import java.io.*;
import java.io.File;


public class Mot {
Random hasard = new Random();
int lettre1,lettre2;
int nb1 = 0;
int nb2 = 0;
int sac_commun[] = new int[26];
int sac_commun_temporaire[] = new int[26];
String Mots_joueur1[] = new String[10];
String Mots_joueur2[] = new String[10];

char lettres[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

/*Fonction determine quel joueur commence en premier */
/*renvoie 1 si c'est le joueur 1 et 2 si c'est le joueur 2*/
 public int tirage() {
      
      lettre1 = hasard.nextInt(26);
      lettre2 = hasard.nextInt(26);
        for(int i = 0; i < 26; i++) { 
        if(i == lettre1 || i == lettre2) { sac_commun[i] = 1; } else { sac_commun[i] = 0; }  }
        
           if (lettre1 <= lettre2) { return 1; } else { return 2; }
                      
 
                     } 

 /*Affiche les lettres tirées par le joueur et l'ordinateur */
 
public void affichage_Lettres_Ordi(){
System.out.printf("Le joueur a tiré la lettre %c\n",lettres[lettre1]);
System.out.printf("L'ordinateur a tiré la lettre %c\n",lettres[lettre2]);

}

 /*fonction identique à la précédente mais dans le cas où c'est 2 joueurs */

public void affichage_Lettres(){
System.out.printf("Le joueur numéro 1 a tiré la lettre %c\n",lettres[lettre1]);
System.out.printf("Le joueur numéro 2 a tiré la lettre %c\n",lettres[lettre2]);

}

/*Ajout d'un mots aux mots trouvés par le joueur 1 ou le joueur 2*/
public void ajout(int joueur_tour, String mot, int nb_mots) {
    if(joueur_tour == 1) { Mots_joueur1[nb_mots - 1] = mot; }
    if(joueur_tour == 2) { Mots_joueur2[nb_mots - 1] = mot; }
   }

/*Affiche l'ensemble des mots trouvés par chacun des joueurs*/

public void affichage_mots(int nb1, int nb2) {
if (nb1 > 0 ) { System.out.println("Voici les mots trouvés par le joueur numéro 1 :\n"); }
for(int i = 0; i < nb1; i++) { System.out.printf("Mot numéro %d ---> %s\n",i + 1,Mots_joueur1[i]); }

if (nb2 > 0 ) { System.out.println("Voici les mots trouvés par le joueur numéro 2 :\n"); }
for(int j = 0; j < nb2; j++) { System.out.printf("Mot numéro %d ---> %s\n",j + 1,Mots_joueur2[j]); }


}

/*initialise le pot commun avec les 2 lettres tirés pour déterminer qui commence */
public void initialiser_pot_commun() {
    
    
     for(int i = 0; i < 26; i++) { 
if(lettre1 == i && lettre2 == i) { sac_commun[i] = 2; }  

     else { 
if(lettre1 == i || lettre2 == i ) { sac_commun[i] = 1; }  else { sac_commun[i] = 0; }
          }


   }  } 

/*Actualise le pot commun en lui rajoutant 2 lettres */

public void actualiser_pot_commun() {
      lettre1 = hasard.nextInt(26);
      lettre2 = hasard.nextInt(26);
     for(int i = 0; i < 26; i++) { 
if(lettre1 == i && lettre2 == i) { sac_commun[i] += 2; }  

     else { 
if(lettre1 == i || lettre2 == i ) { sac_commun[i] += 1; } 
          }


   }  }

/*Ajout d'une lettre au pot commun, fonction appelé lorsqu'un joueur trouve un mot*/

public void ajouter_1_lettre () {
lettre1 = hasard.nextInt(26);

 for(int i = 0; i < 26; i++) { 
if(lettre1 == i) { sac_commun[i] += 1; }  


 }
}

/*fonction identique à la précédente mais la variable "lettre1" est passé en paramétre, fonction utile pour les tests*/

public void ajouter_1_lettrebis (int lettre1) {


 for(int i = 0; i < 26; i++) { 
if(lettre1 == i) { sac_commun[i] += 1; }  


 }
}

/*Fonction qui Affiche l'ensemble du pot commun */

   public void afficher_pot_commun() {
int comptage = 0;
for(int j = 0; j < 26; j++) { 

 if(sac_commun[j] > 0) { comptage = comptage + sac_commun[j];   }  
   } 


     System.out.printf("\nPOT COMMUN COMPOSÉ DE %d LETTRES\n",comptage);
     for(int i = 0; i < 26; i++) { 

 if(sac_commun[i] > 0) {  System.out.printf("               %d x  %c\n",sac_commun[i],lettres[i]);   }  }
   } 

 /*Fonction qui lance une vérification globale pour un mot en appelant des fonctions qui vérifient le dictionnaire et le pot commun */  
public int verification(String mot) {
int mot_ok = 0;
mot_ok =  verificationDictionnaire(mot);
if(mot_ok != 1) { System.out.println("Désolé mais le mot n'est pas présent dans le dictionnaire\n"); return 2;  }


mot_ok = verification_sac_commun(mot);
if(mot_ok != 1) { System.out.println("Désolé mais il vous manque des lettres pour écrire ce mot\n"); return 2;  }

return 1;
}

/* fonction que le mot est bien présent dans le pot commun */

public int verification_sac_commun(String mot) {
int a = mot.length();
char[] tab = new char[a];
 
for(int i = 0; i < 26; i++) { sac_commun_temporaire[i] = sac_commun[i]; }

for(int x = 0; x < a; x++){
     tab[x] = mot.charAt(x);
    for(int j = 0; j < 26; j++) {if(tab[x] == lettres[j]) { sac_commun[j] = sac_commun[j] - 1; }
        if(sac_commun[j] < 0) {
for(int i = 0; i < 26; i++) { sac_commun[i] = sac_commun_temporaire[i]; } 
return 0; }  } }

return 1;
                                                } 

/* fonction qui vérifie que le mot est bien présent dans le dictionnaire */
public int verificationDictionnaire(String mot) {
    try{
 FileReader filereader = new FileReader(new File("Dictionnaire.txt"));
 BufferedReader br = new BufferedReader(filereader);
 String line;
 while ((line = br.readLine()) != null) { 

 if(mot.equals(line)) {  return 1;  }
        
      }
 } 
    catch (Exception e){
			System.out.println(e.toString());
		}
  return 0;
}
/*fonction qui permet à l'ordinateur de trouver un mot*/

public int Ordinateur_cherche_mot(int nb) {
    String mot,line;
    int check;
    try{ FileReader filereader = new FileReader(new File("Dictionnaire.txt"));
         BufferedReader br = new BufferedReader(filereader);
 while ((line = br.readLine()) != null) { 
 mot = line; check = verification_sac_commun(mot);
if(check == 1) {
 System.out.println("L'ordinateur réflechit ...\n"); Thread.sleep(1000); // on donne un délai artificiel à l'ordinateur pour trouver un mot
 System.out.printf("L'ordinateur a trouvé le mot %s\n",mot);
   ajout(2,mot,nb + 1);  ajouter_1_lettre();  actualiser_pot_commun();   // on ajoute le mot et on actualise le pot commun
   return 1; }   } } 
    catch (Exception e){ System.out.println(e.toString()); }
    return 0;
}
/*fonction qui efface le pot commun aprés la fin d'une partie*/
 public void effacer_sac_commun() {
 for(int i = 0; i < 26; i++) {  sac_commun[i] = 0; sac_commun_temporaire[i] = 0;  }

  }
 }