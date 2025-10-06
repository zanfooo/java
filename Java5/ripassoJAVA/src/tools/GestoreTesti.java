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
     * metodo conta vocali in una stringa
     *
     * @param str stringa
     * @return numero vocali
     */
    public static int contaVocali(String str) {
        int cont = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                    c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
                cont++;
        }
        return cont;
    }

    /**
     * metodo conta consonanti in una stringa
     *
     * @param str stringa
     * @return numero consonanti
     */
    public static int contaConsonanti(String str) {
        int cont = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                    c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == ' '))
                cont++;
        }
        return cont;
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

