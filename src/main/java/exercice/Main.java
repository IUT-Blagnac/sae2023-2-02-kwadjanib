package exercice;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String texte = "Ceci est une phrase longue avec des mots plus longs ecrit au hayafecyc duzdgvjkdz bfvbsd vdh cjdb dcjb bdjbvjd";
        List<Character> ordre = List.of('p', 'l', 'u', 's', 'c', 'e', 'i', 'm');
        System.out.println(Exercice.solution("Ceci est une phrase longue avec des mots plus longs ecrit au hayafecyc duzdgvjkdz bfvbsd vdh cjdb dcjb bdjbvjd", List.of('p', 'l', 'u', 's', 'c', 'e', 'i', 'm'))
);
        // output: [classer, texte, exemple, a, de]
    }
}
