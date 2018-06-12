package puntopixel;

import java.sql.*;

import javax.swing.JOptionPane;

public class Conexion{

    public String db = "posiciones";
    public String url = "jdbc:mysql://localhost/"+db;
    public String user = "root";
    public String pass = "php123";

    Connection link;

    public Connection Conectar(){

        

        try{

            Class.forName("org.gjt.mm.mysql.Driver");

            link = DriverManager.getConnection(this.url, this.user, this.pass);

        }catch(Exception ex){

            JOptionPane.showMessageDialog(null, ex);

        }

        return link;
    }
    
 public int  insertarPos(String posX, String posY, String color) {
    	
    	int numRegistros = 0;
    	
    	try {
    	PreparedStatement stInsertar = link.prepareStatement("insert into datos(posx, posy, color)" + "values(?,?,?)");
    	stInsertar.setString(1, posX);
    	stInsertar.setString(2, posY);
    	stInsertar.setString(3, color);
    	
    	numRegistros = stInsertar.executeUpdate();
    	
    	stInsertar.close();
    	
    	}catch(SQLException e) {
    		 	e.printStackTrace();
    		}
		return numRegistros;
    	
    	
    }
 }
