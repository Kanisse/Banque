package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataClients {
	
	private Connection con=null;
	private PreparedStatement st=null;
	private ResultSet rs=null;
	
public DataClients() {
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


public ArrayList<Clients> AfficheListe(int id)
{
	 ArrayList <Clients> liste=new ArrayList<Clients>();
	try
	{
		st=con.prepareStatement("select * from client where Id_Agence="+id);
		rs=st.executeQuery();
		while(rs.next())
		{
			Clients c=new Clients();
			c.setId_Client(rs.getInt("NumCl"));
			c.setNom_Client(rs.getString("Nom"));
			c.setPrenom_Client(rs.getString("Prenom"));
			c.setAdresse(rs.getString("Adresse"));
			
			liste.add(c);
			
		}
		
	}
	catch(SQLException ex)
	{
		System.out.println(ex.getMessage());
	}
	return liste;
}


}
