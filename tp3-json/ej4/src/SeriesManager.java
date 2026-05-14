import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class SeriesManager {

    public static void listInfo(JSONObject object){
        
        JSONObject serie = (JSONObject)object.get("serie");
        String titulo = (String) serie.get("titulo");
        System.out.println("Titulo: " + titulo);
        long anio = (long) serie.get("anio");
        System.out.println("Año de creación: " + anio);
        long cantTemporadas = (long) serie.get("cant-temporadas");
        System.out.println("Cantidad de temporadas: " + cantTemporadas);
    }

    public static void cantActores(JSONObject object){
        JSONObject serie = (JSONObject)object.get("serie");
        JSONArray actores = (JSONArray)serie.get("actores");
        String titulo = (String) serie.get("titulo");
        System.out.println("Titulo: " + titulo);
        System.out.println("Cantidad de actores: " + actores.size());

    }

    public static void califMayorOcho(JSONObject object){
        JSONObject serie = (JSONObject)object.get("serie");
        double calif = (double) serie.get("calificacion");
        if(calif >= 8){
            String titulo = (String) serie.get("titulo");
            System.out.println("Titulo: " + titulo);
            System.out.println("Calificación: " + calif);
        }

    }

    public static void buscarActor(JSONObject object, String actor){
        JSONObject serie = (JSONObject)object.get("serie");
        JSONArray actores = (JSONArray)serie.get("actores");
        for(int i = 0; i < actores.size(); i++){
            String actorAux = (String)actores.get(i);
            if(actorAux.equals(actor)){
                String titulo = (String)serie.get("titulo");
                System.out.println("Titulo: " + titulo);
                break;
            }
        }
    }
}
