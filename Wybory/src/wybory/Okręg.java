package wybory;

import java.util.ArrayList;

public class Okręg {
    private int numer;
    private Okręg połączonyZ;
    private int liczbaWyborców;
    private int liczbaMandatów;
    private ArrayList<Kandydat> listaKandydatów = new ArrayList<>();
    private ArrayList<Partia> listaPartiiKandydatów = new ArrayList<>();

    public Okręg(int numer) {
        this.numer = numer;
    }

    public void setPołączonyZ(Okręg połączonyZ) {
        this.połączonyZ = połączonyZ;
    }

    public Okręg getPołączonyZ() {
        return połączonyZ;
    }

    public void setLiczbaWyborców(int liczbaWyborców) {
        this.liczbaWyborców = liczbaWyborców;
        this.liczbaMandatów = liczbaWyborców / 10;
    }

    public int getLiczbaWyborców() {
        return liczbaWyborców;
    }

    public int getNumer() {
        return numer;
    }

    public int getLiczbaMandatów() {
        return liczbaMandatów;
    }

    public void setKandydat(Kandydat kandydat) {
        this.listaKandydatów.add(kandydat);
    }

    public ArrayList<Kandydat> getListaKandydatów() {
        return listaKandydatów;
    }

    public void setLiczbaMandatów(int liczbaMandatów) {
        this.liczbaMandatów = liczbaMandatów;
    }

    public void setPartia(Partia partia) {
        this.listaPartiiKandydatów.add(partia);
    }

    public ArrayList<Partia> getListaPartiiKandydatów() {
        return listaPartiiKandydatów;
    }

}
