package Oppgave1;
public interface MengdeADT<T> {
    boolean erTom();
    boolean leggTil(T element);
    boolean inneholder(T element);
}
