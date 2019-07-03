package pak;

import java.io.*;

public class Main {

	public static void main(String[] args) {

		Tabla bela= new Tabla();
		
		Tabla crna = new Tabla();
	
		bela.ispisivanjeBelihFiguricaNaMatricu();
						
		crna.ispisivanjeCrnihhFiguricaNaMatricu();
		
		
		
		crna.ubaciBelogKonjaUCrnaPolja(bela.nadjiPozicijeKonja());
		
		
		
		crna.kogaJedeBeliKonj();
	
		
		
	}

}
