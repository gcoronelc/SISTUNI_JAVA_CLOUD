package pe.eeob.Demo04.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import pe.eeob.Demo04.util.Memoria;

/**
 *
 * @author Gustavo Coronel
 */
public final class AccesoDB {
 
    static public String url = "jdbc:mysql://127.0.0.1:3306/app01";
    
    private AccesoDB() {
    }
  
  public static Connection getConnection() throws SQLException { 
    Connection cn = null; 
    try { 
      // Paso 1: Cargar el driver a memoria 
      Class.forName("com.mysql.jdbc.Driver").newInstance(); 
      // Paso 2: Obtener el objeto Connection 
//      String url = "jdbc:oracle:thin:@localhost:1521:XE"; 
      cn = DriverManager.getConnection(url, "adminhA48H4M", "QJkdDnnN49Gd"); 
        Memoria.setS1(url);
    } catch (SQLException e) { 
      throw e; 
    } catch (ClassNotFoundException e) { 
      throw new SQLException("No se encontró el driver de la base de datos."); 
    } catch (Exception e) { 
      throw new SQLException("No se puede establecer la conexión con la BD."); 
    } 
    return cn; 
  } 
  
  
}
