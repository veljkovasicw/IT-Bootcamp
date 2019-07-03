package pak;


public abstract class Zaposleni {
	
	private String ime ;
	private Pozoriste pozoriste;
	
	public Zaposleni (String aIme , Pozoriste aPozoriste) {
	
	ime = aIme;
	pozoriste=aPozoriste;
	}
	
	
	public abstract String imePosla();
	
	public String getIme() {
		return ime;
	}
	public Pozoriste getPozoriste() {
		return pozoriste;
		
	}
	
	
	
	public String toString () {
		String ss="";
		ss+=ime + "(" + imePosla() +" " + pozoriste.getSkraceniNaziv() + ")" ;
		return ss;
		
	}
	
	
}