package pak;

public class Reditelj extends Zaposleni  {

	public Reditelj(String aIme, Pozoriste aPozoriste) {
		super(aIme, aPozoriste);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String imePosla() {
		String imePosla="Reditelj";
		return imePosla;
	}
	
	

}