package wybory;

import java.util.ArrayList;
import java.util.Random;

public abstract class MJednocechowy extends Wyborca {
    private final int cecha;

    public MJednocechowy(String imie, String nazwisko, int nrOkręgu, int typWyborcy, int cecha) {
        super(imie, nazwisko, nrOkręgu, typWyborcy);
        this.cecha = cecha - 1;
    }

    protected Kandydat głosujMJednocechowy(Okręg okręg, int ekstremum, int mnożnik, boolean jednoPartyjny, String nazwaPartii) {
        ArrayList<Kandydat> ekstrema = new ArrayList<>();
        for (int i = 0; i < okręg.getListaKandydatów().size(); i++) {
            Kandydat kandydat = okręg.getListaKandydatów().get(i);
            if (jednoPartyjny) {
                if (kandydat.getNazwaPartii().equals(nazwaPartii)) {
                    int cechaKandydata = kandydat.getCechy().get(cecha);
                    if (cechaKandydata <= mnożnik * ekstremum)
                        ekstremum = cechaKandydata;
                }
            } else {
                int cechaKandydata = kandydat.getCechy().get(cecha);
                if (cechaKandydata <= mnożnik * ekstremum) //mnożnik to -1 jak szukamy maksimum
                    ekstremum = cechaKandydata;
            }
        }
        for (int i = 0; i < okręg.getListaKandydatów().size(); i++) {
            Kandydat kandydat = okręg.getListaKandydatów().get(i);
            if (jednoPartyjny) {
                if (kandydat.getNazwaPartii().equals(nazwaPartii) && kandydat.getCechy().get(cecha) == ekstremum)
                    ekstrema.add(kandydat);
            } else {
                if (kandydat.getCechy().get(cecha) == ekstremum)
                    ekstrema.add(kandydat);
            }
        }

        Random r = new Random();
        int x = r.nextInt(ekstrema.size());
        Kandydat kandydat = ekstrema.get(x);
        kandydat.dodajGłos();
        dajGłosPartii(okręg, kandydat);
        return kandydat;
    }

}
