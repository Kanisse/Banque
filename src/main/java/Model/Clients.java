package Model;

public class Clients {
	
	private int Id_Client;
	private String  Nom_Client;
	private String Prenom_Client;
	private String Adresse;
	
	public int getId_Client() {
		return Id_Client;
	}
	public void setId_Client(int id_Client) {
		Id_Client = id_Client;
	}
	public String getNom_Client() {
		return Nom_Client;
	}
	public void setNom_Client(String nom_Client) {
		Nom_Client = nom_Client;
	}
	public String getPrenom_Client() {
		return Prenom_Client;
	}
	public void setPrenom_Client(String prenom_Client) {
		Prenom_Client = prenom_Client;
	}
	public String getAdresse() {
		return Adresse;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	
	

}
