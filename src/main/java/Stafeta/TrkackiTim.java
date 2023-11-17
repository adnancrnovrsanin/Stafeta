package Stafeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TrkackiTim {

    private Lock lock = new ReentrantLock();
    private Condition[] cond;
    private String[] stanje;
    private int id;
    private int brojUcesnikaUTimu;
    private List<Trkac> trkaci;
    private Stafeta stafeta;
    private int countProsliTrkaci;
    private Trka trka;

    public TrkackiTim(int id, int brojUcesnikaUTimu, Stafeta stafeta, Trka trka) {
        this.id = id;
        this.brojUcesnikaUTimu = brojUcesnikaUTimu;
        this.trkaci = new ArrayList<Trkac>();
        this.stafeta = stafeta;
        this.cond = new Condition[brojUcesnikaUTimu];
        this.stanje = new String[brojUcesnikaUTimu];
        this.countProsliTrkaci = 0;
        this.trka = trka;

        for (int i = 0; i < brojUcesnikaUTimu; i++) {
            cond[i] = lock.newCondition();
            stanje[i] = "C";
        }
    }

    public void addTrkac(Trkac trkac) {
        if (this.trkaci.stream().count() >= brojUcesnikaUTimu) {
            System.out.println("Neuspelo ubacivanje trkaca " + trkac.getId() + " pod imenom " + trkac.getIme() + " zato sto nema mesta u timu.");
        }
        trkaci.add(trkac);
    }

    public void uzmiStafetu(int trkacId, Stafeta stafeta) {
        lock.lock();
        while(!stafeta.isFree()) {
            try {
                cond[(int) (trkacId % Arrays.stream(stanje).count())].await();
            } catch(InterruptedException ex) { ex.printStackTrace(); }
        }

        stanje[(int) (trkacId % Arrays.stream(stanje).count())] = "T";
        stafeta.setFree(false);
        lock.unlock();
    }

    public void dodajStafetu(int trkacId, Stafeta stafeta) {
        lock.lock();
        stanje[(int) (trkacId % Arrays.stream(stanje).count())] = "C";
        stafeta.setFree(true);
        cond[((int) (trkacId % Arrays.stream(stanje).count()) + 1) % this.brojUcesnikaUTimu].signalAll();
        lock.unlock();
    }

    public void addCountProsliTrkaci() {
        if (countProsliTrkaci < 2) {
            countProsliTrkaci++;
            return;
        }

        if (countProsliTrkaci == 2)
            trka.addToRangList(this);
    }

    public int getId() {
        return id;
    }

    public int getBrojUcesnikaUTimu() {
        return brojUcesnikaUTimu;
    }

    public List<Trkac> getTrkaci() {
        return trkaci;
    }
}
