package Oppgave1;

public class LenketMengde<T> implements MengdeADT{
	LenketMengde<T> nextNode;
	T value;
	
	public LenketMengde() {
	}
	
	public boolean erTom() {
		if (value == null && nextNode != null) {
			return false;
		}
		else {
			if (nextNode.erTom()) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public boolean inneholder(Object element) {
		if (value == element) {
			return true;
		}
		else if (nextNode != null) {
			return nextNode.inneholder(element);
		}
		else {
			return false;
		}
	}
	
	public boolean erDelmengdeAv(MengdeADT annenMengde) {
		T[] arr = (T[]) tilTabell();
		for (int i = 0; i < arr.length; i++) {
			if (!annenMengde.inneholder(arr[i])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean erLik(MengdeADT annenMengde) {
		T[] arr = (T[]) tilTabell();
		T[] otherArr = (T[]) annenMengde.tilTabell();
		if (arr.length != otherArr.length) {
			return false;
		}
		for (int i = 0; i < arr.length; i++) {
			if (otherArr[i] != arr[i]) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean erDisjunkt(MengdeADT annenMengde) {
		T[] arr = (T[]) tilTabell();
		for (int i = 0; i < arr.length; i++) {
			if (annenMengde.inneholder(arr[i])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public MengdeADT snitt(MengdeADT annenMengde) {
		MengdeADT newM = new LenketMengde<T>();
		T[] arr = (T[]) tilTabell();
		for (int i = 0; i < arr.length; i++) {
			if (annenMengde.inneholder(arr[i])) {
				newM.leggTil(arr[i]);
			}
		}
		return newM;
	}

	@Override
	public MengdeADT union(MengdeADT annenMengde) {
		MengdeADT newM = new LenketMengde<T>();
		T[] otherArr = (T[]) annenMengde.tilTabell();
		T[] arr = (T[]) tilTabell();
		for (int i = 0; i < arr.length; i++) {
			newM.leggTil(arr[i]);
		}
		for (int i = 0; i < otherArr.length; i++) {
			if (!inneholder(otherArr[i])) {
				newM.leggTil(otherArr[i]);
			}
		}
		return newM;
	}

	@Override
	public MengdeADT minus(MengdeADT annenMengde) {
		MengdeADT newM = new LenketMengde<T>();
		T[] arr = (T[]) tilTabell();
		for (int i = 0; i < arr.length; i++) {
			if (!annenMengde.inneholder(arr[i])) {
				newM.leggTil(arr[i]);
			}
		}
		return newM;
	}

	@Override
	public void leggTil(Object element) {
		value = (T)element;
		nextNode = new LenketMengde<T>();
	}

	@Override
	public void leggTilAlleFra(MengdeADT annenMengde) {
		T[] otherArr = (T[]) annenMengde.tilTabell();
		T[] arr = (T[]) tilTabell();
		for (int i = 0; i < otherArr.length; i++) {
			if (inneholder(otherArr[i])) {
				continue;
			}
			else {
				leggTil(otherArr[i]);
			}
		}
		
	}

	@Override
	public Object fjern(Object element) {
		LenketMengde<T> removedElement = null;
		LenketMengde<T> lastNode = this;
		LenketMengde<T> curNode = this;
		while (curNode.value != null) {
			if (curNode.value == element) {
				if (curNode == this) {
					removedElement = nextNode;
					T tempValue = value;
					value = nextNode.value;
					nextNode.value = tempValue;
					nextNode = removedElement.nextNode;
					break;
					
				}
				else {
					removedElement = curNode;
					lastNode.nextNode = curNode.nextNode;
					break;					
				}
			}
			lastNode = curNode;
			curNode = curNode.nextNode;
		}
		return removedElement;
	}

	@Override
	public Object[] tilTabell() {
		Object[] arr = new Object[antallElementer()];
		LenketMengde<T> curNode = this;
		int i = 0;
		while (curNode.value != null) {
			arr[i] = curNode.value;
			curNode = curNode.nextNode;
			i++;
		}
		return arr;
	}

	@Override
	public int antallElementer() {
		LenketMengde<T> curNode = this;
		int i = 0;
		while (curNode.value != null) {
			curNode = curNode.nextNode;
			i++;
		}
		return i;
	}


	
	
}
