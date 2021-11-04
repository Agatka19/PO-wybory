package wybory;

public abstract class Partia {
    private int budżet;
    private final String nazwa;
    private int liczbaGłosów;
    private int[] głosyWOkręgach;
    private int[] liczbaMandatów = new int[3];

    public Partia(String nazwa, int n) {
        this.nazwa = nazwa;
        głosyWOkręgach = new int[n];
    }

    public void dodajMandaty(int indeks, int mandaty) {
        liczbaMandatów[indeks] += mandaty;
    }

    public int[] getLiczbaMandatów() {
        return liczbaMandatów;
    }

    public void setBudżet(int budżet) {
        this.budżet = budżet;
    }

    public int getBudżet() {
        return budżet;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getLiczbaGłosów() {
        return liczbaGłosów;
    }

    public int[] getGłosyWOkręgach() {
        return głosyWOkręgach;
    }

    public void dodajGłos(int i) {
        liczbaGłosów++;
        głosyWOkręgach[i]++;
    }

    public abstract void kampania(Okręg okręg, ListaDziałań listaDziałań, ListaWyborców listaWyborców);

    protected void wykonajDziałanie(Działanie działanie, ListaWyborców listaWyborców, int nrOkręgu) {
        //min waga to -100, max waga to 100
        for (int i = 0; i < listaWyborców.getRozmmiarListy(); i++) {
            Wyborca wyborca = listaWyborców.getWyborca(i);
            if (wyborca.getNrOkręgu() == nrOkręgu) {
                if (wyborca.getTyp() == 5 || wyborca.getTyp() == 8) {
                    for (int j = 0; j < wyborca.getWagi().size(); j++) {
                        int a = wyborca.getWagi().get(j);
                        int b = działanie.getOpis().get(j);
                        if (a + b > 100)
                            wyborca.getWagi().set(j, 100);
                        else if (a + b < -100)
                            wyborca.getWagi().set(j, -100);
                        else
                            wyborca.getWagi().set(j, a + b);
                    }
                }
            }
        }
    }
}
