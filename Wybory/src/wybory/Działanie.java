package wybory;

import java.util.ArrayList;

public class Działanie {
    private ArrayList<Integer> opis = new ArrayList<>();

    public int getCena(int liczbaWyborców) {
        return policzCene(liczbaWyborców);
    }

    private int policzCene(int liczbaWyborców) {
        int cena = 0;
        for (Integer o : opis) {
            cena += Math.abs(o);
        }
        cena *= liczbaWyborców;
        return cena;
    }

    public void setOpis(ArrayList<Integer> opis) {
        this.opis = opis;
    }

    public ArrayList<Integer> getOpis() {
        return opis;
    }

}
