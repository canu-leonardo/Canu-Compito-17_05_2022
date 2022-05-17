import java.util.ArrayList;
/**
 * La classe Pilota è semplicemente un thread, con un ArrayList di piloti 
 * che li ordina e tien conto della classifica man mano che finiscono
 * 
 * @author Canu Leonardo
 * @version 1.0
 * @since 17-09-2022
 */
public class Pilota extends Thread{
    
    private String nome;
    private Semaforo semSpogliatotio;
    private Semaforo semPista;
    private Spogliatotio spogliatotio;
    private long tempo;

    private static ArrayList<Pilota> classifica = new ArrayList<>();

    /**     * 
     * @param n è il nome del pilota
     * @param s è lo spogiatoio
     * @param f è il semaforo dello spogliatotio
     * @param sp è il semaforo della pista
     */
    public Pilota(String n, Spogliatotio s, Semaforo f, Semaforo sp){
        this.nome = n;
        this.semSpogliatotio = f;
        this.spogliatotio = s;
        this.semPista = sp;
    }

    /**
     * Questo metodo  il quello che fa iniziare il thread, compie diverse operazioni:
     * - Con un semaforo a due "posti", fa entrare ed uscire i piloti dallo spogliatotio
     * - Con un semaforo a quattro posti, fa entrare ed uscire i piloti dalla pista
     * - Calcola il loro tempo
     * - Li inserisce nella classifica 
     * @return nothing
     */
    public void run(){
        //=====Il pilota si prepara=====
        semSpogliatotio.Occupa();
        spogliatotio.Preparati(this.nome);
        semSpogliatotio.Libera();
        //=====Il pilota entra in pista=====
        semPista.Occupa();

        System.out.println(this.nome + " entra in pista");

        long inizio = System.nanoTime();
        for (int i = 0; i < 15; i++){
            try {    Thread.sleep((long)(Math.random() * 1000));    } catch (InterruptedException e) {}
        }        
        long fine = System.nanoTime();

        System.out.println(this.nome + " esce dalla pista");

        semPista.Libera();
        //=====Il pilota si cambia=====
        semSpogliatotio.Occupa();
        spogliatotio.Cambiati(this.nome);
        semSpogliatotio.Libera();

        //System.out.println(this.nome + " finisce");

        tempo = (fine-inizio) / 1000000;

        for (int i = 0; i<classifica.size(); i++){
            if (classifica.get(i).tempo < this.tempo){
                classifica.add(i, this);
                return;
            }
        }       
        classifica.add(0, this);

    }
    /**
     * Questo metodo ritorna il nome e il tempo di un pilota
     * @return String. 
     */
    public String toString(){
        return this.nome + ": " + this.tempo + " s.";
    }

    /**
     * Metodo statico che ritorna tutta la classifica in ordine crescente
     * @return
     */
    public static String Stampa(){
        String s = "";
        
        for (int i = classifica.size()-1; i >= 0 ; i-- ){
            System.out.println(classifica.get(i).toString());
        }
        return s;
    }
}
