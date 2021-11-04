package wybory;

public class ZRozmachem extends Partia {

    public ZRozmachem(String nazwa, int n) {
        super(nazwa, n);
    }

    @Override
    public void kampania(Okręg okręg, ListaDziałań listaDziałań, ListaWyborców listaWyborców) {
        Działanie działanie = listaDziałań.getNajdroższe(okręg.getLiczbaWyborców(), this.getBudżet());
        while (this.getBudżet() >= działanie.getCena(okręg.getLiczbaWyborców())) {
            int budżet = this.getBudżet() - działanie.getCena(okręg.getLiczbaWyborców());
            this.setBudżet(budżet);
            wykonajDziałanie(działanie, listaWyborców, okręg.getNumer());
            działanie = listaDziałań.getNajdroższe(okręg.getLiczbaWyborców(), budżet);
        }
    }
}
