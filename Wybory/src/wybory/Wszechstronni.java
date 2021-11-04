package wybory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public abstract class Wszechstronni extends Wyborca {
    private ArrayList<Integer> wagi;

    public Wszechstronni(String imie, String nazwisko, int nrOkręgu, int typWyborcy, ArrayList<Integer> wagi) {
        super(imie, nazwisko, nrOkręgu, typWyborcy);
        this.wagi = wagi;
    }

    protected Kandydat głosujWszechstronnie(Okręg okręg, boolean jednopartyjny, String nazwaPartii) {
        ArrayList<Integer> sumyeWażone = new ArrayList<>();
        for (int i = 0; i < okręg.getListaKandydatów().size(); i++) {
            int suma = 0;
            for (int j = 0; j < okręg.getListaKandydatów().get(i).getCechy().size(); j++) {
                if (jednopartyjny) {
                    if (okręg.getListaKandydatów().get(i).getNazwaPartii().equals(nazwaPartii))
                        suma += okręg.getListaKandydatów().get(i).getCechy().get(j) * wagi.get(j);
                } else {
                    suma += okręg.getListaKandydatów().get(i).getCechy().get(j) * wagi.get(j);
                }
            }
            sumyeWażone.add(suma);
        }
        int max = Collections.max(sumyeWażone);
        ArrayList<Kandydat> maksymalneWażone = new ArrayList<>();
        for (int i = 0; i < sumyeWażone.size(); i++) {
            if (jednopartyjny) {
                if (sumyeWażone.get(i) == max && okręg.getListaKandydatów().get(i).getNazwaPartii().equals(nazwaPartii))
                    maksymalneWażone.add(okręg.getListaKandydatów().get(i));
            } else {
                if (sumyeWażone.get(i) == max)
                    maksymalneWażone.add(okręg.getListaKandydatów().get(i));
            }
        }
        Random r = new Random();
        int x = r.nextInt(maksymalneWażone.size());
        Kandydat kandydat = maksymalneWażone.get(x);
        kandydat.dodajGłos();
        dajGłosPartii(okręg, kandydat);
        return kandydat;
    }

    protected ArrayList<Integer> getWagiW() {
        return wagi;
    }
}
