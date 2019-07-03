package pak;

public class Meni {
	private Namirnice[] niz;
	private int brNam;
	private int brPopunjenih;
	
	
	public Meni (int kapacitet) {
		brNam= kapacitet;
		 niz = new Namirnice[kapacitet];
		brPopunjenih=0;
		
	}
	
	// da li je ovo dobro !!!!(ova metoda koja vraca boolean)
	
	public boolean dodaj(Namirnice x) {
		
		if (brPopunjenih<niz.length) {
			niz[brPopunjenih] = x;
			brPopunjenih++;
			return true;
		}
		else return false;
		
	}
	
	
	
	
	public double enerVr() {
		
		double ukupnaENR=0;
		for(int i =0 ; i <brPopunjenih ; i++) {
			ukupnaENR+=niz[i].energVr();
		}
		return ukupnaENR;
	}
	
	// da li ovde dobro pozivam toString , mislim da ce mi pozvati toString iz Namirnica a ne iz hrana ili pice !!
	// mada opet ... Namirnice su apstraktna klasa i ne moze se napraviti objekat te klase pa se onda mozda ipak toString poziva iz pice ili hrana 
	
	public String toString () {
		String meni="Meni: " +"("+enerVr() +"kJ" + ")";
		for (int i =0 ; i <brPopunjenih ; i++) {
			meni+="\n ("+niz[i].toString() + ") ";
		}
		return meni;
	}
}
