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
        if (set.size() != mengde.antall()) {
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
    public boolean erDisjunktMed(MengdeADT<T> mengde) {
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
        unionMengde.leggTilAlle(this);
        unionMengde.leggTilAlle(mengde);
        return unionMengde;
    }

    @Override
    public MengdeADT<T> differens(MengdeADT<T> mengde) {
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
    public void fjern(T element) {
        set.remove(element);
    }

    @Override
    public void leggTilAlle(MengdeADT<T> mengde) {
        for (T element : mengde) {
            leggTil(element);
        }
    }

    @Override
    public int antall() {
        return set.size();
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return set.iterator();
    }
}
