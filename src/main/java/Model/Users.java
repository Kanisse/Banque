package Model;

public class Users {
	
	private int Id;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	private String NomPrenomUsers;
	private String UtilisateurUsers;
	private String MpasseUsers;
	
	
	public String getMpasseUsers() {
		return MpasseUsers;
	}
	public void setMpasseUsers(String mpasseUsers) {
		MpasseUsers = mpasseUsers;
	}
	public String getNomPrenomUsers() {
		return NomPrenomUsers;
	}
	public void setNomPrenomUsers(String nomPrenomUsers) {
		NomPrenomUsers = nomPrenomUsers;
	}
	public String getUtilisateurUsers() {
		return UtilisateurUsers;
	}
	public void setUtilisateurUsers(String utilisateurUsers) {
		UtilisateurUsers = utilisateurUsers;
	}
	
	
	

}
