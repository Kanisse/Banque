package Model;

public class Agence {

	private int LibelleAg;
	private String NomAg;
	private String AdresseAg;
	
	public int getLibelleAg() {
		return LibelleAg;
	}
	public void setLibelleAg(int libelleAg) {
		LibelleAg = libelleAg;
	}
	public String getNomAg() {
		return NomAg;
	}
	public Agence() {
		
	}
	public Agence(String nomAg, String adresseAg) {
		
		NomAg = nomAg;
		AdresseAg = adresseAg;
	}
	public void setNomAg(String nomAg) {
		NomAg = nomAg;
	}
	public String getAdresseAg() {
		return AdresseAg;
	}
	public void setAdresseAg(String adresseAg) {
		AdresseAg = adresseAg;
	}
	
	
	
	
	
	
	
	
}
