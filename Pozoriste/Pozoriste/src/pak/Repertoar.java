package pak;

import java.util.LinkedList;

public class Repertoar {

	private Pozoriste pozoriste;
	private LinkedList<Predstava> predstave;

	public Repertoar(Pozoriste aPozoriste) {
		pozoriste = aPozoriste;
		predstave = new LinkedList<Predstava>();

	}

	public void dodaj(Predstava p) {

		predstave.add(p);

	}

	public void ukloni (String imePredstave) {
		
		
		for (int i =0; i<predstave.size(); i++) {
		if (predstave.get(i).getNaziv().equalsIgnoreCase(imePredstave)) {
			predstave.remove(i);
		}
		}
		}

	public String toString() {
		String bb=""+pozoriste.getNaziv()+ ": (";
		for (int i =0 ; i<predstave.size(); i ++) {
			bb+=predstave.toString()+")\n ";
			
				
		}
		return bb;
		 
		
		
	}

}
