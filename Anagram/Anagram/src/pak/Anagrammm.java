package pak;

import java.util.Scanner;

public class Anagrammm {

	public static void sortirajniz(double[] niz) {

		for (int i = 0; i < niz.length - 1; i++) {
			double sledeci = niz[i];
			int pozicija = i;
			for (int j = i + 1; j < niz.length; j++) {
				if (niz[j] < sledeci) {
					sledeci = niz[j];
					pozicija = j;
				}
			}
			niz[pozicija] = niz[i];

			niz[i] = sledeci;

		}

	}

	public static void proveraAnagrama(double[] niki, double[] buki) {
		String nisu = "nisu anagrami";
		String jesu = "jesu anagrami";

		sortirajniz(niki);
		sortirajniz(buki);
		int duzinaNiza = 0;

		for (int i = 0; i < niki.length; i++) {
			if (niki[i] != buki[i]) {
				System.out.println(nisu);
				break;
			}
			duzinaNiza++;
			if (duzinaNiza == niki.length) {
				System.out.println(jesu);
				break;
			}

		}
	}
	
	
	public static double[] ucitavanjeElemenataNiza(int x) {
		
		Scanner sk= new Scanner (System.in);
		
		double[] niz1 = new double[x];
		
		for (int i = 0 ; i<niz1.length; i++) {
			double bubu=sk.nextDouble();
			niz1[i]=bubu;
			
		}
		
		return niz1;
	}
	
	
	
	

	public static void main(String[] args) {

		System.out.println("Uneti duzinu nizova ");

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		
		if(n>100 || n<1) {
			System.err.println("Niz mora biti kraci od 100 i duzi od 1");
		}
		else {
			System.out.println("odradi medotu");
		proveraAnagrama(ucitavanjeElemenataNiza(n), ucitavanjeElemenataNiza(n));
		System.out.println("kraj");
		}
		

		
		sc.close();
	}

}
