import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MenuViviendas {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/viviendas";
        String query, calle, titular;
        int nro, habitantes;
        Scanner scanner = new Scanner(System.in);
        int opt = 0;
        try (Connection conexion = DriverManager.getConnection(url, "SNCHZF", "252625")){
            System.out.println("Conexión: OK");
            do {
                System.out.println("-----Menu de BD para viviendas-----");
                System.out.println("1- Agregar una vivienda");
                System.out.println("2- Borrar una vivienda (por calle)");
                System.out.println("3- Actualizar una vivienda");
                System.out.println("4- Buscar una vivienda");
                System.out.println("5- Mostrar todas las viviendas");
                System.out.println("0- Cerrar el menú");
                System.out.print("Elija una opción: ");
                opt = scanner.nextInt();
                scanner.nextLine();
                switch (opt) {
                    case 1:

                        System.out.print("\nIngrese la calle de la vivienda: ");
                        calle = scanner.nextLine();
                        System.out.print("Ingrese el número de la vivienda: ");
                        nro = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Ingrese el nombre del titular de la vivienda: ");
                        titular = scanner.nextLine();
                        System.out.print("Ingrese el número de habitantes en la vivienda: ");
                        habitantes = scanner.nextInt();

                        query = String.format("INSERT INTO VIVIENDAS (calle, nro, titular, habitantes)"+
                        "VALUES('%s', %d, '%s', %d)", 
                        calle,
                        nro,
                        titular,
                        habitantes
                        );

                        Statement statement = conexion.createStatement();
                        int tablasMod = statement.executeUpdate(query);

                        if(tablasMod == 0){
                            System.out.println("¡Error a la hora de añadir la vivienda!");
                        } else {
                            System.out.println("¡Vivienda añadida correctamente!");
                        }

                        statement.close();
                        scanner.nextLine();
                        break;
                    case 2:

                        System.out.print("\nIngrese la calle de la vivienda que quiere eliminar: ");
                        calle = scanner.nextLine();
                        System.out.print("Ingrese el número de la calle que quiere eliminar");
                        nro = scanner.nextInt();

                        query = String.format("DELETE FROM viviendas WHERE calle = '%s' AND nro = %d", 
                        calle, nro);

                        statement = conexion.createStatement();
                        tablasMod = statement.executeUpdate(query);

                        if(tablasMod == 0){
                            System.out.println("¡Error a la hora de eliminar la vivienda!");
                        } else {
                            System.out.println("¡Vivienda eliminada correctamente!");
                        }

                        statement.close();
                        scanner.nextLine();
                        break;
                    case 3:

                        System.out.print("\nIngrese la calle de la vivienda: ");
                        calle = scanner.nextLine();
                        System.out.print("\nIngrese el número de la vivienda: ");
                        nro = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Ingrese la nueva calle: ");
                        String calleAux = scanner.nextLine();
                        System.out.print("Ingrese el nuevo número de la vivienda: ");
                        int nroAux = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("\nIngrese el nuevo nombre del titular de la vivienda: ");
                        titular = scanner.nextLine();
                        System.out.print("\nIngrese el nuevo número de habitantes en la vivienda: ");
                        habitantes = scanner.nextInt();

                        query = String.format( "UPDATE viviendas SET calle='%s', nro=%d, titular='%s', habitantes=%d " +
                        "WHERE calle='%s' AND nro=%d",
                        calleAux,
                        nroAux,
                        titular,
                        habitantes,
                        calle,
                        nro
                        );

                        statement = conexion.createStatement();
                        tablasMod = statement.executeUpdate(query);

                        if(tablasMod == 0){
                            System.out.println("¡Error a la hora de actualizar la vivienda!");
                        } else {
                            System.out.println("¡Vivienda actualizada correctamente!");
                        }

                        statement.close();
                        scanner.nextLine();
                        break;
                    case 4:

                        System.out.print("\nIngrese la calle de la vivienda: ");
                        calle = scanner.nextLine();
                        System.out.print("\nIngrese el número de la vivienda: ");
                        nro = scanner.nextInt();
                        titular = null;
                        habitantes = 0;

                        query = String.format("SELECT * FROM viviendas " +
                        "WHERE calle='%s' AND nro=%d",
                        calle,
                        nro
                        );

                        statement = conexion.createStatement();
                        ResultSet tabla = statement.executeQuery(query);

                        while(tabla.next()){
                            calle = tabla.getString(2);
                            nro = tabla.getInt(3);
                            titular = tabla.getString(4);
                            habitantes = tabla.getInt(5);
                            String msg = String.format(
                                "\n---Datos de la vivienda---\n" +
                                "Calle: %s\n" +
                                "Número: %d\n" +
                                "Titular: %s\n" +
                                "Habitantes %d\n" 
                            , calle, nro, titular, habitantes);
                            System.out.println(msg);
                        }
                        statement.close();
                        scanner.nextLine();
                        break;
                    case 5:

                        query = "SELECT * FROM viviendas";
                        statement = conexion.createStatement();

                        tabla = statement.executeQuery(query);

                        while(tabla.next()){
                            int id = tabla.getInt(1);
                            calle = tabla.getString(2);
                            nro = tabla.getInt(3);
                            titular = tabla.getString(4);
                            habitantes = tabla.getInt(5);
                            String msg = String.format(
                                "\n---Datos de la vivienda---\n" +
                                "ID: %d\n" +
                                "Calle: %s\n" +
                                "Número: %d\n" +
                                "Titular: %s\n" +
                                "Habitantes %d" 
                            , id, calle, nro, titular, habitantes);
                            System.out.println(msg);
                        }

                        statement.close();
                        scanner.nextLine();
                        break;
                    case 0:
                        conexion.close();
                        break;
                    default:
                        System.out.println("¡Ingrese una opción correcta!");
                        scanner.nextLine();
                        break;
                }
            } while (opt != 0);
        } catch (SQLException e) {
            System.out.println("Conexión fallida: " + e.getMessage());
        } catch (Exception e){
            System.out.println(e);
        }
    }

}
