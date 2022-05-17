import java.util.ArrayList;

public class Pilota extends Thread{
    
    private String nome;
    private Semaforo semSpogliatotio;
    private Semaforo semPista;
    private Spogliatotio spogliatotio;
    private long tempo;

    private static ArrayList<Pilota> classifica = new ArrayList<>();

    public Pilota(String n, Spogliatotio s, Semaforo f, Semaforo sp){
        this.nome = n;
        this.semSpogliatotio = f;
        this.spogliatotio = s;
        this.semPista = sp;
    }

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

    public String toString(){
        return this.nome + ": " + this.tempo + " s.";
    }


    public static String Stampa(){
        String s = "";
        
        for (int i = classifica.size()-1; i >= 0 ; i-- ){
            System.out.println(classifica.get(i).toString());
        }
        return s;
    }
}
