import java.util.Scanner;

import org.json.simple.JSONArray;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opt = 0;
        do {
            JSONArray viviendasArray = JSONManager.readJSON();
            System.out.println("---- Menú de viviendas ----");
            System.out.println("1- Agregar viviendas");
            System.out.println("2- Actualizar vivienda por ID");
            System.out.println("3- Eliminar vivienda por ID");
            System.out.println("4- Buscar viviendas por calle");
            System.out.println("5- Buscar viviendas por titular");
            System.out.println("6- Mostrar cantidad de viviendas");
            System.out.println("7- Mostrar promedio de habitantes de las viviendas");
            System.out.print("Elija una opción: ");
            opt = scanner.nextInt();
            scanner.nextLine();
            switch (opt) {
                case 1:
                    ViviendaManager.addVivienda(viviendasArray, scanner);
                    JSONManager.writeJSON(viviendasArray);
                    break;
                case 2:
                    System.out.print("Ingrese el id de la vivienda que quiere modificar: ");
                    int id = scanner.nextInt();
                    boolean exists = ViviendaManager.idExists(viviendasArray, id);
                    if(!exists){
                        System.out.println("La vivienda con el id: " + id + " no existe!");
                    } else {
                        scanner.nextLine();
                        System.out.println("Solo puede modificar el titular o la cantidad de habitantes");
                        ViviendaManager.modVivienda(viviendasArray, scanner, id);
                        JSONManager.writeJSON(viviendasArray);
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el id de la vivienda que quiere eliminar: ");
                    id = scanner.nextInt();
                    exists = ViviendaManager.idExists(viviendasArray, id);
                    if(!exists){
                        System.out.println("La vivienda con el id: " + id + " no existe");
                    } else {
                        scanner.nextLine();
                        ViviendaManager.eliminarVivienda(viviendasArray, id);
                        JSONManager.writeJSON(viviendasArray);
                    }
                    break;
                case 4:
                    System.out.print("Ingrese la calle de las viviendas que quiera buscar: ");
                    String calle = scanner.nextLine();
                    ViviendaManager.buscarCalle(viviendasArray, calle);
                    break;
                case 5:
                    System.out.print("Ingrese el nombre de la persona titular de las viviendas que quiera buscar: ");
                    String titular = scanner.nextLine();
                    ViviendaManager.buscarTitular(viviendasArray, titular);
                    break;
                case 6:
                    int cantViviendas = ViviendaManager.cantViviendas(viviendasArray);
                    System.out.println("La cantidad de viviendas es: " + cantViviendas);
                    break;
                case 7:
                    double promedio = ViviendaManager.promedioHabitantes(viviendasArray);
                    System.out.println("El promedio de habitantes por vivienda es: " + promedio);
                    break;
                case 0:
                    System.out.println("Cerrando menú...");
                    scanner.close();
                    break;
                default:
                    System.out.println("Elija una opción correcta");
                    break;
            }
        } while (opt != 0);


    }
}
