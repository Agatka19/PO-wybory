package wybory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Wybory {
    private ListaOkręgów listaOkręgów = new ListaOkręgów();
    private ListaPartii listaPartii = new ListaPartii();
    private ListaWyborców listaWyborców = new ListaWyborców();
    private ListaKandydatów listaKandydatów = new ListaKandydatów();
    private ListaDziałań listaDziałań = new ListaDziałań();
    ArrayList<String> nazwyPartii = new ArrayList<>();
    ArrayList<Integer> budżety = new ArrayList<>();
    private int ogólnaLiczbaWyborców = 0;

    public void czytaj() {
        try {
            Scanner czytaj = new Scanner(System.in);
            int numerLinii = 0;
            while (czytaj.hasNextLine() && numerLinii < 5914) {
                numerLinii++;
                String linia = czytaj.nextLine();
                interpretuj(linia, numerLinii);
            }
            czytaj.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void interpretuj(String linia, int numerLinii) {
        String[] wyrazy = linia.split("\\s+");
        if (numerLinii == 1) {
            pierwszaLinia(wyrazy);
        } else if (numerLinii == 2) {
            drugaLinia(wyrazy);
        } else if (numerLinii == 3) {
            trzeciaLinia(wyrazy);
        } else if (numerLinii == 4) {
            czwartaLinia(wyrazy);
        } else if (numerLinii == 5) {
            piątaLinia(wyrazy);
        } else if (numerLinii == 6) {
            szóstaLinia(wyrazy);
        } else if (numerLinii > 6 && numerLinii <= (6 + (ogólnaLiczbaWyborców / 10) * listaPartii.getRozmiarListy())) {
            kandydaciLinia(wyrazy);
        } else if (numerLinii <= (6 + ((ogólnaLiczbaWyborców / 10) * listaPartii.getRozmiarListy()) + ogólnaLiczbaWyborców)) {
            wyborcyLinia(wyrazy);
        } else {
            dWierszy(wyrazy);
        }
    }


    private void pierwszaLinia(String[] wyrazy) {
        //zakładam, że dane są poprawne:
        int n = Integer.parseInt(wyrazy[0]); //liczba podstawowych okręgów wyborczych
        //int p = Integer.parseInt(wyrazy[1]); //liczba partii <- nie używam tego, więc wykomentowałam
        int d = Integer.parseInt(wyrazy[2]); //liczba możliwych działań
        //int c = Integer.parseInt(wyrazy[3]); //liczba cech kandydatów <- nie używam tego, więc wykomentowałam
        listaOkręgów.setListaOkręgów(n);
    }

    private void drugaLinia(String[] wyrazy) {
        for (int i = 1; i < wyrazy.length; i++) {
            String[] pary = wyrazy[i].split("(?!^)");
            int okręg1 = Integer.parseInt(pary[1]); // bo pary[0] to nawias
            int okręg2 = okręg1 + 1;
            listaOkręgów.getOkręg(okręg1).setPołączonyZ(listaOkręgów.getOkręg(okręg2));
        }
    }

    private void trzeciaLinia(String[] wyrazy) {
        nazwyPartii.addAll(Arrays.asList(wyrazy));
    }

    private void czwartaLinia(String[] wyrazy) {
        for (String s : wyrazy) {
            budżety.add(Integer.parseInt(s));
        }
    }

    private void piątaLinia(String[] wyrazy) {
        for (int i = 0; i < wyrazy.length; i++) {
            switch (wyrazy[i]) {
                case "R":
                    ZRozmachem zRozmachem = new ZRozmachem(nazwyPartii.get(i), listaOkręgów.getRozmiarListy());
                    listaPartii.setPartia(zRozmachem);
                    break;
                case "S":
                    Skromnie skromnie = new Skromnie(nazwyPartii.get(i), listaOkręgów.getRozmiarListy());
                    listaPartii.setPartia(skromnie);
                    break;
                case "W":
                    WłasnaStrategia własnaStrategia = new WłasnaStrategia(nazwyPartii.get(i), listaOkręgów.getRozmiarListy());
                    listaPartii.setPartia(własnaStrategia);
                    break;
                case "Z":
                    Zachłannie zachłannie = new Zachłannie(nazwyPartii.get(i), listaOkręgów.getRozmiarListy());
                    listaPartii.setPartia(zachłannie);
                    break;
            }
        }
        for (int i = 0; i < listaPartii.getRozmiarListy(); i++) {
            Partia partia = listaPartii.getPartia(i);
            partia.setBudżet(budżety.get(i));
        }
    }

    private void szóstaLinia(String[] wyrazy) {
        for (int i = 0; i < wyrazy.length; i++) {
            int a = Integer.parseInt(wyrazy[i]);
            ogólnaLiczbaWyborców += a;
            listaOkręgów.getOkręg(i + 1).setLiczbaWyborców(a);
        }
    }

    private void kandydaciLinia(String[] wyrazy) {
        String imie = wyrazy[0];
        String nazwisko = wyrazy[1];
        int nrOkręgu = Integer.parseInt(wyrazy[2]);
        String nazwaPartii = wyrazy[3];
        int pozaycjaNaLiście = Integer.parseInt(wyrazy[4]);
        ArrayList<Integer> cechy = new ArrayList<>();
        for (int i = 5; i < wyrazy.length; i++) {
            cechy.add(Integer.parseInt(wyrazy[i]));
        }
        Kandydat kandydat = new Kandydat(imie, nazwisko, nrOkręgu, nazwaPartii, pozaycjaNaLiście, cechy);
        listaKandydatów.setKandydat(kandydat);
        for (int i = 0; i < listaPartii.getRozmiarListy(); i++) {
            if (listaPartii.getPartia(i).getNazwa().equals(nazwaPartii)) {
                Partia partia = listaPartii.getPartia(i);
                listaOkręgów.getOkręg(nrOkręgu).setPartia(partia);
                break;
            }
        }
        listaOkręgów.getOkręg(nrOkręgu).setKandydat(kandydat);
    }

    private void wyborcyLinia(String[] wyrazy) {
        String imie = wyrazy[0];
        String nazwisko = wyrazy[1];
        int nrOkręgu = Integer.parseInt(wyrazy[2]);
        String nazwaPartii;
        int pozycjaKandydata;
        int cecha;
        int typ = Integer.parseInt(wyrazy[3]);
        switch (typ) {
            case 1:
                nazwaPartii = wyrazy[4];
                ŻelaznyElektoratPartyjny żelaznyElektoratPartyjny = new ŻelaznyElektoratPartyjny(imie, nazwisko, nrOkręgu, typ, nazwaPartii);
                listaWyborców.setWyborca(żelaznyElektoratPartyjny);
                break;
            case 2:
                nazwaPartii = wyrazy[4];
                pozycjaKandydata = Integer.parseInt(wyrazy[5]);
                ŻelaznyElektoratKandydata żelaznyElektoratKandydata = new ŻelaznyElektoratKandydata(imie, nazwisko, nrOkręgu, typ, nazwaPartii, pozycjaKandydata);
                listaWyborców.setWyborca(żelaznyElektoratKandydata);
                break;
            case 3:
                cecha = Integer.parseInt(wyrazy[4]);
                MinimalizującyJednocechowy minimalizującyJednocechowy = new MinimalizującyJednocechowy(imie, nazwisko, nrOkręgu, typ, cecha);
                listaWyborców.setWyborca(minimalizującyJednocechowy);
                break;
            case 4:
                cecha = Integer.parseInt(wyrazy[4]);
                MaksymalizującyJednocechowy maksymalizującyJednocechowy = new MaksymalizującyJednocechowy(imie, nazwisko, nrOkręgu, typ, cecha);
                listaWyborców.setWyborca(maksymalizującyJednocechowy);
                break;
            case 5:
                ArrayList<Integer> wartościWag = new ArrayList<>();
                for (int i = 4; i < wyrazy.length; i++) {
                    wartościWag.add(Integer.parseInt(wyrazy[i]));
                }
                Wszechstronny wszechstronny = new Wszechstronny(imie, nazwisko, nrOkręgu, typ, wartościWag);
                listaWyborców.setWyborca(wszechstronny);
                break;
            case 6:
                cecha = Integer.parseInt(wyrazy[4]);
                nazwaPartii = wyrazy[5];
                MinimalizującyJednocechowyJednopartyjny minimalizującyJednocechowyJednopartyjny = new MinimalizującyJednocechowyJednopartyjny(imie, nazwisko, nrOkręgu, typ, cecha, nazwaPartii);
                listaWyborców.setWyborca(minimalizującyJednocechowyJednopartyjny);
                break;
            case 7:
                cecha = Integer.parseInt(wyrazy[4]);
                nazwaPartii = wyrazy[5];
                MaksymalizującyJednocechowyJednopartyjny maksymalizującyJednocechowyJednopartyjny = new MaksymalizującyJednocechowyJednopartyjny(imie, nazwisko, nrOkręgu, typ, cecha, nazwaPartii);
                listaWyborców.setWyborca(maksymalizującyJednocechowyJednopartyjny);
                break;
            case 8:
                ArrayList<Integer> wartościWag1 = new ArrayList<>();
                for (int i = 4; i < wyrazy.length - 1; i++) {
                    wartościWag1.add(Integer.parseInt(wyrazy[i]));
                }
                nazwaPartii = wyrazy[wyrazy.length - 1];
                WszechstronnyJednopartyjny wszechstronnyJednopartyjny = new WszechstronnyJednopartyjny(imie, nazwisko, nrOkręgu, typ, wartościWag1, nazwaPartii);
                listaWyborców.setWyborca(wszechstronnyJednopartyjny);
        }
    }

    private void dWierszy(String[] wyrazy) {
        ArrayList<Integer> działania = new ArrayList<>();
        for (String s : wyrazy) {
            if (!s.equals("")) {
                działania.add(Integer.parseInt(s));
            }
        }
        Działanie działanie = new Działanie();
        działanie.setOpis(działania);
        listaDziałań.getListaDziałań().add(działanie);
    }

    public void przeprowadźWybory() {
        listaOkręgów.Scal(listaWyborców, listaKandydatów);
        for (int i = 1; i < listaOkręgów.getRozmiarListy(); i++) {
            if (listaOkręgów.getOkręg(i) != null) {
                Okręg okręg = listaOkręgów.getOkręg(i);
                System.out.println("Nr okręgu: " + okręg.getNumer() + ":");
                for (int j = 0; j < okręg.getListaPartiiKandydatów().size(); j++) {
                    okręg.getListaPartiiKandydatów().get(j).kampania(okręg, listaDziałań, listaWyborców);
                }
                for (int j = 0; j < listaWyborców.getRozmmiarListy(); j++) {
                    if (listaWyborców.getWyborca(j).getNrOkręgu() == okręg.getNumer()) {
                        Wyborca wyborca = listaWyborców.getWyborca(j);
                        Kandydat kandydat = wyborca.głosuj(okręg);
                        System.out.println(wyborca.getImie() + " " + wyborca.getNazwisko() + ": oddano głos na: " + kandydat.getImie() + " " + kandydat.getNazwisko());
                    }
                }
                for (int j = 0; j < okręg.getListaKandydatów().size(); j++) {
                    Kandydat kandydat = okręg.getListaKandydatów().get(j);
                    System.out.println(kandydat.getImie() + " " + kandydat.getNazwisko() + " " + kandydat.getNazwaPartii() + " " + kandydat.getPozycjaNaLiście() + " " + kandydat.getLiczbaGłosów());
                }

                MetodaDHonta metodaDHonta = new MetodaDHonta(okręg);
                MetodaHareaNiemeyera metodaHareaNiemeyera = new MetodaHareaNiemeyera(okręg);
                MetodaSainteLague metodaSainteLague = new MetodaSainteLague(okręg);
                System.out.println("D'Hont:");
                metodaDHonta.przeliczGłosy(listaPartii);
                System.out.println("Saint-Lague:");
                metodaSainteLague.przeliczGłosy(listaPartii);
                System.out.println("Hare-Niemeyer:");
                metodaHareaNiemeyera.przeliczGłosy(listaPartii);
                System.out.println();
            }
        }
        System.out.println("Ogólnie:");
        System.out.println("D'Hondt:");
        MetodaDHonta.wypiszMandatySuma(listaPartii, 0);
        System.out.println("Sainte-Lague:");
        MetodaDHonta.wypiszMandatySuma(listaPartii, 1);
        System.out.println("Hare-Niemeyer:");
        MetodaDHonta.wypiszMandatySuma(listaPartii, 2);
        System.out.println();
    }

}