public class Spogliatotio {
    public void Preparati(String x){
        //System.out.println( x + " inizia a prepararsi");
        try {   Thread.sleep(1000);    } catch (InterruptedException e) {}
        System.out.println( x + " si è preparato");
    }

    public void Cambiati(String x){
        //System.out.println( x + " inizia a cambiarsi");
        try {   Thread.sleep(1000);    } catch (InterruptedException e) {}
        System.out.println( x + " si è cambiato");
    }
}
