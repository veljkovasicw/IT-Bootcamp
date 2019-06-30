package muzika;

public class LP extends AlbumArtikal {
	
	private int tezina;

	public LP(Album aAlbum ,String aIzdavac,  Double aCena, int aKolicina,int tezina) {
		super(aAlbum,aIzdavac, aCena, aKolicina );
		this.tezina = tezina;
	}

	@Override
	public String ime() {
		String keke= getAlbum().getIzvodjac()+"-" +getAlbum().getNaziv() +"("+tezina+"[g] LP)" ;
		return keke;
	}
	
	

}
