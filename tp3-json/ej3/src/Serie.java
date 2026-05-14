import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Serie {
    public static JSONObject toJSON(int id, String titulo, String creador, int anio, int cantTemporadas,
        int[] episodiosTemporadas, String[] actores, String[] generos, String estado, double calif
    ){
        JSONObject serie = new JSONObject();
        serie.put("id", id);
        serie.put("titulo", titulo);
        serie.put("creado", creador);
        serie.put("anio", anio);
        serie.put("cant-temporadas", cantTemporadas);
        serie.put("estado", estado);
        serie.put("calificacion", calif);
        JSONArray episodiosArray = new JSONArray();
        for(int episodios : episodiosTemporadas){
            episodiosArray.add(episodios);
        }
        serie.put("episodiosTemporadas", episodiosArray);
        JSONArray actoresArray = new JSONArray();
        for(String actor : actores){
            actoresArray.add(actor);
        }
        serie.put("actores", actoresArray);
        JSONArray generosArray = new JSONArray();
        for(String genero : generos){
            generosArray.add(genero);
        }
        serie.put("generos", generosArray);
        return serie;
    }
}
