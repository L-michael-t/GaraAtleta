/**
 * Giudice.java
 * questa classe gestisce l'arrivo degli atleti e la classifica finale
 * @author Michael Tifi
 */

public class Giudice implements Runnable {
String classifica="";
int posizione = 0;
final double LUNGHEZZAGARA = (double) 100.0F;



    public synchronized void traguardo(Atleta atleta) {
        System.out.println("è arrivato: " + atleta.nome);
        posizione ++;
        classifica += posizione + " " + atleta.nome + " " ;

    }
    

    public void podio(){
        System.out.println("il podio è " + classifica);
    }

    public String getClassifica() {
        return classifica;
    }

    @Override
    public void run() {

    }
}
