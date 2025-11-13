import java.util.Random;


public class Atleta implements Runnable {
    int numero;
    String nome;
    Giudice giudice;
    double tempo = (double) 0.0F;
    double metri = (double) 0.0F;
    final double LUNGHEZZAGARA = (double) 100.0F;


    public Atleta(int pNumero, String pNome, Giudice pgiudice) {
        this.numero = pNumero;
        this.giudice = pgiudice;
        this.nome = pNome;
    }


    public void run() {
        Random metriPercorsi = new Random();
        double minIncrement = 2.0; // minimo incremento per ciclo (metri)
        double maxIncrement = 6.0; // massimo incremento per ciclo (metri)


        while (this.metri <= (double) LUNGHEZZAGARA) {
            this.metri += minIncrement + (maxIncrement - minIncrement) * metriPercorsi.nextDouble();
            System.out.println(this.nome + " Metri Percorsi: " + this.metri);


            try {
                Thread.currentThread();
                Thread.sleep(1000L);
            } catch (InterruptedException var3) {
                System.err.println("Errore sleep");
            }
        }


        System.out.println(this.nome + " è al Traguardo");
        giudice.traguardo(this);
    }
}