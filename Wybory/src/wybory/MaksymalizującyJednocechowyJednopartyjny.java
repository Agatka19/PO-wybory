package wybory;

import java.util.ArrayList;

public class MaksymalizującyJednocechowyJednopartyjny extends MJednocechowyJednopartyjny {
    //7
    public MaksymalizującyJednocechowyJednopartyjny(String imie, String nazwisko, int nrOkręgu, int typWyborcy, int cecha, String nazwaPartii) {
        super(imie, nazwisko, nrOkręgu, typWyborcy, cecha, nazwaPartii);
    }

    @Override
    public Kandydat głosuj(Okręg okręg) {
        return głosujMJJ(okręg, -100, -1);
    }

    @Override
    public ArrayList<Integer> getWagi() {
        return null;
    }
}
