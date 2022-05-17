/**
 * Il semaforo permette di gestire l'entrata ed uscita ordinata ad una risorsa
 * @author Canu Leonardo
 * @version 1.0
 * @since 17-05-2022 
 */
public class Semaforo {
    
    private int Valore;
    /**
     * Inserisce un valore iniziale
     * @param V numero di postio liberi
     */
    public Semaforo ( int V){
        this.Valore = V;
    }

    /**
     * Permette di occupare una risorsa:
     * se non ci sono posti liberi, entra nella coda di attesa;
     * invece se ce ne sono, ne occupa 1. 
     */
    public synchronized void Occupa(){
        while (Valore == 0){
            try {    wait();    } catch (Exception e) {}
        }
        Valore --;
    }
    /**
     * Permette di Liberare una risorsa:
     * libera un Thread dalla lista di attesae libera un posto
     */
    public synchronized void Libera(){
        Valore ++;
        notify();
    }
}
