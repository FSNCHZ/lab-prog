import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ViviendaManager {

    public static boolean idExists(JSONArray viviendasArray, int id){
        for(Object object : viviendasArray){
            JSONObject vivienda = (JSONObject) object;
            long idVivienda = (long) vivienda.get("id");
            if(idVivienda == id){
                return true;
            }
        }
        return false;
    }

    private static JSONObject buscarID(JSONArray viviendasArray, int id) {
        for (Object object : viviendasArray) {
            JSONObject vivienda = (JSONObject) object;
            long idVivienda = (long) vivienda.get("id");
            if (idVivienda == id) {
                return vivienda;
            }
        }
        //Se verifica anteriormente que no exista la vivienda, por lo que nunca devuelve null, 
        //pero para que compile, se le agrega el return null
        return null;
    }

    public static void addVivienda(JSONArray viviendasArray, Scanner scanner) {
        JSONObject vivienda;
        int id;
        String calle;
        int nro;
        String titular;
        int habitantes;
        boolean exists;

        do {
            System.out.print("Ingrese el id de la vivienda: ");
            id = scanner.nextInt();
            exists = idExists(viviendasArray, id);
            if (exists) {
                System.out.println("Una vivienda con ese id ya existe");
            }
        } while (exists);

        scanner.nextLine();

        System.out.print("Ingrese la calle de la vivienda: ");
        calle = scanner.nextLine();
        System.out.print("Ingrese el número de la vivienda: ");
        nro = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el titular de la vivienda: ");
        titular = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Ingrese la cantidad de habitantes de la vivienda: ");
        habitantes = scanner.nextInt();
        scanner.nextLine();
        vivienda = Vivienda.toJSON(id, calle, nro, titular, habitantes);
        viviendasArray.add(vivienda);
    }

    public static void modVivienda(JSONArray viviendasArray, Scanner scanner, int id){
        JSONObject vivienda = buscarID(viviendasArray, id);
        System.out.print("Ingrese el nombre del nuevo titular: ");
        String nuevoTitular = scanner.nextLine();
        System.out.print("Ingrese la nueva cantidad de habitantes: ");
        int nuevoHabitantes = scanner.nextInt();
        vivienda = Vivienda.modVivienda(vivienda, nuevoTitular, nuevoHabitantes);
    }

    public static void eliminarVivienda(JSONArray viviendasArray, int id){
        Iterator<Object> iterador = viviendasArray.iterator();
        while(iterador.hasNext()){
            JSONObject vivienda = (JSONObject) iterador.next();
            long idVivienda = (long) vivienda.get("id");
            if(idVivienda == id){
                viviendasArray.remove(vivienda);
                break;
            }
        }
    }

    public static void buscarCalle(JSONArray viviendasArray, String calle){
        for (Object object : viviendasArray) {
            JSONObject vivienda = (JSONObject) object;
            String calleVivienda = (String) vivienda.get("calle");
            if (calleVivienda.equals(calle)) {
                System.out.println(vivienda.toJSONString());
            }
        }
    }

    public static void buscarTitular(JSONArray viviendasArray, String titular){
        for (Object object : viviendasArray) {
            JSONObject vivienda = (JSONObject) object;
            String titularVivienda = (String) vivienda.get("titular");
            if (titularVivienda.equals(titular)) {
                System.out.println(vivienda.toJSONString());
            }
        }
    }

    public static int cantViviendas(JSONArray viviendasArray){
        int cantViviendas = viviendasArray.size();
        return cantViviendas;
    }

    public static double promedioHabitantes(JSONArray viviendasArray){
        long cantHabitantes = 0;
        double promedio = 0;
        for(Object object : viviendasArray){
            JSONObject vivienda = (JSONObject) object;
            long habitantes = (long) vivienda.get("habitantes");
            cantHabitantes += habitantes;
        }
        promedio = (cantHabitantes / viviendasArray.size());
        return promedio;
    }
}
