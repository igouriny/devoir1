package modele.gestionnaires;

/**
 * Le gestionnaire de scnario est un module utilitaire grant:
 * 	* la cration de numro de tlphone
 *  * les messages
 *
 *  Les fonctionnalits sont offertes pour les numros normales et les numros
 *  de criminels.
 *
 *  @author Fred Simard | ETS
 *  @revision hiver 2021
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import modele.reseau.Reseau;
import modele.tda.FileSChainee;

public class GestionnaireScenario {

    public static final String FICHIER_CONVERSATION = "ressources/conversations.txt";
    public static final String PREFIX = "514-";

    Reseau reseau = Reseau.getInstance();
    FileSChainee<String> file = new FileSChainee<String>();
    ArrayList<String> numeroCriminel = new ArrayList<String>(Reseau.NB_CRIMINELS);
    ArrayList<String> numeroStandard = new ArrayList<String>(Reseau.NB_CELLULAIRES);

    Random rand = new Random();

    private static GestionnaireScenario instance = new GestionnaireScenario();

    private GestionnaireScenario() {
        // charge les conversations
        chargementDuFichier();
    }

    /**
     * mthode qui charge le fichier de conversation
     */
    private void chargementDuFichier() {

        try {
            Scanner scanner = new Scanner(new File(FICHIER_CONVERSATION));
            while (scanner.hasNextLine()) {
                file.enfiler(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Mthode utilitaire pour gnrer une chane de caractres alatoire
     * @return String alatoire
     * @ref: https://www.baeldung.com/java-random-string
     */
    private static String generatingRandomAlphabeticString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = instance.rand.nextInt(100)+1;

        String generatedString = instance.rand.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    /**
     * Mthode retournant un message. Le message renvoy dpend de
     * si le numro est standard ou criminel. Si criminel, le message est tir
     * du scnario. Si standard, chaine de caractre alatoire
     * @param numero utilis pour envoyer le message
     * @return le message  envoyer
     */
    public static String obtenirMessage(String numero) {

        if(instance.numeroCriminel.contains(numero)) {
            try {
                return instance.file.defiler();
            }
            catch(Exception exception){
                instance.reseau.finDeSimulation();
                return null;
            }
        } else {
            return generatingRandomAlphabeticString();
        }
    }

    /**
     * Mthode qui retourne un numro choisi alatoirement parmis la
     * liste des numros criminels,  l'exception de celui reu en
     * paramtre
     * @param exclus le numro a exclure des possibilits
     * @return le numro appartenant aux numros criminels
     */
    public static String obtenirNumeroCriminelAlea(String exclus) {
        int index = instance.rand.nextInt(instance.numeroCriminel.size());
        String numero = instance.numeroCriminel.get(index);

        while(numero.equals(exclus)){
            index = instance.rand.nextInt(instance.numeroCriminel.size());
            numero = instance.numeroCriminel.get(index);
        }
        return numero;
    }

    /**
     * Mthode qui retourne un numro choisi alatoirement parmis la
     * liste des numros standard,  l'exception de celui reu en
     * paramtre
     * @param exclus le numro a exclure des possibilits
     * @return le numro appartenant aux numros standards
     */
    public static String obtenirNumeroStandardAlea(String exclus) {
        int index = instance.rand.nextInt(instance.numeroStandard.size());
        String numero = instance.numeroStandard.get(index);

        while(numero.equals(exclus)){
            index = instance.rand.nextInt(instance.numeroStandard.size());
            numero = instance.numeroStandard.get(index);
        }
        return numero;
    }

    /**
     * Mthode qui retourne un numro de tlphone alatoire
     * aprs l'avoir ajout  la liste des numros criminels
     * @return le numro sous forme the String
     */
    public static String obtenirNouveauNumeroCriminel() {
        String numero = obtenirNouveauNumeroAlea();
        instance.numeroCriminel.add(numero);
        return numero;
    }

    /**
     * Mthode qui retourne un numro de tlphone alatoire
     * aprs l'avoir ajout  la liste des numros standards
     * @return le numro sous forme the String
     */
    public static String obtenirNouveauNumeroStandard() {
        String numero = obtenirNouveauNumeroAlea();
        instance.numeroStandard.add(numero);
        return numero;
    }

    /**
     * Mthode qui construit un numro de tlphone alatoire
     * avec un prfix constant, tel que PPP-XXX-YYYY
     * @return le numro sous forme the String
     */
    private static String obtenirNouveauNumeroAlea() {

        String numero = PREFIX;
        for(int i=0;i<3;i++) {
            numero += instance.rand.nextInt(10);
        }

        numero += "-";

        for(int i=0;i<4;i++) {
            numero += instance.rand.nextInt(10);
        }

        return numero;

    }
}
