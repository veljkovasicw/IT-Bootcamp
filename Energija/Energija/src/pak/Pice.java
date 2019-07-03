package pak;

public class Pice extends Namirnice {

	private double kolicina;
	private double enerVr;

	public Pice(String aIme, double aKolicina, double aEnerVr) {
		super(aIme);

		ime = aIme;
		kolicina = aKolicina;
		enerVr = aEnerVr;

	}

	public double getKolicina() {
		return kolicina;
	}

	@Override
	public double energVr() {
		double vrednost = this.kolicina * this.enerVr;
		return vrednost;
	}

	public String toString() {
		String pp = super.toString() + "(" + this.kolicina+"l" + ", " + energVr() +" kJ"+ ")";
		return pp;
	}

}
