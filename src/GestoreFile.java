/**
 * GestoreFile.java
 * questa classe gestisce il salvataggio e la lettura dei podii su file
 * non sono qua per dire cose che non so spiegare per fare questa classe ho ricercato online e chiesto aiuto per farla funzionare
 * dato che da solo non ci sono riuscito prendendo spunto soprattutto dal codice del Francesco Amendola
 * @author Michael Tifi (l'ho scritto in automatica dall'IDE))
 */

import java.io.*;

public class GestoreFile {
    private String nomeFile;

    public GestoreFile(String nomeFile) {
        this.nomeFile = nomeFile;
    }

    public synchronized void salvaPodio(Giudice giudice) {
        try (FileWriter writer = new FileWriter(nomeFile, true)) {
            writer.write(giudice.getClassifica() + "\n");
            System.out.println("Podio salvato nel file '" + nomeFile + "'");
        } catch (IOException e) {
            System.err.println("Errore nel salvataggio: " + e.getMessage());
        }
    }

    public synchronized void leggiPodii() {
        File file = new File(nomeFile);
        if (!file.exists()) {
            System.out.println("Nessun podio trovato.");
            return;
        }
        System.out.println("\n--- Podii Precedenti ---");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Errore nella lettura: " + e.getMessage());
        }
    }
}
