package tp2.ej6.src;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import tp2.ej6.utils.Utils;

public class InformeXML {
    private Document docXML;
    private Document alumnosXML;
	
	public InformeXML () throws Exception {
		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factoria.newDocumentBuilder();
		docXML = builder.newDocument();
        alumnosXML = builder.parse("./tp2/ej6/src/Aprobados.xml");
	}

    public void generarDocumento(){
        //<informe>
        Element informe = docXML.createElement("informe");
        docXML.appendChild(informe);
        //<alumno>
        String nombre;
        String nota;
        Element root = alumnosXML.getDocumentElement();
        NodeList alumnos = root.getElementsByTagName("alumno");
        Element alumno, nombreElement, notaElement, promAlumnos;
        for(int i = 0; i < alumnos.getLength(); i++){
            //<alumno>
            alumno = docXML.createElement("alumno");
            informe.appendChild(alumno);
            //<nombre>
            nombre = Utils.getNombre(alumnos, i);
            nombreElement = docXML.createElement("nombre");
            alumno.appendChild(nombreElement);
            nombreElement.appendChild(docXML.createTextNode(nombre));
            //<nota>
            nota = String.valueOf(Utils.getNota(alumnos, i));
            notaElement = docXML.createElement("nota");
            alumno.appendChild(notaElement);
            notaElement.appendChild(docXML.createTextNode(nota));
        }

    }
    public void generarXML() throws Exception {
		Source origen = new DOMSource(docXML);
		File ruta = new File("./tp2/ej6/Informe.xml");
		FileWriter fw = new FileWriter(ruta);
		PrintWriter pw = new PrintWriter(fw);
		Result resultado = new StreamResult(pw);
		
		// genera el XML
		TransformerFactory factoria = TransformerFactory.newInstance();
		Transformer transfomer = factoria.newTransformer();
		transfomer.transform(origen, resultado);
		
	}

}
