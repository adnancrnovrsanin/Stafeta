package Stafeta;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Trka {
    private Double duzinaStaze;
    private int brojTimova;
    private List<TrkackiTim> ucesnici;
    private TrkackiTim[] rangLista;
    private int rangListaCount;
    private Lock lock = new ReentrantLock();

    public Trka(Double duzinaStaze, int brojTimova) {
        this.duzinaStaze = duzinaStaze;
        this.ucesnici = new ArrayList<TrkackiTim>();
        this.rangLista = new TrkackiTim[brojTimova]; rangListaCount = 0;
        this.brojTimova = brojTimova;
    }

    public void addUcesnik(TrkackiTim tim) {
        if (ucesnici.stream().count() == this.brojTimova) {
            System.out.println("Prijavljivanje ekipe ");
        }
    }

    public void addToRangList(TrkackiTim tim) {
        rangLista[rangListaCount] = tim;
        rangListaCount++;
    }

    public List<TrkackiTim> getUcesnici() {
        return this.ucesnici;
    }

    public TrkackiTim[] getRangLista() {
        return this.rangLista;
    }

    public Double getDuzinaStaze() {
        return duzinaStaze;
    }

    public void setDuzinaStaze(Double duzinaStaze) {
        this.duzinaStaze = duzinaStaze;
    }
}
