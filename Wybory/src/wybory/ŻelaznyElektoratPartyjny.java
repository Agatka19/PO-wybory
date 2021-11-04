package wybory;

import java.util.ArrayList;
import java.util.Random;

public class ŻelaznyElektoratPartyjny extends Wyborca {
    //1
    private String nazwaPartii;

    public ŻelaznyElektoratPartyjny(String imie, String nazwisko, int nrOkręgu, int typWyborcy, String nazwaPartii) {
        super(imie, nazwisko, nrOkręgu, typWyborcy);
        this.nazwaPartii = nazwaPartii;
    }


    @Override
    public Kandydat głosuj(Okręg okręg) {
        ArrayList<Kandydat> dobraPartia = new ArrayList<>();
        for (int i = 0; i < okręg.getListaKandydatów().size(); i++) {
            if (okręg.getListaKandydatów().get(i).getNazwaPartii().equals(this.nazwaPartii))
                dobraPartia.add(okręg.getListaKandydatów().get(i));
        }
        Random r = new Random();
        int indeks = r.nextInt(dobraPartia.size());
        Kandydat kandydat = dobraPartia.get(indeks);
        kandydat.dodajGłos();
        dajGłosPartii(okręg, kandydat);
        return kandydat;
    }

    @Override
    public ArrayList<Integer> getWagi() {
        return null;
    }
}
