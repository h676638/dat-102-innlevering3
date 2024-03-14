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
	    public boolean leggTil(T element) {
	        if (!inneholder(element)) {
	            if (antall == mengde.length) {
	                utvidKapasitet();
	            }
	            mengde[antall] = element;
	            antall++;
	            return true;
	        }
	        return false;
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
	
	}
