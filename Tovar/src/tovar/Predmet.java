package tovar;

public class Predmet extends Tovar {
	
	private String vrsta;
	private double tezina;
	
	public Predmet (String aVrsta , double aTezina) {
		
		
		vrsta=aVrsta;
		tezina=aTezina;
		
	}

	@Override
	public String vrsta() {
		return vrsta;
	}

	@Override
	public double tezina() {
		return tezina;
	}

	

}
