package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataAgence {

	private Connection con=null;
	private PreparedStatement st=null;
	private ResultSet rs=null;

	public DataAgence() {
		
    	try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banque","root","");
		}
		catch(ClassNotFoundException ex)
		{
			System.out.println("Probleme de pilote base de donnèes");
			System.out.println(ex.getMessage());
		}
		catch(SQLException ex)
		{
			System.out.println("Probleme de connexion ou de requetes");
			System.out.println(ex.getMessage());
		}
}
	
	
	public ArrayList<Agence> AfficheListe()
	{
		 ArrayList <Agence> liste=new ArrayList<Agence>();
		try
		{
			st=con.prepareStatement("select * from agence");
			rs=st.executeQuery();
			while(rs.next())
			{
				Agence a=new Agence();
				a.setLibelleAg(rs.getInt("LibelleAg"));
				a.setNomAg(rs.getString("NomAg"));
				a.setAdresseAg(rs.getString("AdresseAg"));
				
				liste.add(a);
				
			}
			
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return liste;
	}
	
	public void SupprimerAgence(int code)
	{
		try
		{
		st=con.prepareStatement("delete from agence where  LibelleAg=?");
		st.setInt(1,code);
		st.executeUpdate();
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		System.out.println("Agence "+ code+" supprimée");
	}
	

    public Agence RechercherAgence(int id)
	{
		Agence a=null;
		try
		{
			st=con.prepareStatement("select * from agence where LibelleAg=?");
			st.setInt(1,id);
			rs=st.executeQuery();
			if(rs.next())
			{
				 a=new Agence();
					a.setLibelleAg(rs.getInt("LibelleAg"));
					a.setNomAg(rs.getString("NomAg"));
					a.setAdresseAg(rs.getString("AdresseAg"));
				
				
			}
			
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return a;
	}
	public void AjouterAgence(Agence a)
	{
		try
		{
			st=con.prepareStatement("insert into agence(NomAg,AdresseAg) values (?,?)");
			
			st.setString(1, a.getNomAg());
			st.setString(2, a.getAdresseAg());
			st.executeUpdate();
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		
		System.out.println("L'agence "+a.getNomAg()+" est ajoutée");
	}

	public void ModifierAgence(Agence a, int code)
	{
		try
		{
			st=con.prepareStatement("update agence set NomAg=?,AdresseAg=?  where LibelleAg=?");
			
			st.setString(1, a.getNomAg());
			st.setString(2, a.getAdresseAg());
			st.setInt(3, code);
			
			st.executeUpdate();
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		System.out.println("Les infos de l'agence ont été modifiées");
	}
}
