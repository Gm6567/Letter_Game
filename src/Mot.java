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
 public int tirage() {
      
      lettre1 = hasard.nextInt(26);
      lettre2 = hasard.nextInt(26);
        for(int i = 0; i < 26; i++) { 
        if(i == lettre1 || i == lettre2) { sac_commun[i] = 1; } else { sac_commun[i] = 0; }  }
        
           if (lettre1 <= lettre2) { return 1; } else { return 2; }
                      
 
            } 


public void affichage_Lettres_Ordi(){
System.out.printf("Le joueur a tiré la lettre %c\n",lettres[lettre1]);
System.out.printf("L'ordinateur a tiré la lettre %c\n",lettres[lettre2]);

}

public void affichage_Lettres(){
System.out.printf("Le joueur numéro 1 a tiré la lettre %c\n",lettres[lettre1]);
System.out.printf("Le joueur numéro 2 a tiré la lettre %c\n",lettres[lettre2]);

}
public void ajout(int joueur_tour, String mot, int nb_mots) {
    if(joueur_tour == 1) { Mots_joueur1[nb_mots - 1] = mot; }
    if(joueur_tour == 2) { Mots_joueur2[nb_mots - 1] = mot; }
   }

public void affichage_mots(int nb1, int nb2) {
if (nb1 > 0 ) { System.out.println("Voici les mots trouvés par le joueur numéro 1 :\n"); }
for(int i = 0; i < nb1; i++) { System.out.printf("%s\n",Mots_joueur1[i]); }

if (nb2 > 0 ) { System.out.println("Voici les mots trouvés par le joueur numéro 2 :\n"); }
for(int j = 0; j < nb2; j++) { System.out.printf("%s\n",Mots_joueur2[j]); }


}
public void initialiser_pot_commun() {
    
    
     for(int i = 0; i < 26; i++) { 
if(lettre1 == i && lettre2 == i) { sac_commun[i] = 2; }  

     else { 
if(lettre1 == i || lettre2 == i ) { sac_commun[i] = 1; }  else { sac_commun[i] = 0; }
          }


   }  } 


public void actualiser_pot_commun() {
      lettre1 = hasard.nextInt(26);
      lettre2 = hasard.nextInt(26);
     for(int i = 0; i < 26; i++) { 
if(lettre1 == i && lettre2 == i) { sac_commun[i] += 2; }  

     else { 
if(lettre1 == i || lettre2 == i ) { sac_commun[i] += 1; } 
          }


   }  }



   public void afficher_pot_commun() {
     System.out.println("\n             POT COMMUN              \n");
     for(int i = 0; i < 26; i++) { 

 if(sac_commun[i] > 0) {  System.out.printf("               %d x  %c\n",sac_commun[i],lettres[i]);   }  }
   } 

public int verification(String mot) {
int mot_ok = 0;
mot_ok =  verificationDictionnaire(mot);
if(mot_ok != 1) { System.out.println("Désolé mais le mot n'est pas présent dans le dictionnaire\n"); return 2;  }

mot_ok = verification_sac_commun(mot);
if(mot_ok != 1) { System.out.println("Désolé mais il vous manque des lettres pour écrire ce mot\n"); return 2;  }

return 1;
}
public int verification_sac_commun(String mot) {
int a = mot.length();
char[] tab = new char[a];
int impossible = 0;
 

for(int i = 0; i < 26; i++) { sac_commun_temporaire[i] = sac_commun[i]; }

for(int x = 0; x < a; x++){
     tab[x] = mot.charAt(x);
    for(int j = 0; j < 26; j++) {if(tab[x] == lettres[j]) { sac_commun[j] = sac_commun[j] - 1; }
        if(sac_commun[j] < 0) {
for(int i = 0; i < 26; i++) { sac_commun[i] = sac_commun_temporaire[i]; } 
return 0; }  } }



return 1;


} 

public int verificationDictionnaire(String mot) {
    try{
 FileReader filereader = new FileReader(new File("Dictionnaire.txt"));
 BufferedReader br = new BufferedReader(filereader);
 
 String line;
 
 while ((line = br.readLine()) != null) { 

 if(mot.equals(line)) { return 1;  }
        
      }
 } 
    catch (Exception e){
			System.out.println(e.toString());
		}

 return 0;
}



 
 }