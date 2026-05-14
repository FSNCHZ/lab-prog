import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Vivienda {
    
    public static JSONObject toJSON(int id, String calle, int nro, String titular, int habitantes){
        JSONObject vivienda = new JSONObject();
        vivienda.put("id", id);
        vivienda.put("calle", calle);
        vivienda.put("nro", nro);
        vivienda.put("titular", titular);
        vivienda.put("habitantes", habitantes);
        return vivienda;
    }

}
