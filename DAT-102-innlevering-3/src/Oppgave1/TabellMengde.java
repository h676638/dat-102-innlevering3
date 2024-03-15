package Oppgave1;

public class TabellMengde<T> implements MengdeADT<T> {
    private final static int STDK = 100; 
    private T[] mengde; 
    private int antall; 

    public TabellMengde() {
        this(STDK);
    }

    @SuppressWarnings("unchecked")
    public TabellMengde(int startKapasitet) {
        antall = 0;
        mengde = (T[])new Object[startKapasitet];
    }

    @Override
    public boolean erTom() {
        return antall == 0;
    }

    @Override
    public void leggTil(T element) {
        if (!inneholder(element)) {
            if (antall == mengde.length) {
                utvidKapasitet();
            }
            mengde[antall] = element;
            antall++;
        }
    }

    @Override
    public boolean inneholder(T element) {
        for (int i = 0; i < antall; i++) {
            if (mengde[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    private void utvidKapasitet() {
        @SuppressWarnings("unchecked")
        T[] hjelpeTabell = (T[])new Object[mengde.length * 2];
        System.arraycopy(mengde, 0, hjelpeTabell, 0, mengde.length);
        mengde = hjelpeTabell;
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        for (T element : this) { // Original loop (can be kept)
            if (!annenMengde.inneholder(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        return this.erDelmengdeAv(annenMengde) && annenMengde.erDelmengdeAv(this);
    }

    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        for (T element : this) {  
            if (annenMengde.inneholder(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
        TabellMengde<T> nyMengde = new TabellMengde<>();
        for (T element : this) {
            if (annenMengde.inneholder(element)) {
                nyMengde.leggTil(element);
            }
        }
        return nyMengde;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
        TabellMengde<T> nyMengde = new TabellMengde<>();
        for (T element : this) {
            nyMengde.leggTil(element);
        }
        for (T element : annenMengde) {
            if (!inneholder(element)) {
                nyMengde.leggTil(element);
            }
        }
        return nyMengde;
    }

    @Override
    public T fjern(T element) {
        int pos = finnPosisjon(element);
        if (pos == -1) {
            return null;
        }
        T fjernetElement = mengde[pos];
        mengde[pos] = mengde[antall - 1];
        antall--;
        return fjernetElement;
    }

    private int finnPosisjon(T element) {
        for (int i = 0; i < antall; i++) {
            if (mengde[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int antallElementer() {
        return antall;
    }

    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
        TabellMengde<T> nyMengde = new TabellMengde<>();
        for (T element : this) {
            if (!annenMengde.inneholder(element)) {
                nyMengde.leggTil(element);
            }
        }
        return nyMengde;
    }
}

