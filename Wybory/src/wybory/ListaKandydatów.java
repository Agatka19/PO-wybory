package wybory;

import java.util.ArrayList;

public class ListaKandydatów {
    private ArrayList<Kandydat> listaKandydatów = new ArrayList<>();

    public void setKandydat(Kandydat kandydat) {
        listaKandydatów.add(kandydat);
    }

    public Kandydat getKandydat(int i) {
        return listaKandydatów.get(i);
    }

    public int getRozmiarListy() {
        return this.listaKandydatów.size();
    }

}
