package wybory;

import java.util.ArrayList;

public class ŻelaznyElektoratKandydata extends Wyborca {
    //2
    private final String nazwaPartii;
    private int pozycjaKandydata;

    public ŻelaznyElektoratKandydata(String imie, String nazwisko, int nrOkręgu, int typWyborcy, String nazwaPartii, int pozycjaKandydata) {
        super(imie, nazwisko, nrOkręgu, typWyborcy);
        this.nazwaPartii = nazwaPartii;
        this.pozycjaKandydata = pozycjaKandydata;
    }


    @Override
    public Kandydat głosuj(Okręg okręg) {
        for (int i = 0; i < okręg.getListaKandydatów().size(); i++) {
            if (okręg.getListaKandydatów().get(i).getNazwaPartii().equals(this.nazwaPartii)
                    && okręg.getListaKandydatów().get(i).getPozycjaNaLiście() == this.pozycjaKandydata) {
                Kandydat kandydat = okręg.getListaKandydatów().get(i);
                kandydat.dodajGłos();
                dajGłosPartii(okręg, kandydat);
                return kandydat;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Integer> getWagi() {
        return null;
    }

    public void setPozycjaKandydata(int pozycjaKandydata) {
        this.pozycjaKandydata = pozycjaKandydata;
    }

    public String getNazwaPartii() {
        return nazwaPartii;
    }
}
