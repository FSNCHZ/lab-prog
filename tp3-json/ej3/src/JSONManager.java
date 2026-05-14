import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;

public class JSONManager {
    public static void writeJSON(JSONArray seriesArray){
        try(FileWriter fw = new FileWriter("./src/series.json");) {
            fw.write(seriesArray.toJSONString());
            System.out.println("Archivo guardado");
        } catch (IOException e) {
            System.out.println("¡Error de escritura!");
        }
    }
}
