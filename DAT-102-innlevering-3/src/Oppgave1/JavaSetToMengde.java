package Oppgave1;
import java.util.HashSet;
import java.util.Set;

public class JavaSetToMengde<T> implements MengdeADT<T> {
    private Set<T> set;

    public JavaSetToMengde() {
        set = new HashSet<>();
    }

    @Override
    public boolean erTom() {
        return set.isEmpty();
    }

    @Override
    public boolean inneholder(T element) {
        return set.contains(element);
    }

    @Override
    public boolean erLik(MengdeADT<T> mengde) {
        if (set.size() != mengde.antallElementer()) {
            return false;
        }
        for (T element : set) {
            if (!mengde.inneholder(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> mengde) {
        for (T element : set) {
            if (!mengde.inneholder(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean erDisjunkt(MengdeADT<T> mengde) {
        for (T element : set) {
            if (mengde.inneholder(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> mengde) {
        MengdeADT<T> snittMengde = new JavaSetToMengde<>();
        for (T element : set) {
            if (mengde.inneholder(element)) {
                snittMengde.leggTil(element);
            }
        }
        return snittMengde;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> mengde) {
        MengdeADT<T> unionMengde = new JavaSetToMengde<>();
        unionMengde.leggTilAlleFra(this);
        unionMengde.leggTilAlleFra(mengde);
        return unionMengde;
    }

    @Override
    public MengdeADT<T> minus(MengdeADT<T> mengde) {
        MengdeADT<T> differensMengde = new JavaSetToMengde<>();
        for (T element : set) {
            if (!mengde.inneholder(element)) {
                differensMengde.leggTil(element);
            }
        }
        return differensMengde;
    }

    @Override
    public void leggTil(T element) {
        set.add(element);
    }

    @Override
    public T fjern(T element) {
    	T returnElement = element;
        set.remove(element);
        return element;
    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> mengde) {
        for (T element : mengde.tilTabell()) {
            leggTil(element);
        }
    }

    @Override
    public int antallElementer() {
        return set.size();
    }

    @Override
    public T[] tilTabell() {
        return (T[]) set.toArray();
    }



}
