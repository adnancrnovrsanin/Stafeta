package Stafeta;

public class Trkac implements Runnable {
    private int id;
    private String ime;
    private Double brzina; // brzina je u metrima/sekundi
    private Trka trka;
    private TrkackiTim tim;
    private Stafeta stafeta;
    private Boolean prvi;

    public Trkac(int id, String ime, Trka trka, TrkackiTim tim, Stafeta stafeta, Boolean prvi) {
        this.id = id;
        this.ime = ime;
        this.brzina = (Double) (6 + (Math.random() * 2.5));
        this.trka = trka;
        this.tim = tim;
        this.stafeta = stafeta;
        this.prvi = prvi;
    }

    public void cekaj() {
        try {
            Thread.sleep((int) (Math.random() * 1000));
        } catch(InterruptedException ex) { ex.printStackTrace(); }
    }

    public void trci() {
        try {
            Thread.sleep((int) (((trka.getDuzinaStaze()/tim.getBrojUcesnikaUTimu()) / this.brzina) * 1000));
        } catch(InterruptedException ex) { ex.printStackTrace(); }
    }

    @Override
    public void run() {
        if (!prvi) cekaj();
        tim.uzmiStafetu(id, stafeta);
        trci();
        tim.addCountProsliTrkaci();
        tim.dodajStafetu(id, stafeta);
    }

    public int getId() {
        return id;
    }

    public String getIme() {
        return ime;
    }

    public Double getBrzina() {
        return brzina;
    }
}
