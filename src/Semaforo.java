public class Semaforo {
    
    private int Valore;

    public Semaforo ( int V){
        this.Valore = V;
    }

    public synchronized void Occupa(){
        while (Valore == 0){
            try {    wait();    } catch (Exception e) {}
        }
        Valore --;
    }

    public synchronized void Libera(){
        Valore ++;
        notify();
    }
}
