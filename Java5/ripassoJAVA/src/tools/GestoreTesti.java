package tools;

/**
 * Classe GestoreTesti - Fornisce metodi statici per operazioni su stringhe.
 */
public final class GestoreTesti {

    // Costruttore privato per evitare istanziazione
    private GestoreTesti() {
    }

    /**
     * Restituisce la lunghezza della frase.
     *
     * @param frase la frase su cui calcolare la lunghezza
     * @return il numero di caratteri della frase
     */
    public static int getLunghezza(String frase) {
        return frase.length();
    }

    /**
     * Verifica se la frase contiene una determinata parola.
     *
     * @param frase  la frase in cui cercare
     * @param parola la parola da cercare
     * @return true se la parola è presente, false altrimenti
     */
    public static boolean contieneParola(String frase, String parola) {
        return frase.contains(parola);
    }

    /**
     * Sostituisce tutte le occorrenze di una parola con un'altra.
     *
     * @param frase         la frase originale
     * @param daSostituire  la parola da sostituire
     * @param nuovaParola   la nuova parola
     * @return la frase modificata
     */
    public static String sostituisciParola(String frase, String daSostituire, String nuovaParola) {
        return frase.replaceAll(daSostituire, nuovaParola);
    }

    /**
     * Conta il numero di vocali e consonanti nella frase.
     *
     * @param frase la frase da analizzare
     * @return un array di due elementi: [vocali, consonanti]
     */
    public static int[] contaVocaliConsonanti(String frase) {
        int vocali = 0, consonanti = 0;
        frase = frase.toLowerCase();

        for (char c : frase.toCharArray()) {
            if (Character.isLetter(c)) {
                if ("aeiou".indexOf(c) != -1)
                    vocali++;
                else
                    consonanti++;
            }
        }
        return new int[]{vocali, consonanti};
    }

    /**
     * Inverte l'ordine dei caratteri nella frase.
     *
     * @param frase la frase da invertire
     * @return la frase invertita
     */
    public static String invertiFrase(String frase) {
        return new StringBuilder(frase).reverse().toString();
    }

    /**
     * Estrae una sottostringa dalla frase.
     *
     * @param frase  la frase da cui estrarre
     * @param inizio indice iniziale (incluso)
     * @param fine   indice finale (escluso)
     * @return la sottostringa estratta
     * @throws IndexOutOfBoundsException se gli indici non sono validi
     */
    public static String estraiSubstring(String frase, int inizio, int fine) {
        return frase.substring(inizio, fine);
    }
}
