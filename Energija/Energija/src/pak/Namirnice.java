package pak;

public abstract class Namirnice extends Energent {
	private static int idGlobal = 1;
	protected String ime;
	protected int id;

	public Namirnice(String aIme) {

		ime = aIme;
		id = idGlobal;
		idGlobal++;
	}

	public int getId() {
		return id;
	}

	public String getIme() {
		return ime;
	}

	public String toString() {
		String nn = "[" + id + "]" + ime;
		return nn;
	}

	abstract public double energVr();

}
