import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JSONArray seriesArray = new JSONArray();

        for(int i = 0; i < 6; i++){
            SerieManager.addSerie(seriesArray, scanner);
        }

        JSONManager.writeJSON(seriesArray);

        System.out.println(seriesArray.toJSONString());

        scanner.close();
    }
}
