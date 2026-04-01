import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args){
        try {
            String url, login, password;
            url = "jdbc:mysql://localhost/viviendas";
            login = "root";
            password = "252625";
            //Crear el objeto de conexion a la base de datos
            Connection conexion= DriverManager.getConnection(url, login, password);

            String calle = "a";
            int nro = 1;
            String titular = "a";
            int habitantes = 2;
            String query = String.format("INSERT INTO VIVIENDAS (calle, nro, titular, habitantes)"+
                        "VALUES('%s', %d, '%s', %d)", 
                        calle,
                        nro,
                        titular,
                        habitantes
                        );
            Statement statement = conexion.createStatement();
            statement.executeUpdate(query);

            //Crear objeto Statement para realizar operaciones con la base datos
            Statement sentencia= conexion.createStatement();
            //Un objeto ResultSet, almacena los datos de resultados de una consulta
            int createTabla = sentencia.executeUpdate(query);
            System.out.println(createTabla);
            System.out.println("Codigo\tNombre");
            conexion.close();
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e);}
    }
}
