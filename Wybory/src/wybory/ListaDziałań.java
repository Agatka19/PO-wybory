package wybory;

import java.util.ArrayList;
import java.util.Random;

public class ListaDziałań {
    private ArrayList<Działanie> listaDziałań = new ArrayList<>();

    public void setListaDziałań(ArrayList<Działanie> listaDziałań) {
        this.listaDziałań = listaDziałań;
    }

    public ArrayList<Działanie> getListaDziałań() {
        return listaDziałań;
    }

    public Działanie getNajtańsze(int liczbaWyborców) {
        int indeksNajtańszego = 0;
        int cena = Integer.MAX_VALUE;
        for (int i = 0; i < listaDziałań.size(); i++) {
            if (listaDziałań.get(i).getCena(liczbaWyborców) < cena) {
                cena = listaDziałań.get(i).getCena(liczbaWyborców);
                indeksNajtańszego = i;
            }
        }
        return listaDziałań.get(indeksNajtańszego);
    }

    public Działanie getNajdroższe(int liczbaWyborców, int budżet) {
        int indeksNajdroższego = 0;
        int cena = 0;
        for (int i = 0; i < listaDziałań.size(); i++) {
            if (listaDziałań.get(i).getCena(liczbaWyborców) > cena && listaDziałań.get(i).getCena(liczbaWyborców) <= budżet) {
                cena = listaDziałań.get(i).getCena(liczbaWyborców);
                indeksNajdroższego = i;
            }
        }
        return listaDziałań.get(indeksNajdroższego);
    }

    public Działanie getOptymalne(Okręg okręg, int budżet, String nazwaPartii) {
        ArrayList<Kandydat> kandydaci = new ArrayList<>();
        for (int i = 0; i < okręg.getListaKandydatów().size(); i++) {
            if (okręg.getListaKandydatów().get(i).getNazwaPartii().equals(nazwaPartii))
                kandydaci.add(okręg.getListaKandydatów().get(i));
        }
        int maxSuma = 0;
        int maxIndeks = 0;
        for (int i = 0; i < kandydaci.size(); i++) {
            for (int j = 0; j < listaDziałań.size(); j++) {
                int suma = 0;
                for (int k = 0; k < kandydaci.get(i).getCechy().size(); k++) {
                    suma += kandydaci.get(i).getCechy().get(k) * listaDziałań.get(j).getOpis().get(k);
                }
                if (suma > maxSuma && listaDziałań.get(maxIndeks).getCena(okręg.getLiczbaWyborców()) < budżet) {
                    maxSuma = suma;
                    maxIndeks = j;
                }
            }
        }
        return listaDziałań.get(maxIndeks);
    }


    public Działanie getMaxLosowe(int budżet, int liczbaWyborców) {
        //losujemy dwa działania z tych co nas na nie stać i bierzemy, to którego cena jest wyższa
        //(lub równa, jeżeli wylosujemy to samo działanie)
        ArrayList<Działanie> działaniaNaKtóreStać = new ArrayList<>();
        for (int i = 0; i < listaDziałań.size(); i++) {
            if (listaDziałań.get(i).getCena(liczbaWyborców) <= budżet) ;
            działaniaNaKtóreStać.add(listaDziałań.get(i));
        }
        Random r = new Random();
        int x = r.nextInt(działaniaNaKtóreStać.size());
        int y = r.nextInt(działaniaNaKtóreStać.size());
        if (działaniaNaKtóreStać.get(x).getCena(liczbaWyborców) >= działaniaNaKtóreStać.get(y).getCena(liczbaWyborców))
            return działaniaNaKtóreStać.get(x);
        else
            return działaniaNaKtóreStać.get(y);

    }
}
