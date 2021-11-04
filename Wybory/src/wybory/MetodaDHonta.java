package wybory;

public class MetodaDHonta extends Dzielnik {
    public MetodaDHonta(Okręg okręg) {
        super(okręg);
    }

    @Override
    public void przeliczGłosy(ListaPartii listaPartii) {
        przeliczGłosyZDzielnikiem(listaPartii, 1, 0);
    }
}
