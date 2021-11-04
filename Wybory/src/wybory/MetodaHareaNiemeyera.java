package wybory;

import java.util.ArrayList;
import java.util.Collections;

public class MetodaHareaNiemeyera extends MetodyZamiany {
    public MetodaHareaNiemeyera(Okręg okręg) {
        super(okręg);
    }

    @Override
    public void przeliczGłosy(ListaPartii listaPartii) {
        int lMandatów = liczbaMandatów;
        ArrayList<Double> współczynniki = new ArrayList<>();
        int[] wynik = new int[listaPartii.getRozmiarListy()]; // to będzie lista długości listyPartii i pod odpowiednimi indeksami będą odpowiednie ilosci przydzielonych mandatóœ
        for (int i = 0; i < listaPartii.getRozmiarListy(); i++) {
            współczynniki.add((double) (listaPartii.getPartia(i).getLiczbaGłosów() * liczbaMandatów) / (double) liczbaWszytskichGłosów(listaPartii));
        }
        int indeks = 0;
        for (int i = 0; i < współczynniki.size(); i++) {
            wynik[i] = (int) Math.floor(współczynniki.get(i));
            lMandatów -= wynik[i];
            double pom = współczynniki.get(i) - wynik[i];
            współczynniki.set(i, pom);
        }
        while (lMandatów > 0) {
            double max = Collections.max(współczynniki);
            for (int i = 0; i < współczynniki.size(); i++) {
                if (współczynniki.get(i) == max) {
                    współczynniki.set(i, 0.0);
                    wynik[i] += 1;
                    lMandatów--;
                }
            }
        }
        this.wypisz(listaPartii, wynik, 2);
    }

    private int liczbaWszytskichGłosów(ListaPartii listaPartii) {
        int suma = 0;
        for (int i = 0; i < listaPartii.getRozmiarListy(); i++) {
            suma += listaPartii.getPartia(i).getLiczbaGłosów();
        }
        return suma;
    }
}
