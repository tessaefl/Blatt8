package h1;

public class Bruch {
    public int zaehler;
    public int nenner;

    public Bruch(int zaehler, int nenner) {
        this.zaehler = zaehler;
        this.nenner = nenner;
    }

    public String toString() {
        // Gibt den Bruch im Format "Zähler/Nenner" zurück
        return zaehler + "/" + nenner;
    }

    private int ggT(int x, int y) {
        while (y != 0) {
            int rest = y;
            y = x % y;
            x = rest;
        }
        return x;
    }

    public void shorten() {
        int ggT = ggT(this.zaehler, this.nenner);
        this.zaehler = this.zaehler / ggT;
        this.nenner = this.nenner / ggT;
    }

    public boolean hasSameValueAs(Bruch b) {
        long left = (long) this.zaehler * b.nenner;
        long right = (long) b.zaehler * this.nenner;
        if (left != right) {
            return false;
        }
        return true;
    }
}
