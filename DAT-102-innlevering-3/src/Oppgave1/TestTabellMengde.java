package Oppgave1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class TestTabellMengde {
	
	@Test
    public void testErTom() {
        TabellMengde<Integer> mengde = new TabellMengde<>();
        assertTrue(mengde.erTom());
        mengde.leggTil(1);
        assertFalse(mengde.erTom());
    }

    @Test
    public void testInneholder() {
        TabellMengde<Integer> mengde = new TabellMengde<>();
        mengde.leggTil(1);
        assertTrue(mengde.inneholder(1));
        assertFalse(mengde.inneholder(2));
    }

    @Test
    public void testErLik() {
        TabellMengde<Integer> mengde1 = new TabellMengde<>();
        mengde1.leggTil(1);
        mengde1.leggTil(2);
        mengde1.leggTil(3);

        TabellMengde<Integer> mengde2 = new TabellMengde<>();
        mengde2.leggTil(1);
        mengde2.leggTil(2);
        mengde2.leggTil(3);

        assertTrue(mengde1.erLik(mengde2));
    }

    @Test
    public void testErDelmengdeAv() {
        TabellMengde<Integer> mengde1 = new TabellMengde<>();
        mengde1.leggTil(1);
        mengde1.leggTil(2);
        mengde1.leggTil(3);

        TabellMengde<Integer> mengde2 = new TabellMengde<>();
        mengde2.leggTil(1);
        mengde2.leggTil(2);
        mengde2.leggTil(3);
        mengde2.leggTil(4);

        assertTrue(mengde1.erDelmengdeAv(mengde2));
        assertFalse(mengde2.erDelmengdeAv(mengde1));
    }

    @Test
    public void testErDisjunktMed() {
        TabellMengde<Integer> mengde1 = new TabellMengde<>();
        mengde1.leggTil(1);
        mengde1.leggTil(2);

        TabellMengde<Integer> mengde2 = new TabellMengde<>();
        mengde2.leggTil(3);
        mengde2.leggTil(4);

        assertTrue(mengde1.erDisjunkt(mengde2));
        assertFalse(mengde1.erDisjunkt(mengde1));
    }

    @Test
    public void testSnitt() {
        TabellMengde<Integer> mengde1 = new TabellMengde<>();
        mengde1.leggTil(1);
        mengde1.leggTil(2);
        mengde1.leggTil(3);

        TabellMengde<Integer> mengde2 = new TabellMengde<>();
        mengde2.leggTil(2);
        mengde2.leggTil(3);
        mengde2.leggTil(4);

        MengdeADT<Integer> snittMengde = mengde1.snitt(mengde2);

        assertTrue(snittMengde.inneholder(2));
        assertTrue(snittMengde.inneholder(3));
        assertFalse(snittMengde.inneholder(1));
        assertFalse(snittMengde.inneholder(4));
    }

    @Test
    public void testUnion() {
        TabellMengde<Integer> mengde1 = new TabellMengde<>();
        mengde1.leggTil(1);
        mengde1.leggTil(2);

        TabellMengde<Integer> mengde2 = new TabellMengde<>();
        mengde2.leggTil(2);
        mengde2.leggTil(3);

        MengdeADT<Integer> unionMengde = mengde1.union(mengde2);

        assertTrue(unionMengde.inneholder(1));
        assertTrue(unionMengde.inneholder(2));
        assertTrue(unionMengde.inneholder(3));
        assertFalse(unionMengde.erTom());
    }

    @Test
    public void testDifferens() {
        TabellMengde<Integer> mengde1 = new TabellMengde<>();
        mengde1.leggTil(1);
        mengde1.leggTil(2);
        mengde1.leggTil(3);

        TabellMengde<Integer> mengde2 = new TabellMengde<>();
        mengde2.leggTil(2);
        mengde2.leggTil(3);
        mengde2.leggTil(4);

        MengdeADT<Integer> differensMengde = mengde1.minus(mengde2);

        assertTrue(differensMengde.inneholder(1));
        assertFalse(differensMengde.inneholder(2));
        assertFalse(differensMengde.inneholder(3));
        assertFalse(differensMengde.inneholder(4));
    }

    @Test
    public void testLeggTilOgFjern() {
        TabellMengde<Integer> mengde = new TabellMengde<>();
        mengde.leggTil(1);
        mengde.leggTil(2);

        assertTrue(mengde.inneholder(1));
        assertTrue(mengde.inneholder(2));

        mengde.fjern(1);
        assertFalse(mengde.inneholder(1));
        assertTrue(mengde.inneholder(2));
    }

    @Test
    public void testLeggTilAlleFra() {
        TabellMengde<Integer> mengde1 = new TabellMengde<>();
        mengde1.leggTil(1);
        mengde1.leggTil(2);

        TabellMengde<Integer> mengde2 = new TabellMengde<>();
        mengde2.leggTil(3);
        mengde2.leggTil(4);

        mengde1.leggTilAlleFra(mengde2);

        assertTrue(mengde1.inneholder(1));
        assertTrue(mengde1.inneholder(2));
        assertTrue(mengde1.inneholder(3));
        assertTrue(mengde1.inneholder(4));
    }
}
