package pak;

import java.util.LinkedList;

public class Predstava {

	private String naziv;
	private Pozoriste pozoriste;
	private LinkedList<Zaposleni> zaposleni;

	public Predstava(String aNaziv, Pozoriste aPozoriste, Reditelj aReditelj) {

		naziv = aNaziv;
		this.pozoriste = aPozoriste;

		zaposleni = new LinkedList<Zaposleni>();

		zaposleni.add(aReditelj);

	}

	public String getNaziv() {
		return naziv;
	}

	public Pozoriste getPozoriste() {
		return pozoriste;
	}

	private int brojKostimografa() {
		int brKostimografa = 0;

		for (int i = 0; i < zaposleni.size(); i++) {
			if (zaposleni.get(i).imePosla().equalsIgnoreCase("Kostimograf")) {
				brKostimografa++;
			}
		}
		return brKostimografa;

	}

	public boolean dodaj(Zaposleni z) {

		if (z.getPozoriste() != this.pozoriste) {
			return false;
		}

		if (z.imePosla().equalsIgnoreCase("Reditelj")) {
			return false;
		}

		int brojK = brojKostimografa();
		if (brojK == 2 && z.imePosla().equalsIgnoreCase("Kostimograf")) {

			return false;
		}

		zaposleni.add(z);
		return true;

	}

	public String toString() {
		String pp="";
		pp+=getNaziv()+":" + "\n\t "+"(" ;
		for (int i =0 ; i <zaposleni.size(); i++) {
			pp+=zaposleni.get(i).getIme()+"\n\t";
		}
		return pp;
	}
}
