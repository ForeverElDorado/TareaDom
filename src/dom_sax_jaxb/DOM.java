/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dom_sax_jaxb;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

/**
 *
 * @author aghsk
 */
public class DOM {

    //Objeto document donde se almacena el DOM del XML
    Document doc;

    public int abrir_XML_DOM(File fichero) {

        doc = null;
        try {
            //Aqui se crea un objeto DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //Ignora comentarios
            factory.setIgnoringComments(true);

            //Ignora espacios en blanco
            factory.setIgnoringElementContentWhitespace(true);

            //En este builder se carga la estructura de arbol del Dom a partir
            //del XML
            DocumentBuilder builder = factory.newDocumentBuilder();

            doc = builder.parse(fichero);
            //Ahora doc apunta al arbol DOM listo para recorrerse
            
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }

}
