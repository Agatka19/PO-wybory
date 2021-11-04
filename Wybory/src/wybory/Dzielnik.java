package wybory;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Dzielnik extends MetodyZamiany {

    public Dzielnik(Okręg okręg) {
        super(okręg);
    }

    protected void przeliczGłosyZDzielnikiem(ListaPartii listaPartii, int mnożnik, int index) {
        int lMandatów = liczbaMandatów;
        ArrayList<Double> głosy = new ArrayList<>();
        int[] wynik = new int[listaPartii.getRozmiarListy()]; // to będzie lista długości listyPartii i pod odpowiednimi indeksami będą odpowiednie ilosci przydzielonych mandatów
        for (int i = 0; i < listaPartii.getRozmiarListy(); i++) {
            głosy.add((double) listaPartii.getPartia(i).getGłosyWOkręgach()[this.nrOkregu]);
        }
        while (lMandatów > 0) {
            int indeks = 0;
            double max = Collections.max(głosy);
            for (int i = 0; i < głosy.size(); i++) {
                double pom = listaPartii.getPartia(i).getGłosyWOkręgach()[this.nrOkregu];
                if (głosy.get(i) == max) {
                    głosy.set(i, pom / ((double)(mnożnik * wynik[i]) + 1.0));
                    wynik[i] += 1;
                    lMandatów--;
                }
            }
        }
        this.wypisz(listaPartii, wynik, index);
    }


}