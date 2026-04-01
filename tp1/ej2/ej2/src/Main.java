import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost/banco";
        Scanner scanner = new Scanner(System.in);
        int opt = 0;

        try (Connection conexion = DriverManager.getConnection(url, "SNCHZF", "252625")){
            System.out.println("Conexión: OK");
            do {
                System.out.println("\n----- Menú BD Banco -----");
                System.out.println("1- Crear cuenta");
                System.out.println("2- Depositar");
                System.out.println("3- Extraer");
                System.out.println("4- Consultar saldo");
                System.out.println("0- Salir");
                System.out.print("Opción: ");
                opt = scanner.nextInt();

                switch (opt) {
                    case 1:
                        System.out.print("N° de cuenta: ");
                        int cuenta = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nombre del cliente: ");
                        String nombre = scanner.nextLine();
                        double saldo = 0;
                        System.out.print("Tipo cuenta (A/C): ");
                        char tipo = scanner.next().charAt(0);

                        String query = "INSERT INTO CUENTAS (Cuenta, NombreCliente, Saldo, TipoCuenta) VALUES (?, ?, ?, ?)";;
                        PreparedStatement ps = conexion.prepareStatement(query);

                        ps.setInt(1, cuenta);
                        ps.setString(2, nombre);
                        ps.setDouble(3, saldo);
                        ps.setString(4, String.valueOf(tipo));

                        int tablasMod = ps.executeUpdate();

                        if(tablasMod == 0){
                            System.out.println("¡Error a la hora de añadir la vivienda!");
                        } else {
                            System.out.println("¡Vivienda añadida correctamente!");
                        }
                        System.out.println("Cuenta creada correctamente");

                        ps.close();
                        break;
                    case 2:
                        System.out.print("N° cuenta: ");
                        cuenta = scanner.nextInt();

                        System.out.print("Importe de la transacción: ");
                        double importe = scanner.nextDouble();

                        try {
                            conexion.setAutoCommit(false);

                            //Verificar cuenta
                            PreparedStatement ps1 = conexion.prepareStatement(
                                    "SELECT Saldo FROM CUENTAS WHERE Cuenta=?");
                            ps1.setInt(1, cuenta);
                            ResultSet rs = ps1.executeQuery();

                            if (!rs.next()) {
                                System.out.println("La cuenta no existe");
                                conexion.rollback();
                                break;
                            }

                            //Insertar movimiento
                            PreparedStatement ps2 = conexion.prepareStatement(
                                    "INSERT INTO MOVIMIENTOS (Cuenta, Mov, Importe) VALUES (?, 'D', ?)");
                            ps2.setInt(1, cuenta);
                            ps2.setDouble(2, importe);
                            ps2.executeUpdate();

                            //Actualizar saldo
                            PreparedStatement ps3 = conexion.prepareStatement(
                                    "UPDATE CUENTAS SET Saldo = Saldo + ? WHERE Cuenta=?");
                            ps3.setDouble(1, importe);
                            ps3.setInt(2, cuenta);
                            ps3.executeUpdate();

                            conexion.commit();
                            System.out.println("Depósito realizado correctamente");

                        } catch (SQLException e) {
                            conexion.rollback();
                            System.out.println("Error en depósito");
                        } finally {
                            conexion.setAutoCommit(true);
                        }
                        break;
                    case 3:
                        System.out.print("N° cuenta: ");
                        cuenta = scanner.nextInt();

                        System.out.print("Importe: ");
                        importe = scanner.nextDouble();

                        try {
                            conexion.setAutoCommit(false);

                            PreparedStatement ps1 = conexion.prepareStatement(
                                    "SELECT Saldo FROM CUENTAS WHERE Cuenta=?");
                            ps1.setInt(1, cuenta);
                            ResultSet rs = ps1.executeQuery();

                            if (!rs.next()) {
                                System.out.println("La cuenta no existe");
                                conexion.rollback();
                                break;
                            }

                            double saldoActual = rs.getDouble("Saldo");

                            if (importe > saldoActual) {
                                System.out.println("Saldo insuficiente");
                                conexion.rollback();
                                break;
                            }

                            // Insertar movimiento
                            PreparedStatement ps2 = conexion.prepareStatement(
                                    "INSERT INTO MOVIMIENTOS (Cuenta, Mov, Importe) VALUES (?, 'E', ?)");
                            ps2.setInt(1, cuenta);
                            ps2.setDouble(2, importe);
                            ps2.executeUpdate();

                            // Actualizar saldo
                            PreparedStatement ps3 = conexion.prepareStatement(
                                    "UPDATE CUENTAS SET Saldo = Saldo - ? WHERE Cuenta=?");
                            ps3.setDouble(1, importe);
                            ps3.setInt(2, cuenta);
                            ps3.executeUpdate();

                            conexion.commit();
                            System.out.println("Extracción realizada correctamente");

                        } catch (SQLException e) {
                            conexion.rollback();
                            System.out.println("Error en extracción");
                        } finally {
                            conexion.setAutoCommit(true);
                        }
                        break;
                    case 4:
                        System.out.print("N° cuenta: ");
                        cuenta = scanner.nextInt();

                        ps = conexion.prepareStatement(
                                "SELECT * FROM CUENTAS WHERE Cuenta=?");
                        ps.setInt(1, cuenta);

                        ResultSet rs = ps.executeQuery();

                        if (rs.next()) {
                            System.out.println("\n--- Datos ---");
                            System.out.println("Cliente: " + rs.getString("NombreCliente"));
                            System.out.println("Saldo: " + rs.getDouble("Saldo"));
                            System.out.println("Tipo: " + rs.getString("TipoCuenta"));
                        } else {
                            System.out.println("Cuenta no encontrada");
                        }

                        ps.close();
                        break;
                    case 0:
                        conexion.close();
                        break;
                    default:
                        break;
                }
            } while (opt != 0);
        } catch (SQLException e) {
            System.out.println("Conexión fallida: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
