package exercice;

import java.util.ArrayList;
import java.util.List;

public class efficacitemeilleur {
    /**
     * Trie les mots d'un texte selon l'ordre spécifié.
     *
     * @param texte Le texte à trier.
     * @param ordre L'ordre des caractères à utiliser pour le tri.
     * @return Une liste contenant les mots triés.
     */
    public static List<String> solution(String texte, List<Character> ordre) {
        List<String> motsTries = new ArrayList<>();
        StringBuilder mot = new StringBuilder();

        int texteLength = texte.length();
        int ordreSize = ordre.size();

        for (int i = 0; i < texteLength; i++) {
            char c = texte.charAt(i);

            if (Character.isLetter(c)) {
                mot.append(c);
            } else {
                if (mot.length() > 0) {
                    ajouterMot(motsTries, mot.toString(), ordre, ordreSize);
                    mot.setLength(0);
                }
            }
        }

        if (mot.length() > 0) {
            ajouterMot(motsTries, mot.toString(), ordre, ordreSize);
        }

        return motsTries;
    }

    /**
     * Ajoute un mot dans la liste triée des mots.
     *
     * @param motsTries La liste des mots triés.
     * @param mot Le mot à ajouter.
     * @param ordre L'ordre des caractères à utiliser pour le tri.
     * @param ordreSize La taille de l'ordre des caractères.
     */
    private static void ajouterMot(List<String> motsTries, String mot, List<Character> ordre, int ordreSize) {
        int index = motsTries.size();
        for (int i = 0; i < motsTries.size(); i++) {
            if (comparerMots(mot, motsTries.get(i), ordre, ordreSize) < 0) {
                index = i;
                break;
            }
        }
        motsTries.add(index, mot);
    }

    /**
     * Compare deux mots selon l'ordre spécifié.
     *
     * @param mot1 Le premier mot à comparer.
     * @param mot2 Le deuxième mot à comparer.
     * @param ordre L'ordre des caractères à utiliser pour la comparaison.
     * @param ordreSize La taille de l'ordre des caractères.
     * @return Une valeur négative si le premier mot est inférieur, une valeur positive si le premier mot est supérieur,
     *         ou zéro si les deux mots sont égaux selon l'ordre spécifié.
     */
    private static int comparerMots(String mot1, String mot2, List<Character> ordre, int ordreSize) {
        int longueur1 = mot1.length();
        int longueur2 = mot2.length();
        int longueurMin = Math.min(longueur1, longueur2);

        for (int i = 0; i < longueurMin; i++) {
            char char1 = mot1.charAt(i);
            char char2 = mot2.charAt(i);
            int index1 = getIndex(ordre, char1, ordreSize);
            int index2 = getIndex(ordre, char2, ordreSize);

            if (index1 != -1 && index2 != -1) {
                if (index1 != index2) {
                    return index1 - index2;
                }
            } else if (index1 == -1 && index2 == -1) {
                continue;
            } else if (index1 == -1) {
                return 1;
            } else if (index2 == -1) {
                return -1;
            }
        }

        return longueur1 - longueur2;
    }

    /**
     * Retourne l'index d'un caractère dans la liste donnée.
     *
     * @param liste La liste de caractères.
     * @param c Le caractère à rechercher.
     * @param ordreSize La taille de l'ordre des caractères.
     * @return L'index du caractère s'il est trouvé, -1 sinon.
     */
    private static int getIndex(List<Character> liste, char c, int ordreSize) {
        for (int i = 0; i < ordreSize; i++) {
            if (liste.get(i) == c) {
                return i;
            }
        }
        return -1;
    }
}
