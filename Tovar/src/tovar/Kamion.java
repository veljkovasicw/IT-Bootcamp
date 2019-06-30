package tovar;

import java.util.LinkedList;

public class Kamion {
private String regBroj;
private LinkedList<Tovar> tovar ;
private double nosivost;
private double teret;

public Kamion (String aRegBroj , double aNosivost) {
	regBroj=aRegBroj;
	nosivost=aNosivost;
	
}

public boolean stavi (Tovar t) {
	if(t.tezina()<nosivost) {
		tovar.add(t);
		teret += t.tezina();
		return true;
	} else
		return false;
}

public void skini() {
	teret -= tovar.getLast().tezina();
	tovar.removeLast();
}


public String toString () {
	String gg=regBroj +"("+teret +"/"+ nosivost +")\n";
	for (int i =0 ; i<tovar.size();i++) {
		gg+="("+tovar.get(i).toString()+")\n";
	}
	
	return gg;
}



}



