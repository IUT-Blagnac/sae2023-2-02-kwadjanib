import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

import exercice.Exercice;
import java.util.*;
/**
 * 
 * @author bibil
 *test Junit initial plus test ajouter personnellement
 *
 *test 1:verifie que l'algo ne change pas la phrase quand l'ordre n'existe pas
 *test 2: pour verifier que l'algo marche avec plusieur mot égaux 
 *test 3:test pour phrase bizarre et long
 *
 */

public class ExerciceTest {
    @Test
    public void testSolution() {
        // Chaine simple avec ordre complet
        assertEquals(List.of("666","the", "the", "number", "of", "beast"), Exercice.solution("666, the number of the beast",List.of('6', 't', 'n', 'o', 'b')));
    }
        // Chaine à 1 mot
        @Test
        public void testSolution2() {
        assertEquals("Erreur de chaine à 1 mot", List.of("OK"), Exercice.solution("OK",List.of('a', 'b', 'c', 'd', 'e')));
        // Chaine vide
        }
        @Test
        public void testSolution3() {
        assertEquals(List.of(""), Exercice.solution("",List.of('6', 't', 'n', 'o', 'b')));
        }
        // Chaine donnée en exemple
        @Test
        public void testSolution4() {
        assertEquals(List.of("fait", "Il", "aujourd", "aout", "beau", "hui", "comme", "en"), Exercice.solution("Il fait beau aujourd'hui comme en aout",List.of('f', 'I', 'z', 'u', 'k', 'a', 'b', 'o')));
        }
        // Ajoutez vos test ici...
        @Test
        public void testSolution5() {
            // Chaine avec des caractères inexistants dans la phrase
            assertEquals(List.of(), Exercice.solution("Il fait beau aujourd'hui", List.of('z', 'x', 'y')));
        }

        @Test
        public void testSolution6() {
            // Chaine avec des caractères dupliqués dans la phrase
            assertEquals(List.of("fait","fait","fait","fait","fait","fait","fait","fait"), Exercice.solution("fait fait fait fait fait fait fait fait ", List.of('d', 'u', 'p', 'l', 'i', 'q', 'é', 's')));
        }

        @Test
        public void testSolutionAvecPhraseLongue() {
            // Chaine avec une phrase longue
            assertEquals(List.of("phrase","plus", "longue", "longs", "une"," cjdb"," est", "ecrit", "mots", "Ceci", "avec", "des", "au", "hayafecyc", "duzdgvjkdz", "bfvbsd", "vdh", "dcjb", "bdjbvjd"),Exercice.solution("Ceci est une phrase longue avec des mots plus longs ecrit au hayafecyc duzdgvjkdz bfvbsd vdh cjdb dcjb bdjbvjd", List.of('p', 'l', 'u', 's', 'c', 'e', 'i', 'm')));
        }

    
