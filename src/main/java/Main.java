import Stafeta.Stafeta;
import Stafeta.Trka;
import Stafeta.Trkac;
import Stafeta.TrkackiTim;

public class Main {
    static final int BROJ_CLANOVA_TIMA = 3;
    static final int BROJ_TIMOVA = 4;
    static final Double DUZINA_STAZE = 30.00; // u metrima


    public static void main(String[] args) {

        // Inicijalizujemo trku
        Trka trka = new Trka(DUZINA_STAZE, BROJ_TIMOVA);

        // Inicijalizacija stafeta
        Stafeta s1 = new Stafeta();
        Stafeta s2 = new Stafeta();
        Stafeta s3 = new Stafeta();
        Stafeta s4 = new Stafeta();

        // Deklarisemo timove
        TrkackiTim tim1 = new TrkackiTim(1, BROJ_CLANOVA_TIMA, s1, trka);
        TrkackiTim tim2 = new TrkackiTim(2, BROJ_CLANOVA_TIMA, s2, trka);
        TrkackiTim tim3 = new TrkackiTim(3, BROJ_CLANOVA_TIMA, s3, trka);
        TrkackiTim tim4 = new TrkackiTim(4, BROJ_CLANOVA_TIMA, s4, trka);

        // Inicijalizujemo trkace
        Trkac t1 = new Trkac(1, "Adnan Crnovrsanin", trka, tim1, s1, true);
        Trkac t2 = new Trkac(2, "Mirnesa Calakovic", trka, tim1, s1, false);
        Trkac t3 = new Trkac(3, "Tarik Ibrahimovic", trka, tim1, s1, false);
        Trkac t4 = new Trkac(4, "Amela Terzic", trka, tim2, s2, true);
        Trkac t5 = new Trkac(5, "Admir Kecap", trka, tim2, s2, false);
        Trkac t6 = new Trkac(6, "Ensar Hamzic", trka, tim2, s2, false);
        Trkac t7 = new Trkac(7, "Fredrik Japan", trka, tim3, s3, true);
        Trkac t8 = new Trkac(8, "John Bush", trka, tim3, s3, false);
        Trkac t9 = new Trkac(9, "Mirza Halimovic", trka, tim3, s3, false);
        Trkac t10 = new Trkac(10, "Predrag Milenkovic", trka, tim4, s4, true);
        Trkac t11 = new Trkac(11, "Filip Mutavdzic", trka, tim4, s4, false);
        Trkac t12 = new Trkac(12, "Lazar Pavlovic", trka, tim4, s4, false);

        trka.addUcesnik(tim1);
        trka.addUcesnik(tim2);
        trka.addUcesnik(tim3);

        tim1.addTrkac(t1);
        tim1.addTrkac(t2);
        tim1.addTrkac(t3);

        tim2.addTrkac(t4);
        tim2.addTrkac(t5);
        tim2.addTrkac(t6);

        tim3.addTrkac(t7);
        tim3.addTrkac(t8);
        tim3.addTrkac(t9);

        tim4.addTrkac(t10);
        tim4.addTrkac(t11);
        tim4.addTrkac(t12);

        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        Thread thread3 = new Thread(t3);
        Thread thread4 = new Thread(t4);
        Thread thread5 = new Thread(t5);
        Thread thread6 = new Thread(t6);
        Thread thread7 = new Thread(t7);
        Thread thread8 = new Thread(t8);
        Thread thread9 = new Thread(t9);
        Thread thread10 = new Thread(t10);
        Thread thread11 = new Thread(t11);
        Thread thread12 = new Thread(t12);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();
        thread11.start();
        thread12.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            thread6.join();
            thread7.join();
            thread8.join();
            thread9.join();
            thread10.join();
            thread11.join();
            thread12.join();

            System.out.println("Trka je zavrsena");
            System.out.println("Pobedio je tim pod rednim brojem " + trka.getRangLista()[0].getId());
            System.out.println("Drugo mesto je osvojio tim pod rednim brojem " + trka.getRangLista()[1].getId());
            System.out.println("Trece mesto je osvojio tim pod rednim brojem " + trka.getRangLista()[2].getId());
            System.out.println("Cetvrto mesto je osvojio tim pod rednim brojem " + trka.getRangLista()[3].getId());
        } catch(InterruptedException ex) { ex.printStackTrace(); }
    }
}
