import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONManager {

    public static void writeJSON(JSONArray viviendasArray){
        try(FileWriter fw = new FileWriter("./src/viviendas.json");) {
            fw.write(viviendasArray.toJSONString());
            System.out.println("Archivo guardado");
        } catch (IOException e) {
            System.out.println("¡Error de escritura!");
        }
    }

    public static JSONArray readJSON(){
        JSONParser jsonParser = new JSONParser();
        JSONArray viviendas;
        try (FileReader archivo = new FileReader("./src/viviendas.json")){
            Object object = jsonParser.parse(archivo);
            if(object instanceof JSONArray){
                viviendas = (JSONArray) object;
            } else {
                System.out.println("El JSON no tiene un array");
                return new JSONArray();
            }
            return viviendas;
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no fue encontrado");
            return new JSONArray();
        } catch (IOException e) {
            System.out.println("¡Error en la lectura!");
            return new JSONArray();
        } catch (ParseException e) {
            System.out.println("Error en el parseo");
            return new JSONArray();
        }
    }

    public static void updateJSON(JSONArray viviendasArray){
        
    }
}
