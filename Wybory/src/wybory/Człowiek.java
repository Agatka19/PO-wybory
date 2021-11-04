package wybory;

public abstract class Człowiek {
    private final String imie;
    private final String nazwisko;

    public Człowiek(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }
}
