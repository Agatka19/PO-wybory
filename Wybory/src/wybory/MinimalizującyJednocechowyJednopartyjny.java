package wybory;

import java.util.ArrayList;

public class MinimalizującyJednocechowyJednopartyjny extends MJednocechowyJednopartyjny {
    //6
    public MinimalizującyJednocechowyJednopartyjny(String imie, String nazwisko, int nrOkręgu, int typWyborcy, int cecha, String nazwaPartii) {
        super(imie, nazwisko, nrOkręgu, typWyborcy, cecha, nazwaPartii);
    }

    @Override
    public Kandydat głosuj(Okręg okręg) {
        return głosujMJJ(okręg, 100, 1);
    }


    @Override
    public ArrayList<Integer> getWagi() {
        return null;
    }
}
