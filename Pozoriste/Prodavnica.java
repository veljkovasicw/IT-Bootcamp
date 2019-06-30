package muzika;

import java.util.LinkedList;

public class Prodavnica {

	private String ime;
	private String lokacija;
	private LinkedList<Artikal> inventar;

	public Prodavnica(String aIme, String aLokacija) {

		ime = aIme;
		lokacija = aLokacija;
		inventar = new LinkedList<Artikal>();
	}

	public LinkedList<Artikal> pretrazi(String aTekst) {

		LinkedList<Artikal> noviInventar = new LinkedList<Artikal>();

		for (int i = 0; i < inventar.size(); i++) {
			if (inventar.get(i).ime().toLowerCase().contains(aTekst.toLowerCase())){

				noviInventar.add(inventar.get(i));

			}

		}
		return noviInventar;

	}

	public void dodaj(Artikal aArtikal) {
		inventar.add(aArtikal);
	}

	public String getIme() {
		return ime;
	}

	public String getLokacija() {
		return lokacija;
	}

	public String toString() {
		String prodaja;
		prodaja = "" + ime + ": " + lokacija;
		for (int i = 0; i < inventar.size(); i++) {

			prodaja += "\n\t" +inventar.get(i);

		}
		return prodaja;

	}

}
