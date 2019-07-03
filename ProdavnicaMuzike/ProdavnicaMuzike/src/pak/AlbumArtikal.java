package pak;

public abstract class AlbumArtikal extends Artikal {
	
	private String izdavac;
	private Album album;
	public AlbumArtikal(Album aAlbum,String aIzdavac, Double aCena, int aKolicina) {
		super(aCena, aKolicina);
		this.izdavac = aIzdavac;
		this.album = aAlbum;
	}
	
	
	public Album getAlbum() {
		return album;
	}
	
	public abstract String ime();
	
	
	
	

}
