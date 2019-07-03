package pak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Tabla {

	private char[][] praznaTabla;

	public Tabla() {
		praznaTabla = new char[8][8];
	}

	public char[][] getTabla() {
		return praznaTabla;
	}

	public void setTabla(char[][] tabla) {
		this.praznaTabla = tabla;
	}

	public void ispisivanjeBelihFiguricaNaMatricu() {

		try {
			BufferedReader br = new BufferedReader(new FileReader("beli.txt"));

			char[][] mestaBelih = new char[8][8];

			char[] jedanRed = new char[8];
			String jedanRedic;
			for (int i = 0; i < mestaBelih.length; i++) {
				jedanRedic = br.readLine();
				jedanRed = jedanRedic.toCharArray();
				for (int j = 0; j < mestaBelih[i].length; j++) {
					mestaBelih[i][j] = jedanRed[j];
				}
			}
			this.praznaTabla = mestaBelih;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void ispisivanjeCrnihhFiguricaNaMatricu() {

		try {
			BufferedReader br = new BufferedReader(new FileReader("crni.txt"));

			char[][] mestaCrnih = new char[8][8];

			char[] jedanRed = new char[8];
			String jedanRedic;
			for (int i = 0; i < mestaCrnih.length; i++) {
				jedanRedic = br.readLine();
				jedanRed = jedanRedic.toCharArray();
				for (int j = 0; j < mestaCrnih[i].length; j++) {
					mestaCrnih[i][j] = jedanRed[j];
				}
			}
			this.praznaTabla = mestaCrnih;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public LinkedList<String> nadjiPozicijeKonja() {

		LinkedList<String> pozicijeSkakaca = new LinkedList<>();

		for (int i = 0; i < this.praznaTabla.length; i++) {

			for (int j = 0; j < this.praznaTabla[i].length; j++) {
				if (this.praznaTabla[i][j] == 'S') {

					String skakac = i + " " + j;
					pozicijeSkakaca.add(skakac);

				}
			}

		}
		return pozicijeSkakaca;

	}

	public LinkedList<String> nadjiBelogKonja() {

		LinkedList<String> pozicijeSkakaca = new LinkedList<>();

		for (int i = 0; i < this.praznaTabla.length; i++) {

			for (int j = 0; j < this.praznaTabla[i].length; j++) {
				if (this.praznaTabla[i][j] == 'B') {

					String skakac = i + " " + j;
					pozicijeSkakaca.add(skakac);

				}
			}

		}
		
		
		return pozicijeSkakaca;

	}

	public void ubaciBelogKonjaUCrnaPolja(LinkedList<String> pozicijaBelogKonja) {

		// pozovi metoduispisa crnog polja

		int prvi;

		int drugi;

		LinkedList<Integer> pozicija = new LinkedList<>();

		for (int i = 0; i < pozicijaBelogKonja.size(); i++) {
			int k = 0;
			String[] delovi = pozicijaBelogKonja.get(i).split(" ");
			prvi = Integer.parseInt(delovi[0]);
			pozicija.add(k, prvi);
			k++;
			drugi = Integer.parseInt(delovi[1]);
			pozicija.add(k, drugi);
			k++;

		}

		int prviI = pozicija.get(0);
		int prviJ = pozicija.get(1);
		int drugiI = pozicija.get(2);
		int drugiJ = pozicija.get(3);

		// B je beli skakac i u odnosu na to cu znati kako se razlikuje od ostalih
		// (crnih skakaca)

		this.praznaTabla[prviI][prviJ] = 'B';
		this.praznaTabla[drugiI][drugiJ] = 'B';

	}

	public String kojaJeFiguricanaPoziciji(int pozicijaI , int pozicijaJ ) {

			String buki="";

				switch (pozicijaJ) {
				case 0:
					buki+="A";
					break;
				case 1:
					buki+="B";
					break;
				case 2:
					buki+="C";
					break;
				case 3:
					buki+="D";
					break;
				case 4:
					buki+="E";
					break;
				case 5:
					buki+="F";
					break;
				case 6:
					buki+="G";
					break;
				case 7:
					buki+="H";
					break;
				}
				switch (pozicijaI) {
				case 0:
					buki+="8";
					break;
				case 1:
					buki+="7";
					break;
				case 2:
					buki+="6";
					break;
				case 3:
					buki+="5";
					break;
				case 4:
					buki+="4";
					break;
				case 5:
					buki+="3";
					break;
				case 6:
					buki+="2";
					break;
				case 7:
					buki+="1";
					break;
				}
				
				
		
		return buki;

	}

	// konacna metoda u kojoj prolazim kroz tablu i u njoj na poziciji konja
	// koristim 2 niza koji mi kazu gde moze da ide i sta jede (AKO TU MOZE DA IDE)
	public void kogaJedeBeliKonj() {
		for (int i = 0; i < this.praznaTabla.length; i++) {
			for (int j = 0; j < this.praznaTabla[i].length; j++) {
				if (this.praznaTabla[i][j] == 'B') {
					System.out.println(" ");
					System.out.print("S("+kojaJeFiguricanaPoziciji(i, j)+"): ");
					
					int[] x = { 2, 1, -1, -2, -2, -1, 1, 2 };
					int[] y = { 1, 2, 2, 1, -1, -2, -2, -1 };

					for (int brojac = 0; brojac < 8; brojac++) {
						int pozicijaI = i + x[brojac];
						int pozicijaJ = j + y[brojac];

						if (pozicijaI < 8 && pozicijaI >= 0 && pozicijaJ < 8 && pozicijaJ >= 0) {

							if (praznaTabla[pozicijaI][pozicijaJ] != 'O')
								
								System.out.print(praznaTabla[pozicijaI][pozicijaJ] + "-" + kojaJeFiguricanaPoziciji(pozicijaI, pozicijaJ)+ " ");
								
						}

					}

				}
			}
		}

	}

	public String toString() {

		String bubu = "";

		for (int i = 0; i < this.praznaTabla.length; i++) {
			if (i > 0) {
				bubu += "\n";
			}
			for (int j = 0; j < this.praznaTabla[i].length; j++) {
				bubu += this.praznaTabla[i][j];
			}
		}
		return bubu;
	}
}
