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
