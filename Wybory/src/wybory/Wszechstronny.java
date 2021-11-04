package wybory;

import java.util.ArrayList;

public class Wszechstronny extends Wszechstronni {
    //5
    public Wszechstronny(String imie, String nazwisko, int nrOkręgu, int typWyborcy, ArrayList<Integer> wagi) {
        super(imie, nazwisko, nrOkręgu, typWyborcy, wagi);
    }

    @Override
    public Kandydat głosuj(Okręg okręg) {
        return głosujWszechstronnie(okręg, false, null);
    }

    @Override
    public ArrayList<Integer> getWagi() {
        return getWagiW();
    }
}
