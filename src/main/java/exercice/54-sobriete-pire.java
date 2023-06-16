package exercice;

import java.util.ArrayList;
import java.util.List;

public class Exercice {
    public static List<String> solution(String str, List<Character> ordre) {
        List<String> mots = new ArrayList<>();
        StringBuilder mot = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                mot.append(c);
            } else if (mot.length() > 0) {
                mots.add(mot.toString());
                mot.setLength(0);
            }
        }

        if (mot.length() > 0) {
            mots.add(mot.toString());
        }

        List<String> motsOrdre = new ArrayList<>();
        List<String> motsOrdre1 = new ArrayList<>();

        for (String motStr : mots) {
            char Lettre = Character.toLowerCase(motStr.charAt(0));
            if (ordre.contains(Character.toLowerCase(Lettre))) {
                    motsOrdre.add(motStr);
            } else {
                motsOrdre1.add(motStr);
            }
        }

        motsOrdre.sort((s1, s2) -> {
            char c1 = Character.toLowerCase(s1.charAt(0));
            char c2 = Character.toLowerCase(s2.charAt(0));
            int index = ordre.indexOf(Character.toLowerCase(c1));
            int index1 = ordre.indexOf(Character.toLowerCase(c2));

            if (index == index1) {
                if (s1.length() > 1 && s2.length() > 1) {
                    char Lettre1 = Character.toLowerCase(s1.charAt(1));
                    char Lettre2 = Character.toLowerCase(s2.charAt(1));
                    int Index = ordre.indexOf(Character.toLowerCase(Lettre1));
                    int Index1 = ordre.indexOf(Character.toLowerCase(Lettre2));

                    if (Index != -1 && Index1 != -1) {
                        return Integer.compare(Index, Index1);
                    }
                }
                return s1.compareToIgnoreCase(s2);
            }

            if (index != -1 && index1 != -1) {
                return Integer.compare(index, index1);
            } else if (index != -1) {
                return -1;
            } else if (index1 != -1) {
                return 1;
            } else {
                return s1.compareToIgnoreCase(s2);
            }
        });

        List<String> resultat = new ArrayList<>();
        for (char lettre : ordre) {
            for (int i = 0; i < motsOrdre.size(); i++) {
                String motStr = motsOrdre.get(i);
                if (Character.toLowerCase(motStr.charAt(0)) == Character.toLowerCase(lettre)) {
                    resultat.add(motStr);
                    motsOrdre.remove(i);
                    i--;
                }
            }
        }
        resultat.addAll(motsOrdre);
        resultat.addAll(motsOrdre1);
        return resultat;
    }
}