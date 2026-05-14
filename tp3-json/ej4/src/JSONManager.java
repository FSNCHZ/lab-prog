import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONManager {
    //Retorna new JSONArray() en los casos que el JSON no tenga arrays

    public static JSONArray readJSON(){
        JSONParser jsonParser = new JSONParser();
        JSONArray series;
        try (FileReader archivo = new FileReader("./src/Streaming.json")){
            Object object = jsonParser.parse(archivo);
            if(object instanceof JSONArray){
                series = (JSONArray) object;
            } else {
                System.out.println("El JSON no tiene un array");
                return new JSONArray();
            }
            return series;
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


}
