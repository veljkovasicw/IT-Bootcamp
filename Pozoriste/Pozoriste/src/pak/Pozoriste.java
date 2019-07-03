package pak;

public class Pozoriste {

	private static int idGlobal = 1;
	private int id;
	private String naziv;

	public Pozoriste(String aNaziv) {
		naziv = aNaziv;

		id = idGlobal;
		idGlobal++;

	}

	public int getId() {
		return id;
	}

	public String getNaziv() {
		
		return naziv;
	}

	public String getSkraceniNaziv() {
		String temp = naziv;

		String[] delovi = temp.split(" ");

		String skr = "";
		for (int i = 0; i > delovi.length; i++) {

			skr += delovi[i].charAt(0) + " ";

		}
		skr.toUpperCase();
		
		return skr;
	}
	public String toString() {
		String kre = naziv + "[ "+ id+"]";
		return kre;
	}
	
	
}