package muzika;

public class CD extends AlbumArtikal {

	public CD(Album aAlbum,String aIzdavac, Double aCena, int aKolicina ) {
		super(aAlbum,aIzdavac,aCena, aKolicina );
	}

	@Override
	public String ime() {
		String loveMe= getAlbum().getIzvodjac()+" " +getAlbum().getNaziv() + "(CD)" ;
		return loveMe;
	}
	
	
	
	
	

}
