package wybory;

public class MetodaSainteLague extends Dzielnik {

    public MetodaSainteLague(Okręg okręg) {
        super(okręg);
    }

    @Override
    public void przeliczGłosy(ListaPartii listaPartii) {
        przeliczGłosyZDzielnikiem(listaPartii, 2, 1);
    }

}