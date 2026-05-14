import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ViviendaManager {

    public static boolean idExists(JSONArray viviendasArray, int id){
        for(Object object : viviendasArray){
            JSONObject vivienda = (JSONObject) object;
            if((long) vivienda.get("id") == id){
                return true;
            }
        }
        return false;
    }

    public static JSONObject buscarID(JSONArray viviendasArray, int id){
        if(!idExists(viviendasArray, id)){
            System.out.println("La vivienda no existe");
            
        }
    }

    public static void addVivienda(JSONArray viviendasArray, Scanner scanner) {
        JSONObject vivienda;
        int id;
        String calle;
        int nro;
        String titular;
        int habitantes;
        boolean idExists;

        do {
            System.out.print("Ingrese el id de la vivienda: ");
            id = scanner.nextInt();
            idExists = idExists(viviendasArray, id);
            if (idExists) {
                System.out.println("Una vivienda con ese id ya existe");
            }
        } while (idExists);

        scanner.nextLine();

        System.out.print("\nIngrese la calle de la vivienda: ");
        calle = scanner.nextLine();
        System.out.print("\nIngrese el número de la vivienda: ");
        nro = scanner.nextInt();
        scanner.nextLine();
        System.out.print("\nIngrese el titular de la vivienda: ");
        titular = scanner.nextLine();
        scanner.nextLine();
        System.out.print("\nIngrese la cantidad de habitantes de la vivienda: ");
        habitantes = scanner.nextInt();
        scanner.nextLine();
        vivienda = Vivienda.toJSON(id, calle, nro, titular, habitantes);
        viviendasArray.add(vivienda);
    }

    public static void modVivienda(JSONArray viviendasArray, Scanner scanner, int id, String nuevoTitular, 
    int nuevoHabitantes){

    }
}
