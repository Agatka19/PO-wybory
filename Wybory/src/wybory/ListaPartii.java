package wybory;

import java.util.ArrayList;

public class ListaPartii {
    private ArrayList<Partia> listaPartii = new ArrayList<>();

    public void setPartia(Partia partia) {
        listaPartii.add(partia);
    }

    public Partia getPartia(int i) {
        return listaPartii.get(i);
    }

    public int getRozmiarListy() {
        return listaPartii.size();
    }

    public ArrayList<Partia> getListaPartii() {
        return listaPartii;
    }
}
