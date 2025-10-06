import tools.GestoreTesti;
import tools.Utility;

import java.util.Scanner;

/**
 * Classe Main - Punto di ingresso del programma Gestore di Testi.
 * Permette all'utente di inserire una frase e compiere operazioni su di essa.
 */
public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        String frase = "";

        String[] menu = {
                "GESTORE DI TESTI - Menu Principale",
                "Inserisci una nuova frase",
                "Mostra lunghezza frase",
                "Cerca una parola nella frase",
                "Sostituisci una parola",
                "Conta vocali e consonanti",
                "Inverti la frase",
                "Estrai una sottostringa",
                "Esci"
        };

        int scelta;
        do {
            scelta = Utility.Menu(menu, tastiera);

            switch (scelta) {
                case 1:
                    System.out.print("Inserisci la frase: ");
                    frase = tastiera.nextLine();
                    break;

                case 2:
                    System.out.println("Lunghezza: " + GestoreTesti.getLunghezza(frase));
                    break;

                case 3:
                    System.out.print("Inserisci la parola da cercare: ");
                    String parolaCercata = tastiera.nextLine();
                    boolean trovata = GestoreTesti.contieneParola(frase, parolaCercata);
                    System.out.println(trovata ? "Parola trovata!" : "Parola NON trovata.");
                    break;

                case 4:
                    System.out.print("Parola da sostituire: ");
                    String daSostituire = tastiera.nextLine();
                    System.out.print("Nuova parola: ");
                    String nuovaParola = tastiera.nextLine();
                    frase = GestoreTesti.sostituisciParola(frase, daSostituire, nuovaParola);
                    System.out.println("Frase modificata: " + frase);
                    break;

                case 5:
                    int[] conteggi = GestoreTesti.contaVocaliConsonanti(frase);
                    System.out.println("Vocali: " + conteggi[0]);
                    System.out.println("Consonanti: " + conteggi[1]);
                    break;

                case 6:
                    System.out.println("Frase invertita: " + GestoreTesti.invertiFrase(frase));
                    break;

                case 7:
                    try {
                        System.out.print("Indice iniziale: ");
                        int inizio = Integer.parseInt(tastiera.nextLine());
                        System.out.print("Indice finale: ");
                        int fine = Integer.parseInt(tastiera.nextLine());
                        System.out.println("Porzione: " + GestoreTesti.estraiSubstring(frase, inizio, fine));
                    } catch (Exception e) {
                        System.out.println("Indici non validi.");
                    }
                    break;

                case 8:
                    System.out.println("Uscita in corso...");
                    break;
            }

        } while (scelta != 8);

        tastiera.close();
    }
}
