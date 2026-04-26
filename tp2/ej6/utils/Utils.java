package tp2.ej6.utils;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Utils {
    public static String getNombre(NodeList alumnos, int i){
        Element alumno = (Element) alumnos.item(i);
        String nombre = alumno.getElementsByTagName("nombre")
                                  .item(0)
                                  .getTextContent();
        return nombre;
    }

    public static int getNota(NodeList alumnos, int i){
        Element alumno = (Element) alumnos.item(i);
        String notaAux = alumno.getElementsByTagName("nota")
                                  .item(0)
                                  .getTextContent();
        int nota = Integer.parseInt(notaAux);
        return nota;
    }

    public static String getMateria(NodeList alumnos, int i){
        Element alumno = (Element) alumnos.item(i);
        String materia = alumno.getElementsByTagName("materia")
                                  .item(0)
                                  .getTextContent();
        return materia;
    }

    
}
