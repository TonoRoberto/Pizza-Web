import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.*;
public class Controller {
	
	public static Connection getConnection() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
		
		 String tempDbPath = System.getenv("TEMP").replace('\\', '/') + "/" + "PizzaWeb.accdb"; 
		 
		 
		 InputStream strmIn = Controller.class.getResourceAsStream("PizzaWeb.accdb");
	     File f = new File(tempDbPath);
	     System.out.println("3");
	     
	     
	     try {	    	 
	            Files.copy(strmIn, f.toPath(), StandardCopyOption.REPLACE_EXISTING);
	           
	        } catch (IOException e) {
	            e.printStackTrace();
	     }
	     
	     
	     	
	     
	     String username = ""; //leave blank if none
	     String password = ""; //leave blank if none
	     
	     try {
	    	 
	      //Class.forName(driver);
	      Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	     } catch (ClassNotFoundException e) {
	      e.printStackTrace();
	     }
	     
	     String url1 =  "jdbc:ucanaccess://"+tempDbPath;	     
	     
	     try {
	    	 return DriverManager.getConnection(url1, username, password);
	     } catch (SQLException e) {
	      // TODO Auto-generated catch block
	      
	    	 System.out.println("err");
		   	    
	    	 e.printStackTrace();
	     }
	     return null;
	}
	
	
	
	static int numberOfColumns=0;
	static int numberOfColumns2=0;
	static int numberOfColumns3=0;
	static List<String> pizze=new ArrayList<>();
	static List<String> premi=new ArrayList<>();
	static List<String> disponibilita=new ArrayList<>();
	
	
	public static void main(String args[]){
			
		
		try {
			  Connection conn = getConnection();
			  
			  
			     Statement st = conn.createStatement();
			     st = conn.createStatement();
			     
			     //QUERY
			     //visualizza il menu
			     ResultSet rsPizza = st.executeQuery("SELECT Ingredienti FROM Pizza");     
			     //visualizza i premi		     
			     ResultSet rsPremio = st.executeQuery("SELECT Nome FROM Premio");     
			     //visualizza la disponibilità dei portapizze
			     ResultSet rsPortaPizze = st.executeQuery("SELECT Libero FROM Facchino");     

			     
			     
			     
			     List<String> colonne=new ArrayList<>();
			     List<String> colonne2=new ArrayList<>();
			     List<String> colonne3=new ArrayList<>();
			     
			     //get and displays the number of columns
			     ResultSetMetaData rsMetaData = rsPizza.getMetaData();
			     ResultSetMetaData rsMetaData2 = rsPremio.getMetaData();
			     ResultSetMetaData rsMetaData3 = rsPortaPizze.getMetaData();
			     
			     numberOfColumns = rsMetaData.getColumnCount();
			     numberOfColumns2 = rsMetaData2.getColumnCount();
			     numberOfColumns3 = rsMetaData3.getColumnCount();
			     System.out.println("resultSet MetaData column Count=" + numberOfColumns);
			     
			     //visualizzo i campi della tabella
			     for(int i=1;i<=numberOfColumns;i++){
			     	System.out.println("\n"+ rsMetaData.getColumnLabel(i) +"\n");
			     	colonne.add(rsMetaData.getColumnLabel(i));
			     }
			     
			     //visualizzo i campi della tabella
			     for(int i=1;i<=numberOfColumns2;i++){
			     	System.out.println("\n"+ rsMetaData2.getColumnLabel(i) +"\n");
			     	colonne2.add(rsMetaData2.getColumnLabel(i));
			     }
			     
			     //visualizzo i campi della tabella
			     for(int i=1;i<=numberOfColumns3;i++){
			     	System.out.println("\n"+ rsMetaData3.getColumnLabel(i) +"\n");
			     	colonne3.add(rsMetaData3.getColumnLabel(i));
			     }
			     //visualizzo i valori dei campi della tabella     
			     
			     //PRENDO I NOMI DELLE PIZZE
			     while (rsPizza.next()) //per passare alla prossima riga

			     {
			    	 colonne.forEach(c->{
			    		 
			    		  
			    		  String x="";
						try {
							x = rsPizza.getString(c);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} // o int x = rs.getInt(1);
				          System.out.println("   "+x);
				          
				          	pizze.add(x);
				    		 
				    		
			    	 });
				         
				       //String s = rs.getString("b"); //o String s = rs.getString(2);

			          //float f = rs.getFloat("c"); //o float f = rs.getFloat(3);
			     }
			     
			     //PRENDO I NOMI DEI PREMI
			     while (rsPremio.next()) //per passare alla prossima riga

			     {
			    	 colonne2.forEach(c->{
			    		 
			    		  
			    		  String x="";
						try {
							x = rsPremio.getString(c);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} // o int x = rs.getInt(1);
				          System.out.println("   "+x);
				          
				          	premi.add(x);
				    		 
				    		
			    	 });
				         
				       //String s = rs.getString("b"); //o String s = rs.getString(2);

			          //float f = rs.getFloat("c"); //o float f = rs.getFloat(3);
			     }
			     
			     //visualizzo le disponibilita dei portapizze
			     while (rsPortaPizze.next()) //per passare alla prossima riga

			     {
			    	 colonne3.forEach(c->{
			    		 
			    		  
			    		  String x="";
						try {
							x = rsPortaPizze.getString(c);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} // o int x = rs.getInt(1);
				          System.out.println("   "+x);
				          
				          	disponibilita.add(x);
				    		 
				    		
			    	 });
				         
				       //String s = rs.getString("b"); //o String s = rs.getString(2);

			          //float f = rs.getFloat("c"); //o float f = rs.getFloat(3);
			     }
			     st.close();
			     conn.close();
		} 
		catch(Exception e) {
			  System.out.println(e.getMessage());
		}
		 
		
		
		
		
		/*VIEW */
		Map<Integer,List<String>> map=new HashMap<>();
		map.put(0, pizze);
		System.out.println(pizze);
		map.put(1, premi);
		Login login = new Login(map);
		
	}
	
	

}
