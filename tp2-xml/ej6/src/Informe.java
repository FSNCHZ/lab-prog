/**
 * <p>Se presenta la clase Informe, la cual permite generar un informe de alumnos a partir de un archivo xml de alumnos</p>
 * El programa utiliza DocumentBuilder y DocumentBuilderFactory para realizar dicho informe
 */

package tp2.ej6.src;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import tp2.ej6.utils.Utils;

public class Informe {
    private Document docXML;

    public Informe () throws Exception{
        DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factoria.newDocumentBuilder();
        docXML = builder.parse("./tp2/ej6/src/Aprobados.xml");
    }

    /**
     * Imprime los datos (nombre, materia, nota y promedio) del alumno por pantalla
     * Lee etiqueta <alumno> (NodeList alumnos) a partir de la etiqueta <alumnos>(Element root)
     * A partir de cada etiqueta <alumno>, lee las etiquetas <nombre>, <materia> y <nota> y los imprime por pantalla
     * @see promAlumnos
     */

    public void generarInforme(){
        String nombre, materia;
        int nota;
        Element root = docXML.getDocumentElement();
        NodeList alumnos = root.getElementsByTagName("alumno");
        for(int i = 0; i < alumnos.getLength(); i++){
            //Nombre
            nombre = Utils.getNombre(alumnos, i);
            System.out.println("Nombre: "+ nombre);
            //Materia
            materia = Utils.getMateria(alumnos, i);
            System.out.println("Materia: "+ materia);
            //Nota
            nota = Utils.getNota(alumnos, i);
            System.out.println("Nota: "+nota);
            System.out.println("---------o---------");
        }
        System.out.println("Promedio de los alumnos: " + this.promAlumnos());
    }

    /**
     * Método privado que calcula el promedio de los alumnos
     * Lee las etiquetas <nota> del alumno, y calcula el promedio
     * @return promedio 
     */

    private int promAlumnos(){
        int suma = 0;
        int promedio = 0;
        Element root = docXML.getDocumentElement();
        NodeList notas = root.getElementsByTagName("nota");
        for(int i = 0; i < notas.getLength(); i++){
            String notaAux = notas.item(0)
                                  .getTextContent();
            int nota = Integer.parseInt(notaAux);
            suma += nota;
        }
        promedio = suma/notas.getLength();
        return promedio;
    }
}
