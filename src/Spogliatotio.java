
/**
 * Questa classe rappresenta lo spogliatoio:
 * ha due metodi per permette di prepararsi e di far cambiare i piloti
 * 
 * @author Canu Leonardo
 * @version 1.0
 * @since 17-05-2022 
 */
public class Spogliatotio {

    /**
     * Il metodo permette ad un pilota di prepararsi, aspettando un tempo random
     * @param x è il nome del pilota
     */
    public void Preparati(String x){
        //System.out.println( x + " inizia a prepararsi");
        try {   Thread.sleep(1000);    } catch (InterruptedException e) {}
        System.out.println( x + " si è preparato");
    }
    /**
     * Il metodo permette ad un pilota di cambiarsi, aspettando un tempo random
     * @param x è il nme del pilota
     */
    public void Cambiati(String x){
        //System.out.println( x + " inizia a cambiarsi");
        try {   Thread.sleep(1000);    } catch (InterruptedException e) {}
        System.out.println( x + " si è cambiato");
    }
}
