import java.util.*;
/**
 * SAE 2.2 - Algo
 *
 */
public class Exercice
{
    /**
     * Permet de trier les mots d'un texte dans un ordre donné
     * 
     * @param texte : une chaîne de caractères (sans accents)
     * @param ordre : une liste de caractères
     * 
     * @return la liste triée de mots
     */
    public static List<String> solution(String texte, List<Character> ordre) {
        
        //Déclaration et initialisation des variables
        String[] tabMots;
        List<String> listeMots = new ArrayList<String>();
        List<String> listeTriee = new ArrayList<String>();

        
        //Découper texte en une liste de mots
        tabMots = texte.split("[^a-zA-Z0-9]+");//On sépare chaque mots qu'on met dans un tableau
        for (int i=0;i<tabMots.length;i++){//On convertit le tableau en une liste
            listeMots.add(tabMots[i]);
        }
        
        // Trier listeMots dans l'ordre donné
        for (int i=0;i<ordre.size();i++){
            String debut = ordre.get(i).toString();
            for (int j=0;j<listeMots.size();j++){
                if(listeMots.get(j).startsWith(debut)){
                    listeTriee.add(listeMots.get(j));
                    listeMots.remove(j);
                    j--;
                }
            }
        }
        for (int i=0;i<listeMots.size();i++){
            listeTriee.add(listeMots.get(i));
        }
        
        return listeTriee;
    }
}