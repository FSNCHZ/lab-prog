import java.util.Scanner;

import org.json.simple.JSONArray;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JSONArray viviendasArray;
        int opt = 0;
        do {
            System.out.println("---- Menú de viviendas ----");
            System.out.println("1- Agregar viviendas");
            System.out.println("2- Actualizar vivienda por ID");
            System.out.println("3- Eliminar vivienda por ID");
            System.out.print("Elija una opción: ");
            opt = scanner.nextInt();
            switch (opt) {
                case 1:
                    viviendasArray = JSONManager.readJSON();
                    ViviendaManager.addVivienda(viviendasArray, scanner);
                    JSONManager.writeJSON(viviendasArray);
                    break;
                case 2:
                    viviendasArray = JSONManager.readJSON();
                    System.out.println("Ingrese el id de la vivienda que quiere modificar");
                    int id = scanner.nextInt();
                    boolean exists = ViviendaManager.idExists(viviendasArray, id);
                    if(!exists){
                        System.out.println("La vivienda con el id: " + id + " no existe!");
                    } else {
                        System.out.println("Solo puede modificar el titular o la cantidad de habitantes");
                        System.out.print("Ingrese el nombre del nuevo titular: ");
                        String titular = scanner.nextLine();
                        System.out.print("\nIngrese la nueva cantidad de habitantes: ");
                        int habitantes = scanner.nextInt();
                        ViviendaManager.modVivienda(viviendasArray, scanner, id, titular, habitantes);
                    }
                    break;
                case 3:

                    break;
                case 4:

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
