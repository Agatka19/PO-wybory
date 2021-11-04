package wybory;

import java.util.ArrayList;

public class ListaWyborców {
    private ArrayList<Wyborca> listaWyborców = new ArrayList<>();

    public void setWyborca(Wyborca wyborca) {
        listaWyborców.add(wyborca);
    }

    public Wyborca getWyborca(int i) {
        return listaWyborców.get(i);
    }

    public int getRozmmiarListy() {
        return listaWyborców.size();
    }

}
