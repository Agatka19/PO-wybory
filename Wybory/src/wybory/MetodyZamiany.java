package wybory;

public abstract class MetodyZamiany {
    protected int liczbaMandatów;
    protected int nrOkregu;

    public MetodyZamiany(Okręg okręg) {
        this.liczbaMandatów = okręg.getLiczbaMandatów();
        this.nrOkregu = okręg.getNumer();
    }

    public abstract void przeliczGłosy(ListaPartii listaPartii);

    public static void wypiszMandatySuma(ListaPartii listaPartii, int indeks) {
        for (int i = 0; i < listaPartii.getRozmiarListy(); i++) {
            Partia partia = listaPartii.getPartia(i);
            System.out.println(partia.getNazwa() + " - liczba mandatów: " + partia.getLiczbaMandatów()[indeks]);
        }
    }

    public void wypisz(ListaPartii listaPartii, int[] wynik, int indeks) { //indeks 0 to d'Hondt, 1 to Sainte.., 2 to Niemeyer
        for (int i = 0; i < listaPartii.getRozmiarListy(); i++) {
            listaPartii.getPartia(i).dodajMandaty(indeks, wynik[i]);
            System.out.println(listaPartii.getPartia(i).getNazwa() + " - liczba mandatów: " + wynik[i]);
        }
    }

}