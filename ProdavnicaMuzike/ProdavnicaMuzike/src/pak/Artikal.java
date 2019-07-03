package pak;

public abstract class Artikal {

	public static int globalID = 1;
	private int id;
	private double cena;
	private int kolicina;
	private AlbumArtikal aa;

	public Artikal(Double aCena, int aKolicina) {
		cena = aCena;
		kolicina = aKolicina;
		id = globalID;
		globalID++;
	}

	public double getCena() {
		return cena;
	}

	public int getKolicina() {

		return kolicina;
	}

	public boolean kupi() {
		if(kolicina!=0) {
			kolicina--;
			return true;
			}
		else return false;
	}
	
	public  int getId() {
		return id;
	}
	
	public AlbumArtikal getAlbumArtikal() {
		return aa;
	}
	
	public abstract String ime();
	
	public String toString () {
		
		
		String bubu= "#" + id+ ": "+ ime() + "-"+ cena +"["+"kol: " + kolicina +"]" ;
		return bubu;
	}
	
	
	

}
