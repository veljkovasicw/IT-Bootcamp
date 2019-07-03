package pak;

public class Hrana extends Namirnice {

	private double tezina;
	private double belancevine;
	private double masti;
	private double ugljHidrati;

	public Hrana(String aIme, double aTezina, double aBelancevine, double aMasti, double aUgljHridrati) {
		super(aIme);
		ime = aIme;
		tezina = aTezina;
		belancevine = aBelancevine;
		masti = aMasti;
		ugljHidrati = aUgljHridrati;

	}

	public double getTezina() {
		return tezina;
	}

	public double getBelancevine() {
		return belancevine;
	}

	public double getMasti() {
		return masti;
	}

	public double getUgljHidrati() {
		return ugljHidrati;
	}

	public double procentiUGrame(double tez, double procenti) {

		double grami = (tez * procenti) / 100;
		return grami;

	}

	@Override
	public double energVr() {

		double b = procentiUGrame(this.tezina, belancevine) * 16.7;
		double m = procentiUGrame(this.tezina, masti) * 37.6;
		double u = procentiUGrame(this.tezina, ugljHidrati) * 17.2;
		double engVr = b + m + u;
		return engVr;

	}

	public String toString() {

		String hran = super.toString() + "(" + tezina +"g"+ ", " + energVr()+" kJ" + ")";

		return hran;
	}

}
