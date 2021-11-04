package wybory;

public class Skromnie extends Partia {

    public Skromnie(String nazwa, int n) {
        super(nazwa, n);
    }

    @Override
    public void kampania(Okręg okręg, ListaDziałań listaDziałań, ListaWyborców listaWyborców) {
        Działanie działanie = listaDziałań.getNajtańsze(okręg.getLiczbaWyborców());
        while (this.getBudżet() >= działanie.getCena(okręg.getLiczbaWyborców())) {
            int budżet = this.getBudżet() - działanie.getCena(okręg.getLiczbaWyborców());
            this.setBudżet(budżet);
            wykonajDziałanie(działanie, listaWyborców, okręg.getNumer());
        }
    }
}
