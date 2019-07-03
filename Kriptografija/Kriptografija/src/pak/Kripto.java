package pak;

import java.util.Scanner;

public class Kripto {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.println("unesi duzinu niza");

		int N = s.nextInt();

		System.out.println("unesi kljuc koji su elementi niza koji su u opsegu od " + N + " do 1  bez ponavljanja random reda ");

		int[] kljuc = new int[N];

		for (int i = 0; i < kljuc.length; i++) {
			kljuc[i] = s.nextInt() - 1;

		}

		for (int i = 0; i < kljuc.length; i++) {
			System.out.print(kljuc[i]);

		}
		System.out.println("");
		System.out.println("ukucaj String ");

		String recenicaKojupretvaramoUNizKaraktera = s.next();
		recenicaKojupretvaramoUNizKaraktera.trim();

	

		char[] nizKarakteraOdRecenice = recenicaKojupretvaramoUNizKaraktera.toCharArray();

		int M = 0;

		if (nizKarakteraOdRecenice.length % N == 0) {
			M = nizKarakteraOdRecenice.length / N;
		} else {
			M = nizKarakteraOdRecenice.length / N + 1;
		}

		char[] nizKojiPretvaramU2d = new char[N * M];


		for (int i = 0; i < nizKojiPretvaramU2d.length; i++) {
			if (i == nizKarakteraOdRecenice.length)
				break;
			else {
				nizKojiPretvaramU2d[i] = nizKarakteraOdRecenice[i];
			}
		}

		char[][] stringPretvorenUmatricu = new char[M][N];

		int k = 0;

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {

				stringPretvorenUmatricu[i][kljuc[j]] = nizKojiPretvaramU2d[k++];
			}
		}

		for (int j = 0; j < N; j++) {
			for (int i = 0; i < M; i++) {
				System.out.print(stringPretvorenUmatricu[i][j]);
			}
		}

	}

}
