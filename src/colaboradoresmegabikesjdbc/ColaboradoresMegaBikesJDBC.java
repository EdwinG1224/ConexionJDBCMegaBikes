/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package colaboradoresmegabikesjdbc;

/**
 *
 * @author Edwin
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ColaboradoresMegaBikesJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/colaboradoresmegabikes";
        Connection conexion;
        Statement statement;
        ResultSet rs;              
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ColaboradoresMegaBikesJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conexion = DriverManager.getConnection(url,usuario,password);
            
            statement = conexion.createStatement();
            statement.executeUpdate("INSERT INTO COLABORADORES(NOMBRE,APELLIDO,TELEFONO) VALUES('ABC', 'CBA','123')");
            rs = statement.executeQuery("SELECT * FROM COLABORADORES");
            rs.next();
            do{
                 System.out.println(rs.getInt("idempleado")+" : "+rs.getString("Nombre")+" : "+rs.getString("Apellido")+" : "+rs.getString("Telefono"));
            }while(rs.next());
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ColaboradoresMegaBikesJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
