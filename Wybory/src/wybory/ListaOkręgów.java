package wybory;

import java.util.ArrayList;

public class ListaOkręgów {
    private ArrayList<Okręg> listaOkręgów = new ArrayList<>();

    public void setListaOkręgów(int n) {
        for (int i = 0; i <= n; i++) {
            //tworzymy jeden za dużo, żeby omijać zerowy i mieć dobre indeksy
            Okręg okręg = new Okręg(i);
            listaOkręgów.add(okręg);
        }
    }

    public int getRozmiarListy() {
        return listaOkręgów.size();
    }

    public Okręg getOkręg(int i) {
        return listaOkręgów.get(i);
    }

    public void Scal(ListaWyborców listaWyborców, ListaKandydatów listaKandydatów) {
        for (int i = 1; i < listaOkręgów.size(); i++) {
            if (listaOkręgów.get(i) != null) {
                Okręg okręg = listaOkręgów.get(i);
                int początkowyRozmiar = okręg.getListaKandydatów().size();
                Okręg połączenie = okręg.getPołączonyZ();
                if (połączenie != null) {
                    for (int j = 0; j < połączenie.getListaKandydatów().size(); j++) {
                        Kandydat kandydat = połączenie.getListaKandydatów().get(j);
                        kandydat.setPozycjaNaLiście(kandydat.getPozycjaNaLiście() + początkowyRozmiar);
                        okręg.getListaKandydatów().add(kandydat);
                        scalWWyborcach(listaWyborców, okręg.getNumer(), połączenie.getNumer(), kandydat.getPozycjaNaLiście(), kandydat.getNazwaPartii());
                    }
                    for (int j = 0; j < połączenie.getListaPartiiKandydatów().size(); j++) {
                        Partia partia = połączenie.getListaPartiiKandydatów().get(j);
                        okręg.setPartia(partia);
                    }
                    int liczbaWyborcówDodaj = połączenie.getLiczbaWyborców() + okręg.getLiczbaWyborców();
                    okręg.setLiczbaWyborców(liczbaWyborcówDodaj);
                    int liczbaMandatówDodaj = połączenie.getLiczbaMandatów() + okręg.getLiczbaMandatów();
                    okręg.setLiczbaMandatów(liczbaMandatówDodaj);
                    scalWKandydatach(listaKandydatów, okręg.getNumer(), połączenie.getNumer());
                    for (int j = 0; j < listaOkręgów.size(); j++) {
                        if (listaOkręgów.get(j) == połączenie)
                            listaOkręgów.set(j, null);
                    }
                }
            }
        }
    }

    private void scalWWyborcach(ListaWyborców listaWyborców, int nrOkręgu, int nrDoScalenia, int pozycja, String nazwaPartii) {
        for (int i = 0; i < listaWyborców.getRozmmiarListy(); i++) {
            if (listaWyborców.getWyborca(i).getNrOkręgu() == nrDoScalenia || listaWyborców.getWyborca(i).getNrOkręgu() == nrOkręgu) {
                if (listaWyborców.getWyborca(i).getTyp() == 2) {
                    ŻelaznyElektoratKandydata żelaznyElektoratKandydata = ((ŻelaznyElektoratKandydata) listaWyborców.getWyborca(i));
                    if (żelaznyElektoratKandydata.getNazwaPartii().equals(nazwaPartii))
                        żelaznyElektoratKandydata.setPozycjaKandydata(pozycja);
                }
                listaWyborców.getWyborca(i).setNrOkręgu(nrOkręgu);
            }
        }
    }

    private void scalWKandydatach(ListaKandydatów listaKandydatów, int nrOkręgu, int nrDoScalenia) {
        for (int i = 0; i < listaKandydatów.getRozmiarListy(); i++) {
            if (listaKandydatów.getKandydat(i).getNrOkręgu() == nrDoScalenia)
                listaKandydatów.getKandydat(i).setNrOkręgu(nrOkręgu);
        }
    }

    private int znajdźpozycjęnaliście(ArrayList<Kandydat> listaKandydatów, String nazwaPartii) {
        for (int i = listaKandydatów.size() - 1; i >= 0; i--) {
            if (listaKandydatów.get(i).getNazwaPartii().equals(nazwaPartii))
                return listaKandydatów.get(i).getPozycjaNaLiście() + 1;
        }
        return 0;
    }
}
