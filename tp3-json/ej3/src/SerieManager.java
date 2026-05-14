import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class SerieManager {
    public static void addSerie(JSONArray seriesArray, Scanner scanner) {
        JSONObject serie;
        int id;
        String titulo;
        String creador;
        int anio;
        int cantTemporadas;
        int[] episodiosTemporadas;
        String[] actores = new String[3];
        String[] generos = new String[3];
        String estado;
        double calificacion;

        System.out.print("Ingrese el id de la serie: ");
        id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("\nIngrese el titulo de la serie: ");
        titulo = scanner.nextLine();
        System.out.print("\nIngrese el creador de la serie: ");
        creador = scanner.nextLine();
        System.out.print("\nIngrese el año de creación de la serie: ");
        anio = scanner.nextInt();
        scanner.nextLine();
        System.out.print("\nIngrese la cantidad de temporadas de la serie: ");
        cantTemporadas = scanner.nextInt();
        scanner.nextLine();
        episodiosTemporadas = new int[cantTemporadas];
        for (int i = 1; i <= cantTemporadas; i++) {
            System.out.print("\nIngrese la cantidad de episodios de la temporada " + i + ": ");
            int episodios = scanner.nextInt();
            episodiosTemporadas[i-1] = episodios;
        }
        scanner.nextLine();
        for (int i = 0; i < actores.length; i++) {
            System.out.print("\nIngrese un actor de la serie: ");
            String actor = scanner.nextLine();
            actores[i] = actor;
        }
        for (int i = 0; i < generos.length; i++) {
            System.out.print("\nIngrese un genero de la serie: ");
            String genero = scanner.nextLine();
            generos[i] = genero;
        }
        System.out.println("\nIngrese el estado de la serie ('emision' o 'finalizada'):");
        estado = scanner.nextLine();
        System.out.print("\nIngrese la calificación de la serie: ");
        calificacion = scanner.nextDouble();
        serie = Serie.toJSON(id, titulo, creador, anio, cantTemporadas, episodiosTemporadas, actores,
            generos, estado, calificacion
        );
        seriesArray.add(serie);
    }
}
