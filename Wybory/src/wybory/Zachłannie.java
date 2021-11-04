package wybory;

public class Zachłannie extends Partia {

    public Zachłannie(String nazwa, int n) {
        super(nazwa, n);
    }

    @Override
    public void kampania(Okręg okręg, ListaDziałań listaDziałań, ListaWyborców listaWyborców) {
        Działanie działanie = listaDziałań.getOptymalne(okręg, this.getBudżet(), this.getNazwa());
        while (this.getBudżet() >= działanie.getCena(okręg.getLiczbaWyborców())) {
            int budżet = this.getBudżet() - działanie.getCena(okręg.getLiczbaWyborców());
            this.setBudżet(budżet);
            wykonajDziałanie(działanie, listaWyborców, okręg.getNumer());
        }
    }
}
