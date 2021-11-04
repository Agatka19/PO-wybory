package wybory;

import java.util.ArrayList;

public class MinimalizującyJednocechowy extends MJednocechowy {
    //3
    public MinimalizującyJednocechowy(String imie, String nazwisko, int nrOkręgu, int typWyborcy, int cecha) {
        super(imie, nazwisko, nrOkręgu, typWyborcy, cecha);
    }

    @Override
    public Kandydat głosuj(Okręg okręg) {
        return głosujMJednocechowy(okręg, 100, 1, false, null);
    }

    @Override
    public ArrayList<Integer> getWagi() {
        return null;
    }
}
