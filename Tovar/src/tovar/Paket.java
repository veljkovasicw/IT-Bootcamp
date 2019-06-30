package tovar;

import java.util.LinkedList;

public class Paket extends Tovar {

	
	
	protected LinkedList<Tovar> tovar=new LinkedList<Tovar>();
	
	
	
	
	@Override
	public String vrsta() {
		String bb="paket [";
		for (int i =0 ; i<tovar.size(); i++) {
			bb+="("+tovar.get(i)+")";
			
		}
		bb+="]";
		return bb;
		
	}

	@Override
	public double tezina() {
		double tez = 0;
		for (Tovar t : tovar) tez+=t.tezina();
		return tez;
	}
	
	public void dodaj(Tovar tov) {
		tovar.add(tov);
	}

}
