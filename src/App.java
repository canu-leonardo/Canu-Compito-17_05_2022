public class App {
    public static void main(String[] args) throws Exception {
        
        Semaforo sSpogliatoi = new Semaforo(2);
        Semaforo sPista = new Semaforo(4);
        
        Spogliatotio spogliatotio = new Spogliatotio();

        Pilota p1 = new Pilota("Marco    ",spogliatotio, sSpogliatoi, sPista);
        Pilota p2 = new Pilota("Antonio  ",spogliatotio, sSpogliatoi, sPista);
        Pilota p3 = new Pilota("Samuele  ",spogliatotio, sSpogliatoi, sPista);
        Pilota p4 = new Pilota("Gianni   ",spogliatotio, sSpogliatoi, sPista);
        Pilota p5 = new Pilota("Franco   ",spogliatotio, sSpogliatoi, sPista);
        Pilota p6 = new Pilota("Stefano  ",spogliatotio, sSpogliatoi, sPista);
        Pilota p7 = new Pilota("Leonardo ",spogliatotio, sSpogliatoi, sPista);
        Pilota p8 = new Pilota("Lorenzo  ",spogliatotio, sSpogliatoi, sPista);

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
        p7.start();
        p8.start();

        p1.join();
        p2.join();
        p3.join();
        p4.join();
        p5.join();
        p6.join();
        p7.join();
        p8.join();

        System.out.println("===========CLASSIFICA:===========");
        System.out.println(Pilota.Stampa());

    }
}
