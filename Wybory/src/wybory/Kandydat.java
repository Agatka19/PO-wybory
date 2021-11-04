package wybory;

import java.util.ArrayList;

public class Kandydat extends Człowiek {
    private final String nazwaPartii;
    private int nrOkręgu;
    private final ArrayList<Integer> cechy;
    private int pozycjaNaLiście;
    private int liczbaGłosów = 0;

    public Kandydat(String imie, String nazwisko, int nrOkręgu, String nazwaPartii, int pozycjaNaLiście, ArrayList<Integer> cechy) {
        super(imie, nazwisko);
        this.nrOkręgu = nrOkręgu;
        this.nazwaPartii = nazwaPartii;
        this.pozycjaNaLiście = pozycjaNaLiście;
        this.cechy = cechy;
    }

    public void dodajGłos() {
        this.liczbaGłosów++;
    }

    public int getLiczbaGłosów() {
        return liczbaGłosów;
    }

    public int getNrOkręgu() {
        return nrOkręgu;
    }

    public String getNazwaPartii() {
        return nazwaPartii;
    }

    public ArrayList<Integer> getCechy() {
        return cechy;
    }

    public void setNrOkręgu(int nrOkręgu) {
        this.nrOkręgu = nrOkręgu;
    }

    public void setPozycjaNaLiście(int pozycjaNaLiście) {
        this.pozycjaNaLiście = pozycjaNaLiście;
    }

    public int getPozycjaNaLiście() {
        return pozycjaNaLiście;
    }
}
