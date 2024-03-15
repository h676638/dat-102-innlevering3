package Oppgave4;

import java.util.Arrays;
import java.util.HashSet;

public class Oppg4 {
	public static void main(String[] args) {
		int[] numbs = ranNumbs();
		testHashSet(numbs);
		testArray(numbs);
	}
	
	public static int[] ranNumbs() {
		int[] arr = new int[10000];
		for (int i = 0; i < 10000; i++) {
			arr[i] = (int) (Math.random() * 100000);
		}
		return arr;
	}
	
	public static void testHashSet(int[] numbs) {
		HashSet<Integer> hashSet = makeHashSet();
		int hashSetFound = 0;
		long startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			if (hashSet.contains(numbs[i])) {
				hashSetFound += 1;
			}
		}
		long endTime = System.nanoTime();
		System.out.println(hashSetFound + " " + (endTime - startTime));
	}
	public static void testArray(int[] numbs) {
		int[] arr = makeArray();
		Arrays.sort(arr);
		int arrayFound = 0;
		long startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			if (Arrays.binarySearch(arr, numbs[i]) != -1) {
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
