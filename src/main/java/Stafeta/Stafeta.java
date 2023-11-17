package Stafeta;

public class Stafeta {
    private boolean free;
    public boolean isFree() {
        return free;
    }
    public void setFree(boolean free) {
        this.free = free;
    }
    public Stafeta() {
        setFree(true);
    }
}
