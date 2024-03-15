package Oppgave4;

import java.util.Arrays;
import java.util.HashSet;

public class Oppg4 {
	static int searchNumMut = 11; // Change this to change search numbers
	public static void main(String[] args) {
		testArray();
		testHashSet();
	}
	
	public static void testHashSet() {
		HashSet<Integer> hashSet = makeHashSet();
		int hashSetFound = 0;
		long startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			if (hashSet.contains(i + searchNumMut)) {
				hashSetFound += 1;
			}
		}
		long endTime = System.nanoTime();
		System.out.println(hashSetFound + " " + (endTime - startTime));
	}
	public static void testArray() {
		int[] arr = makeArray();
		Arrays.sort(arr);
		int arrayFound = 0;
		long startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			if (Arrays.binarySearch(arr, i + searchNumMut) != -1) {
				arrayFound += 1;
			}
		}
		long endTime = System.nanoTime();
		System.out.println(arrayFound + " " + (endTime - startTime));
	}
	
	public static int[] makeArray() {
		int tall = 376;
		int[] arr = new int[100000];
		for (int i = 0; i < 100000; i++){
			tall = (tall + 45713) % 100000; 
			arr[i] = tall;
		}
		return arr;
	}
	public static HashSet<Integer> makeHashSet() {
		HashSet<Integer> hashSet = new HashSet<Integer>();
		int tall = 376;
		for (int i = 0; i < 100000; i++){
			tall = (tall + 45713) % 100000; 
			hashSet.add(tall);
		}
		return hashSet;
	}

}
