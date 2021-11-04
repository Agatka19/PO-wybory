package wybory;

import java.util.ArrayList;

public class WszechstronnyJednopartyjny extends Wszechstronni {
    //8
    private final String nazwaPartii;

    public WszechstronnyJednopartyjny(String imie, String nazwisko, int nrOkręgu, int typWyborcy, ArrayList<Integer> wagi, String nazwaPartii) {
        super(imie, nazwisko, nrOkręgu, typWyborcy, wagi);
        this.nazwaPartii = nazwaPartii;
    }


    @Override
    public Kandydat głosuj(Okręg okręg) {
        return głosujWszechstronnie(okręg, true, nazwaPartii);
    }


    @Override
    public ArrayList<Integer> getWagi() {
        return getWagiW();
    }
}
