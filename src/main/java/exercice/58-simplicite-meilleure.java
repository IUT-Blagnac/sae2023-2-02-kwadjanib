package exercice;

import java.util.ArrayList;
import java.util.List;

public class Exercice {
    public static List<String> solution(String str, List<Character> ordre) {
        List<String> lstMotsTries = new ArrayList<>();
        String[] mots = str.split("[^a-zA-Z0-9]+");
        
        for (int i = 0; i < ordre.size(); i++) {
            char charActuel = ordre.get(i);
            for (String mot : mots) {
                if (!(mot.isEmpty())) {
                    if (mot.charAt(0) == charActuel) {
                        lstMotsTries.add(mot);
                    }
                }
            }
        }
        
        for (String mot : mots) {
            if (!lstMotsTries.contains(mot)) {
                lstMotsTries.add(mot);
            }
        }
        
        return lstMotsTries;
    }
}
