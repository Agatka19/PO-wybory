package wybory;

public abstract class MJednocechowyJednopartyjny extends MJednocechowy {
    private final String nazwaPartii;

    public MJednocechowyJednopartyjny(String imie, String nazwisko, int nrOkręgu, int typWyborcy, int cecha, String nazwaPartii) {
        super(imie, nazwisko, nrOkręgu, typWyborcy, cecha);
        this.nazwaPartii = nazwaPartii;
    }

    protected Kandydat głosujMJJ(Okręg okręg, int ekstremum, int mnożnik) {
        return głosujMJednocechowy(okręg, ekstremum, mnożnik, true, nazwaPartii);
    }
}
