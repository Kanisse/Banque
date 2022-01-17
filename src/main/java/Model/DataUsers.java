package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataUsers {


		private Connection con=null;
		private PreparedStatement st=null;
		private ResultSet rs=null;

		public DataUsers() {
			
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
	
	
		public ArrayList<Users> RechercheUser(String user, String passe)
		{
			 ArrayList <Users> liste=new ArrayList<Users>();
			try
			{
		st=con.prepareStatement("select * from login where Login_Users=? and Pass_Users=?");
		st.setString(1,user);
		st.setString(2, passe);
			
				rs=st.executeQuery();
				while(rs.next())
				{
					Users l=new Users();
					
					l.setId(rs.getInt("Id_Users"));
					l.setNomPrenomUsers(rs.getString("Nom_Users"));
					l.setUtilisateurUsers(rs.getString("Login_Users"));
					l.setMpasseUsers(rs.getString("Pass_Users"));
					liste.add(l);
					
				}
				
			}
			catch(SQLException ex)
			{
				System.out.println(ex.getMessage());
			}
			return liste;
		}
	

}
