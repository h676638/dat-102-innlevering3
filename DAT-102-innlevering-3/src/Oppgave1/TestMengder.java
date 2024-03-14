package Oppgave1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestMengder {
	@Test
	public void testLeggTill() {
		LenketMengde<Integer> lenkMeng = new LenketMengde<Integer>();
		lenkMeng.leggTil(1);
		lenkMeng.leggTil(2);
		lenkMeng.leggTil(3);
		lenkMeng.leggTil(4);
		assertEquals(1, lenkMeng.value);
	}
	@Test
	public void testErTom() {
		LenketMengde<Integer> lenkMeng = new LenketMengde<Integer>();
		assertEquals(true, lenkMeng.erTom());
		lenkMeng.leggTil(1);
		lenkMeng.leggTil(2);
		lenkMeng.leggTil(3);
		lenkMeng.leggTil(4);
		assertEquals(false, lenkMeng.erTom());
	}
	@Test
	public void testInneholder() {
		LenketMengde<Integer> lenkMeng = new LenketMengde<Integer>();
		lenkMeng.leggTil(1);
		lenkMeng.leggTil(2);
		lenkMeng.leggTil(3);
		lenkMeng.leggTil(4);
		assertEquals(true, lenkMeng.inneholder(4));
		assertEquals(true, lenkMeng.inneholder(1));
		assertEquals(false, lenkMeng.inneholder(5));
	}
	
	
}
