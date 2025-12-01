/**
 * GaraAtletica.java
 * questa classe contiene il metodo main per avviare la gara atletica
 * @author Michael Tifi (l'ho scritto in automatica dall'IDE)
 */

public class GaraAtletica {
    public static void main(String[] args) {
        System.out.println("Gara Atletica");
        Giudice giudice= new Giudice();
        GestoreFile gestore = new GestoreFile("podii.txt");

    // crezione atleti
        Atleta a1 = new Atleta(67, "pongre",giudice);
        Atleta a2 = new Atleta(68, "tifux",giudice);
        Atleta a3 = new Atleta(69, "pinguino",giudice);

        Thread ta1 = new Thread(a1);
        Thread ta2 = new Thread(a2);
        Thread ta3 = new Thread(a3);

        // conto alla rovescia 
        for(int i = 3; i > 0; --i) {
            System.out.println("Inizio in:" + i);
        }

        ta1.start();
        ta2.start();
        ta3.start();

        try {
            ta1.join();
            ta2.join();
            ta3.join();
        } catch (InterruptedException var6) {
            System.err.println("Errore join");
        }

        giudice.podio();
        gestore.salvaPodio(giudice);
        gestore.leggiPodii();
    }
}