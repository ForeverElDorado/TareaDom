/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dom_sax_jaxb;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author aghsk
 */
public class SAX {

    SAXParser parser;
    ManejadorSAX sh;
    File ficheroXML;

    int abrir_XML_SAX(File fichero) {
        try {
            //Se crea un objeto SAXParser para interpetrar el documento XML 
            SAXParserFactory factory = SAXParserFactory.newInstance();
            parser = factory.newSAXParser();

            //Se crea una instancia del manejador que sera el que recorra el 
            //documento XML secuencialmente
            sh = new ManejadorSAX();

            ficheroXML = fichero;

            return 0;
        } catch (Exception e) {
            return -1;
        }

    }

    String recorrerSAX() {
        try {
            sh.cadena_resultado = "";
            parser.parse(ficheroXML, sh);
            return sh.cadena_resultado;
        } catch (SAXException ex) {
            return "Error al parsear con SAX";
        } catch (IOException ex) {
            return "Error al parsear con SAX";
        }
    }

}

class ManejadorSAX extends DefaultHandler {

    String cadena_resultado = "";

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        for (int i = start; i < length + start; i++) {
            cadena_resultado = cadena_resultado + ch[i];
        }
        cadena_resultado = cadena_resultado.trim() + "\n";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("Libro")) {
            cadena_resultado = cadena_resultado + "-------------------------\n";
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("Libro")) {
            cadena_resultado = cadena_resultado + "Publicado en: " + attributes.getValue(attributes.getQName(0).trim());
        } else if (qName.equals("Titulo")) {
            cadena_resultado = cadena_resultado + "El titulo es: ".trim();

        } else if (qName.equals("Libros")) {
            cadena_resultado = "----------------------\n Se van a mostrar los libros de este documento \n----------------------\n";

        } else if (qName.equals("Autor")) {
            cadena_resultado = cadena_resultado + "El autor es: ".trim();

        }

    }

}
