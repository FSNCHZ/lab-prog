package tp2.ej6;

import tp2.ej6.src.Informe;
import tp2.ej6.src.InformeXML;

public class Main{
    public static void main(String[] args) throws Exception{
        Informe inf = new Informe();
        InformeXML infXML = new InformeXML();
        inf.generarInforme();
        infXML.generarDocumento();
        infXML.generarXML();
    }
}