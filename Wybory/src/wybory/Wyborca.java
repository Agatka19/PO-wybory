package wybory;

import java.util.ArrayList;

public abstract class Wyborca extends Człowiek {
    private int nrOkręgu;
    private final int typWyborcy;
    private Kandydat kandydatNaKtóregoGłosuje;

    public Wyborca(String imie, String nazwisko, int nrOkręgu, int typWyborcy) {
        super(imie, nazwisko);
        this.nrOkręgu = nrOkręgu;
        this.typWyborcy = typWyborcy;
    }

    abstract public Kandydat głosuj(Okręg okręg);

    protected void dajGłosPartii(Okręg okręg, Kandydat kandydat) {
        for (int i = 0; i < okręg.getListaKandydatów().size(); i++) {
            if (okręg.getListaKandydatów().get(i) == kandydat) {
                okręg.getListaPartiiKandydatów().get(i).dodajGłos(okręg.getNumer());
                return;
            }
        }
    }

    public int getTyp() {
        return typWyborcy;
    }

    public abstract ArrayList<Integer> getWagi();

    public int getNrOkręgu() {
        return nrOkręgu;
    }

    public void setNrOkręgu(int nrOkręgu) {
        this.nrOkręgu = nrOkręgu;
    }
}
