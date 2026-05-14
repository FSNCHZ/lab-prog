import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JSONArray seriesArray = JSONManager.readJSON();
        for(Object object: seriesArray){
            SeriesManager.listInfo((JSONObject) object);
        }
        for(Object object: seriesArray){
            SeriesManager.cantActores((JSONObject) object);
        }
        for(Object object: seriesArray){
            SeriesManager.califMayorOcho((JSONObject) object);
        }
        System.out.print("Ingrese el actor y se mostrarán las series en la que actúe: ");
        String actor = scanner.nextLine();
        for(Object object: seriesArray){
            SeriesManager.buscarActor((JSONObject) object, actor);
        }
    }
}
