package tools;

import java.util.Scanner;

/**
 * Classe Utility - Metodi statici di servizio (menu, pulizia schermo, attesa).
 */
public final class Utility {

    // Costruttore privato per evitare istanziazione
    private Utility() {
        throw new AssertionError("Utility class - non istanziabile");
    }

    /**
     * Pulisce lo schermo in modo compatibile con diversi sistemi operativi.
     */
    public static void clrScr() {
        try {
            if (isWindows()) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                String term = System.getenv("TERM");
                boolean canUseClear = term != null && !term.isEmpty() && !"dumb".equalsIgnoreCase(term);
                if (canUseClear) {
                    try {
                        ProcessBuilder pb = new ProcessBuilder("clear");
                        pb.redirectErrorStream(true);
                        pb.start().waitFor();
                    } catch (Exception ignored) {}
                }
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }

    /**
     * Verifica se il sistema operativo è Windows.
     *
     * @return true se Windows, false altrimenti
     */
    private static boolean isWindows() {
        String os = System.getProperty("os.name");
        return os != null && os.toLowerCase().contains("win");
    }

    /**
     * Attende per un numero specificato di millisecondi.
     *
     * @param attesa tempo in millisecondi
     */
    public static void Wait(int attesa) {
        try {
            if (attesa > 0) Thread.sleep(attesa);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Mostra un menu a video e restituisce la scelta valida dell'utente.
     *
     * @param opzioni  array di opzioni (la prima riga è il titolo)
     * @param tastiera oggetto Scanner per input utente
     * @return scelta numerica valida dell'utente
     */
    public static int Menu(String opzioni[], Scanner tastiera) {
        int scelta;

        do {
            clrScr();
            System.out.println("------------------");
            System.out.println(opzioni[0]);
            System.out.println("------------------");
            for (int i = 1; i < opzioni.length; i++) {
                System.out.println("[" + i + "] " + opzioni[i]);
            }

            try {
                scelta = Integer.parseInt(tastiera.nextLine());
            } catch (NumberFormatException ex) {
                scelta = -1;
            }

            if ((scelta < 1) || (scelta > opzioni.length - 1)) {
                System.out.println("Opzione Sbagliata");
                Wait(2000);
            }
        } while ((scelta < 1) || (scelta > opzioni.length - 1));

        return scelta;
    }
}
