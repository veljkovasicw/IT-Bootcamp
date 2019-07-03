package pak;

public class Numera {

	private String naziv;
	private String izvodjac;
	private String trajanje;
	
	public Numera(String anaziv, String aizvodjac , String atrajanje) {
		naziv=anaziv;
		izvodjac=aizvodjac;
		trajanje=atrajanje;
			}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getIzvodjac() {
		return izvodjac;
	}

	public void setIzvodjac(String izvodjac) {
		this.izvodjac = izvodjac;
	}

	public String getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(String trajanje) {
		this.trajanje = trajanje;
	}
	
	public String toString() {
		String s=izvodjac + "  - "+naziv +":" + trajanje;
		return s;
		
	}
	
	
}