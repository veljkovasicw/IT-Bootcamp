package pak;

import java.util.HashMap;

public class IzomorfneReci {

	public static void brojKaraktera(String prvi, String drugi) {

	}

	public static boolean daLiJeIzomorfna(String prvi, String drugi) {

		HashMap<Character, Character> mapaSlova = new HashMap<Character, Character>();
		if (prvi.length() != drugi.length()) {
			return false;
		}

		int duzina = prvi.length();

		int brojacGlobal = 0;
		for (int i = 0; i < duzina; i++) {
			if (!(mapaSlova.containsKey(prvi.charAt(i))) && !(mapaSlova.containsKey(drugi.charAt(i)))) {

				mapaSlova.put(prvi.charAt(i), drugi.charAt(i));

				int brojac = 1;

				for (int j = i + 1; j < duzina; j++) {
					if (mapaSlova.containsKey(prvi.charAt(j)) && mapaSlova.get(prvi.charAt(i)) == drugi.charAt(j)) {
						brojac++;

					}

				}

				brojacGlobal += brojac;
			}
		}

		return brojacGlobal == duzina;
	}

	public static void main(String[] args) {

		System.out.println(daLiJeIzomorfna("nonoznk", "fefezft"));

	}

}
