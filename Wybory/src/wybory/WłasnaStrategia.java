package wybory;

public class WłasnaStrategia extends Partia {

    public WłasnaStrategia(String nazwa, int n) {
        super(nazwa, n);
    }

    @Override
    public void kampania(Okręg okręg, ListaDziałań listaDziałań, ListaWyborców listaWyborców) {
        Działanie działanie = listaDziałań.getMaxLosowe(okręg.getLiczbaWyborców(), this.getBudżet());
        while (this.getBudżet() >= działanie.getCena(okręg.getLiczbaWyborców())) {
            int budżet = this.getBudżet() - działanie.getCena(okręg.getLiczbaWyborców());
            this.setBudżet(budżet);
            wykonajDziałanie(działanie, listaWyborców, okręg.getNumer());
            działanie = listaDziałań.getNajdroższe(okręg.getLiczbaWyborców(), this.getBudżet());
        }
    }
}
